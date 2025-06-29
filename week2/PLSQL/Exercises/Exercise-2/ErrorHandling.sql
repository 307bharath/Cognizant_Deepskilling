/*Scenario 1: Handle exceptions during fund transfers between accounts.
o Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.
*/

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check if from_account has sufficient funds
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account;

    -- Add to destination
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account;
    DBMS_OUTPUT.PUT_LINE('From Account New Balance: ' || (v_balance - p_amount));
    -- Record transactions
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_from_account, SYSDATE, p_amount, 'Withdrawal');
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_to_account, SYSDATE, p_amount, 'Deposit');

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END;
/
-- create sequence Transactions_seq
CREATE SEQUENCE Transactions_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
-- Example usage of the SafeTransferFunds procedure
-- Assuming Accounts table and Transactions table are already created and populated
-- You can execute the procedure like this:
BEGIN
    SafeTransferFunds(1, 5, 500);
END;
BEGIN
    SafeTransferFunds(1, 2, 1000);
END;

SELECT * FROM Transactions;
SELECT * FROM Accounts;

/*Scenario 2: Manage errors when updating employee salaries.

o Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.*/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage   IN NUMBER
) AS
    v_current_salary NUMBER;
BEGIN
    -- Get current salary
    SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_employee_id;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    DBMS_OUTPUT.PUT_LINE('Updated salary for employee ID ' || p_employee_id || ' to ' || (v_current_salary + (v_current_salary * p_percentage / 100)));
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_employee_id || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;
/
-- Example usage of the UpdateSalary procedure
BEGIN
    UpdateSalary(1, 10);
    UpdateSalary(132, 10); 
END;
SELECT * FROM Employees;


/*Scenario 3: Ensure data integrity when adding a new customer.

o Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.*/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('New customer added with ID: ' || p_customer_id);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error adding new customer: ' || SQLERRM);
END;
/
-- Example usage of the AddNewCustomer procedure
BEGIN
    AddNewCustomer(13, 'bharadwaj', TO_DATE('1986-05-21', 'YYYY-MM-DD'), 12000);
    AddNewCustomer(1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000);
END;
select * from Customers;
