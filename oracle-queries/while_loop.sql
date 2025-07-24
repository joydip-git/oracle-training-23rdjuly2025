SET SERVEROUTPUT ON;
DECLARE
    l_counter NUMBER :=1;
BEGIN
     WHILE L_COUNTER <=5
     LOOP
        DBMS_OUTPUT.PUT_LINE(l_counter);
        l_counter := l_counter+1;
     END LOOP;
END;