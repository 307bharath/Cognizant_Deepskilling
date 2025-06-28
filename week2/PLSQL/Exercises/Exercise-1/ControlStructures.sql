--Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
DECLARE
    CURSOR senior_customers IS
        SELECT c.CustomerID
        FROM Customers c
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60;

BEGIN
    FOR cust IN senior_customers LOOP
        -- Apply 1% discount to their loan interest rates
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;

        UPDATE Customers
        SET LastModified = SYSDATE
        WHERE CustomerID = cust.CustomerID;
    END LOOP;

    COMMIT;
END;
/
--Query to check the loans updated or not
SELECT c.CustomerID, c.Name, ROUND(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age,
       l.LoanID, l.InterestRate
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID
WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60;


--Scenario 2: A customer can be promoted to VIP status based on their balance.
--Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
SELECT * FROM Customers;
ALTER TABLE Customers ADD IsVIP VARCHAR2(5);

BEGIN
    FOR cust_rec IN (
        SELECT CustomerID, Balance
        FROM Customers
    ) LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

/*Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.*/

SET SERVEROUTPUT ON;
BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name, c.Balance
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('🔔 Reminder: Dear ' || loan_rec.Name || 
                             ', your loan (Loan ID: ' || loan_rec.LoanID || 
                             ') is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY') || 
                             '. Please ensure timely payment.');
    END LOOP;
END;
/