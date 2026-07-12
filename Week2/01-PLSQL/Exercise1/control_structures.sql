-- Exercise 1: Control Structures
SET SERVEROUTPUT ON;

DECLARE
    v_marks NUMBER := 78;
BEGIN
    IF v_marks >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('Grade A');
    ELSIF v_marks >= 75 THEN
        DBMS_OUTPUT.PUT_LINE('Grade B');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Grade C');
    END IF;

    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('Count: ' || i);
    END LOOP;
END;
/
