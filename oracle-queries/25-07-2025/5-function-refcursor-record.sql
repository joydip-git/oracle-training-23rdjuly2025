create or replace function get_employees(
managerid IN number, total out number) return SYS_REFCURSOR
is
 type employee_record is record(
    emp_id number,
    full_name varchar2(50),
    email varchar2(50)
 );
 type emp_cursor is ref cursor return employee_record;
 c_emp_record emp_cursor;
begin
    select count(employee_id) into total from employees;
    open c_emp_record for SELECT employee_id, concat(first_name,concat(' ',last_name)) as full_name, 
      email FROM employees WHERE manager_id =  managerid ORDER BY first_name, last_name;
    return c_emp_record;
end;

set serveroutput on;
declare 
type employee_rseult_record is record(
    empid number,
    fullname varchar2(50),
    email varchar2(50)
 );
c_result SYS_REFCURSOR;
l_result_row employee_rseult_record;
l_count number;
begin
    c_result := GET_EMPLOYEES(100,l_count);
    
    LOOP
        FETCH c_result into l_result_row;
        exit when c_result%notfound;
        
        dbms_output.put_line(l_result_row.empid||' '|| l_result_row.fullname||' '||l_result_row.email);
    END LOOP;
    
    dbms_output.put_line(l_count);
end;




