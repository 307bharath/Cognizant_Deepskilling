--Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.

--Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
BEGIN
    -- Declare a variable to hold the result of the query
    DECLARE
        v_age NUMBER;
    CURSOR c_customers IS 
        SELECT Name, TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) AS Age
        FROM Customers
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60;
    BEGIN
        FOR rec IN c_customers LOOP
            v_age := rec.Age; -- Get the age of the customer
            -- Assuming there's a Loans table with a column for interest rate
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ', Age: ' || v_age || ', Interest Rate updated.');
        END LOOP;
    END;
END;

SET SERVEROUTPUT ON;
DECLARE
  v_name VARCHAR2(100);
BEGIN
  FOR rec IN (
    SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.LoanID || ' for customer ' || rec.Name || ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/