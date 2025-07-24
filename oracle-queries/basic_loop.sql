/*
set SERVEROUTPUT on;
DECLARE
    l_counter NUMBER :=0;
BEGIN
    LOOP
        l_counter := l_counter+1;
            IF l_counter >3 THEN
                EXIT;
            END IF;
            dbms_output.put_line('inside loop: ' || l_counter);
    END LOOP;
    dbms_output.put_line('after loop: ' || l_counter);
END;
*/

set SERVEROUTPUT on;
DECLARE
    l_counter NUMBER :=0;
BEGIN
    LOOP
        l_counter := l_counter+1;
        EXIT WHEN l_counter>3;    
        dbms_output.put_line('inside loop: ' || l_counter);
    END LOOP;
    dbms_output.put_line('after loop: ' || l_counter);
END;