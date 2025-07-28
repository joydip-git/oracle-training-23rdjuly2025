DECLARE
TYPE numbers IS TABLE OF PLS_INTEGER
INDEX BY PLS_INTEGER;
int_numbers numbers;
i PLS_INTEGER;
BEGIN
    int_numbers(1) :=10;
    int_numbers(0) :=20;
    int_numbers(2) :=30;
    
    i := int_numbers.FIRST;
    WHILE i IS NOT NULL LOOP
     dbms_output.put_line(int_numbers(i));
     i := int_numbers.NEXT(i);
    END LOOP;    
END;