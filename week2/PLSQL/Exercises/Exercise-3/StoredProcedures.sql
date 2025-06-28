/*Scenario 1: The bank needs to process monthly interest for all savings accounts.
o Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.*/

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
END;
/
-- To execute the procedure and see the results
BEGIN
    ProcessMonthlyInterest;
END;

SELECT * FROM Accounts;

/*Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.

o Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.*/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_name IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department_name;

    COMMIT;
END;
/
-- To execute the procedure and see the results
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;

SELECT * FROM Employees;

/*Scenario 3: Customers should be able to transfer funds between their accounts.

o Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.*/
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check if the source account has sufficient balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    ELSE
        -- Proceed with the transfer
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account_id;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account_id;

        COMMIT;
    END IF;
END;
/
-- To execute the procedure and see the results
BEGIN
    TransferFunds(2, 3, 300);
END;
SELECT * FROM Accounts;