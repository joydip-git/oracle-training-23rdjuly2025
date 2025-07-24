set serveroutput on;

declare
    c_grade CHAR(1);
    c_rank VARCHAR2(20);
begin
    c_grade :='B';
    CASE c_grade
    WHEN 'A' THEN
        c_rank :='Excellent';
    WHEN 'B' THEN
        c_rank :='Very Good';
    WHEN 'C' THEN
        c_rank :='Good';
    ELSE
        c_rank := 'NA';
    END CASE;
    dbms_output.put_line(c_rank);
end;