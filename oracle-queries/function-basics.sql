--create or replace function addNumbers(
--firstValue PLS_INTEGER,
--secondValue PLS_INTEGER)
--return NUMBER
--IS
--    l_result NUMBER :=0;
--BEGIN
--    l_result := firstvalue+secondvalue;
--    return l_result;
--END;

set SERVEROUTPUT on;
declare
    l_add_result number:=0;
begin
    l_add_result := addNumbers(10,20);
    dbms_output.put_line(l_add_result);
end;