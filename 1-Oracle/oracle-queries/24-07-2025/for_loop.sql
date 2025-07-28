/*
SET SERVEROUTPUT ON;
BEGIN
    FOR l_counter IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(l_counter);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('after loop: '||l_counter);
END;
*/

--SET SERVEROUTPUT ON;
--DECLARE
--    l_counter PLS_INTEGER :=10;
--BEGIN
--    FOR l_counter IN 1..5
--    LOOP
--        DBMS_OUTPUT.PUT_LINE(l_counter);
--    END LOOP;
--    DBMS_OUTPUT.PUT_LINE('after the loop: '||l_counter);
--END;

SET SERVEROUTPUT ON;
BEGIN
    FOR l_counter IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(l_counter);
    END LOOP;
END;