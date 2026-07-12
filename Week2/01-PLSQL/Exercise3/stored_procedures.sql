-- Exercise 3: Stored Procedure

CREATE OR REPLACE PROCEDURE get_bonus(
    p_salary IN NUMBER,
    p_bonus OUT NUMBER
)
AS
BEGIN
    p_bonus := p_salary * 0.10;
END;
/

DECLARE
    v_bonus NUMBER;
BEGIN
    get_bonus(50000, v_bonus);
    DBMS_OUTPUT.PUT_LINE('Bonus = ' || v_bonus);
END;
/
