create table employees(
    employee_id number not null primary key,
    first_name varchar2(50) not null,
    last_name varchar2(50),
    email varchar2(50)
);

alter table employees
add manager_id number;

alter table employees
add constraint fk_emp_mng foreign key (manager_id) references employees(employee_id);  

insert into employees values(100,'anil', 'gupta','anil@gmail.com',null);
insert into employees values(101,'sunil', 'kumar','sunil@gmail.com',100);
insert into employees values(102,'vinod', 'k','vinod@gmail.com',100);
insert into employees values(103,'banu', 'prakash','banu@gmail.com',null);
insert into employees values(104,'joydip', 'mondal','joydip@gmail.com',103);
insert into employees values(105,'raj', 'bishnoi','raj@gmail.com',103);

select * from employees;

