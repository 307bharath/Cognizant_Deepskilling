/*
Scenario 1: Group all customer-related procedures and functions into a package.
o Question: Create a package CustomerManagement with procedures for adding a new customer, updating customer details, and a function to get customer balance.
*/
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/


CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE) IS
  BEGIN
    UPDATE Customers
    SET Name = p_name, DOB = p_dob, LastModified = SYSDATE
    WHERE CustomerID = p_id;
  END;

  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance
    FROM Customers
    WHERE CustomerID = p_id;
    RETURN v_balance;
  END;

END CustomerManagement;
/

-- Call procedure to add customer
BEGIN
  CustomerManagement.AddCustomer(12, 'smith', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 5000);
END;
/
-- Call function to get balance
DECLARE
  v_bal NUMBER;
BEGIN
  v_bal := CustomerManagement.GetCustomerBalance(12);
  DBMS_OUTPUT.PUT_LINE('Balance: ' || v_bal);
END;
/

SELECT * FROM Customers W;


/*
Scenario 2: Create a package to manage employee data.
o Question: Write a package EmployeeManagement with procedures to hire new employees, update employee details, and a function to calculate annual salary.
*/
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER, p_position VARCHAR2);
  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_department, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Employee ' || p_name || ' hired successfully.');
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER, p_position VARCHAR2) IS
  BEGIN
    UPDATE Employees
    SET Salary = p_salary, Position = p_position
    WHERE EmployeeID = p_id;
    DBMS_OUTPUT.PUT_LINE('Employee ' || p_id || ' updated successfully.');
  END;

  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary
    FROM Employees
    WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
    DBMS_OUTPUT.PUT_LINE('Annual Salary for Employee ' || p_id || ': ' || v_salary * 12);
  END;

END EmployeeManagement;
/
-- Call procedure to hire a new employee

BEGIN
  EmployeeManagement.HireEmployee(101, 'Alice', 'Manager', 80000, 'HR');
END;
/

-- Call procedure to update employee details
BEGIN
  EmployeeManagement.UpdateEmployee(101, 85000, 'Senior Manager');
END;
/
SELECT * FROM Employees WHERE EmployeeID = 101;

-- Call function to calculate annual salary
DECLARE
  v_annual_salary NUMBER;
BEGIN
  v_annual_salary := EmployeeManagement.CalculateAnnualSalary(101);
  DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual_salary);
END;
/

/*
Scenario 3: Group all account-related operations into a package.
o Question: Create a package AccountOperations with procedures for opening a new account, closing an account, and a function to get the total balance of a customer across all accounts.
*/

CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_id, p_cust_id, p_type, p_balance, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Account ' || p_id || ' opened for Customer ' || p_cust_id || ' with type ' || p_type);
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_id;
    DBMS_OUTPUT.PUT_LINE('Account ' || p_id || ' closed successfully.');
  END;

  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT NVL(SUM(Balance), 0) INTO v_total
    FROM Accounts
    WHERE CustomerID = p_cust_id;
    RETURN v_total;
    DBMS_OUTPUT.PUT_LINE('Total balance for Customer ' || p_cust_id || ': ' || v_total);
  END;

END AccountOperations;
/
-- Call procedure to open a new account
BEGIN
  AccountOperations.OpenAccount(201, 11, 'Savings', 8400);
END;
/
select * from ACCOUNTS where AccountID = 201;
-- Call procedure to close an account
BEGIN
  AccountOperations.CloseAccount(201);
END;
/
select * from ACCOUNTS where AccountID = 201;
-- Get total account balance for customer 11
DECLARE
  v_total NUMBER;
BEGIN
  v_total := AccountOperations.GetTotalBalance(11);
  DBMS_OUTPUT.PUT_LINE('Total Account Balance: ' || v_total);
END;
/
