CREATE TABLE Customers (
CustomerID NUMBER PRIMARY KEY,
Name VARCHAR2(100),
DOB DATE,
Balance NUMBER,
LastModified DATE
);

--Insert sample data into Customers table
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 15300, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Alice Johnson', TO_DATE('1950-03-10', 'YYYY-MM-DD'), 20000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (4, 'Bob Brown', TO_DATE('1958-11-25', 'YYYY-MM-DD'), 25000, SYSDATE); 
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (5, 'Charlie White', TO_DATE('1960-01-30', 'YYYY-MM-DD'), 32000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (6, 'Diana Green', TO_DATE('1963-09-05', 'YYYY-MM-DD'), 35000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (7, 'Ethan Black', TO_DATE('1992-12-15', 'YYYY-MM-DD'), 40070, SYSDATE);  
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (8, 'Fiona Blue', TO_DATE('1980-04-22', 'YYYY-MM-DD'), 12000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (9, 'George Yellow', TO_DATE('1987-08-18', 'YYYY-MM-DD'), 5000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (10, 'Hannah Purple', TO_DATE('1993-06-30', 'YYYY-MM-DD'), 5500, SYSDATE);

UPDATE Customers c
SET Balance = (
    SELECT a.Balance
    FROM Accounts a
    WHERE a.CustomerID = c.CustomerID
)
WHERE EXISTS (
    SELECT 1
    FROM Accounts a
    WHERE a.CustomerID = c.CustomerID
);
SELECT * FROM Customers;
DELETE FROM Customers;