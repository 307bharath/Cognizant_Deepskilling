/*Scenario 1: Calculate the age of customers for eligibility checks.

o Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.

*/

CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
/*Example usage of CalculateAge function*/
SELECT CalculateAge(DOB) AS Age FROM Customers WHERE CustomerID BETWEEN 1 AND 10;

/*Scenario 2: The bank needs to compute the monthly installment for a loan.
o Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.
*/
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_loan_duration IN NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
BEGIN
    v_monthly_installment := (p_loan_amount * p_interest_rate / 100 / 12) /
                              (1 - POWER(1 + p_interest_rate / 100 / 12, -p_loan_duration * 12));

    RETURN v_monthly_installment;
END;
/
/*Example usage of CalculateMonthlyInstallment function*/
SELECT CalculateMonthlyInstallment(10000, 5, 2) AS MonthlyInstallment
FROM dual;

/*Scenario 3: Check if a customer has sufficient balance before making a transaction.

o Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.
*/
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
END;
/
/*Example usage of HasSufficientBalance function*/
DECLARE
    result BOOLEAN;
BEGIN
    result := HasSufficientBalance(1, 500);
    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance available.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/
DECLARE
    result BOOLEAN;
BEGIN
    result := HasSufficientBalance(1, 50000);
    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance available.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/