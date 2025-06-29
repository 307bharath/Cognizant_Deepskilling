/*
Scenario 1: Automatically update the last modified date when a customer's record is updated.

o Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated.
*/
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/
 -- Test the trigger
-- Insert a test customer
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (12, 'John Doe', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 1000, SYSDATE);

UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 12;

SELECT * FROM Customers WHERE CustomerID = 12;



/*
Scenario 2: Maintain an audit log for all transactions.

o Question: Write a trigger LogTransaction that inserts a record into an AuditLog table whenever a transaction is inserted into the Transactions table.
*/
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    TransactionID, AccountID, TransactionDate,
    Amount, TransactionType, LoggedAt
  )
  VALUES (
    :NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate,
    :NEW.Amount, :NEW.TransactionType, SYSDATE
  );
END;
/
--Test the trigger

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'Alice', TO_DATE('1995-01-01', 'YYYY-MM-DD'), 5000, SYSDATE);
-- Insert required data into Accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (100, 1, 'Savings', 2000, SYSDATE);

-- Insert a transaction
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5001, 100, SYSDATE, 200, 'Deposit');

-- Check audit log
SELECT * FROM AuditLog WHERE TransactionID = 5001;


/
/*
Scenario 3: Enforce business rules on deposits and withdrawals.

o Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table.
*/
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = :NEW.AccountID;

  IF :NEW.TransactionType = 'Withdrawal' THEN
    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds account balance');
    END IF;
  END IF;

  IF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
    END IF;
  END IF;
END;
/

-- Test the trigger
--This will succeed
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5002, 100, SYSDATE, 100, 'Deposit');

-- Suppose balance is 2000, trying to withdraw 3000:
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5003, 100, SYSDATE, 3000, 'Withdrawal');
-- Error: ORA-20001: Withdrawal amount exceeds account balance

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5004, 100, SYSDATE, -50, 'Deposit');
-- Error: ORA-20002: Deposit amount must be positive