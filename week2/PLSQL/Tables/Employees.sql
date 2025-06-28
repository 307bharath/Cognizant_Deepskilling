CREATE TABLE Employees (
EmployeeID NUMBER PRIMARY KEY,
Name VARCHAR2(100),
Position VARCHAR2(50),
Salary NUMBER,
Department VARCHAR2(50),
HireDate DATE
);

--Insert sample data into Employees table
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Amit Sharma', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Priya Singh', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (3, 'Rahul Verma', 'Analyst', 55000, 'Finance', TO_DATE('2018-01-10', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (4, 'Sneha Patel', 'Designer', 50000, 'Marketing', TO_DATE('2019-05-25', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (5, 'Vikram Rao', 'Sales', 65000, 'Sales', TO_DATE('2020-02-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (6, 'Anjali Nair', 'Support', 48000, 'Customer Service', TO_DATE('2021-04-30', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (7, 'Karan Mehta', 'HR Assistant', 40000, 'HR', TO_DATE('2022-07-05', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (8, 'Pooja Desai', 'Marketing Specialist', 45000, 'Marketing', TO_DATE('2023-01-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (9, 'Suresh Reddy', 'IT Support', 42000, 'IT', TO_DATE('2023-03-10', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (10, 'Neha Gupta', 'Finance Assistant', 43000, 'Finance', TO_DATE('2023-05-20', 'YYYY-MM-DD'));
SELECT * FROM Employees;
commit;