CREATE TABLE Loans (
LoanID NUMBER PRIMARY KEY,
CustomerID NUMBER,
LoanAmount NUMBER,
InterestRate NUMBER,
StartDate DATE,
EndDate DATE,
FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 35));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 4.5, SYSDATE, ADD_MONTHS(SYSDATE, 10));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 3, 15000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 3));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (4, 4, 20000, 5.5, SYSDATE, ADD_MONTHS(SYSDATE, 8));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (5, 5, 25000, 4.8, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (6, 6, 30000, 5.2, SYSDATE, SYSDATE + 10); -- due in 10 days
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (7, 7, 35000, 4.9, SYSDATE, SYSDATE + 25); -- due in 25 days
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (8, 8, 40000, 5.1, SYSDATE, SYSDATE + 5);  -- due in 5 days
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (9, 9, 45000, 4.7, SYSDATE, ADD_MONTHS(SYSDATE, 12));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (10, 10, 50000, 5.3, SYSDATE, ADD_MONTHS(SYSDATE, 5));

SELECT * FROM Loans;
DELETE FROM Loans;