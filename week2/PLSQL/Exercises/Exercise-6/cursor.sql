/*
Scenario 1: Generate monthly statements for all customers.
Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer.
*/
-- SCENARIO 1: Monthly Statements
SET SERVEROUTPUT ON;

DECLARE
  CURSOR GenerateMonthlyStatements IS
    SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
    ORDER BY c.CustomerID, t.TransactionDate;

  v_cust_id Customers.CustomerID%TYPE;
  v_name Customers.Name%TYPE;
  v_date Transactions.TransactionDate%TYPE;
  v_amount Transactions.Amount%TYPE;
  v_type Transactions.TransactionType%TYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Monthly Statement ---');
  OPEN GenerateMonthlyStatements;
  LOOP
    FETCH GenerateMonthlyStatements INTO v_cust_id, v_name, v_date, v_amount, v_type;
    EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' | Date: ' || v_date || 
                         ' | Type: ' || v_type || ' | Amount: ' || v_amount);
  END LOOP;
  CLOSE GenerateMonthlyStatements;
END;
/


/*
Scenario 2: Apply annual fee to all accounts.
o Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts.
*/
SET SERVEROUTPUT ON;

DECLARE
  CURSOR ApplyAnnualFee IS
    SELECT AccountID, Balance FROM Accounts;

  v_account_id Accounts.AccountID%TYPE;
  v_balance Accounts.Balance%TYPE;

  annual_fee CONSTANT NUMBER := 100;
BEGIN
  OPEN ApplyAnnualFee;
  LOOP
    FETCH ApplyAnnualFee INTO v_account_id, v_balance;
    EXIT WHEN ApplyAnnualFee%NOTFOUND;

    UPDATE Accounts
    SET Balance = Balance - annual_fee,
        LastModified = SYSDATE
    WHERE AccountID = v_account_id;

    DBMS_OUTPUT.PUT_LINE('Annual fee applied to Account ID: ' || v_account_id);
  END LOOP;
  CLOSE ApplyAnnualFee;
  COMMIT;
END;
/
select * from Accounts;

/*
Scenario 3: Update the interest rate for all loans based on a new policy.
 Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.
*/
SET SERVEROUTPUT ON;

DECLARE
  CURSOR UpdateLoanInterestRates IS
    SELECT LoanID, LoanAmount, InterestRate FROM Loans;

  v_loan_id Loans.LoanID%TYPE;
  v_loan_amt Loans.LoanAmount%TYPE;
  v_rate Loans.InterestRate%TYPE;
BEGIN
  OPEN UpdateLoanInterestRates;
  LOOP
    FETCH UpdateLoanInterestRates INTO v_loan_id, v_loan_amt, v_rate;
    EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

    IF v_loan_amt < 10000 THEN
      UPDATE Loans
      SET InterestRate = InterestRate + 0.5
      WHERE LoanID = v_loan_id;

    ELSIF v_loan_amt BETWEEN 10000 AND 50000 THEN
      UPDATE Loans
      SET InterestRate = InterestRate + 0.25
      WHERE LoanID = v_loan_id;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' updated.');
  END LOOP;
  CLOSE UpdateLoanInterestRates;
  COMMIT;
END;
/

-- Check updated interest rates
SELECT * FROM Loans;
