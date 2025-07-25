--cursor <name> is <query>
set serveroutput on;
declare 
   CURSOR c_product IS
   select * from products
   order by product_name desc;
   
   l_product_row c_product%rowtype;
BEGIN
   open c_product;
   dbms_output.put_line(c_product%rowcount);
   
   LOOP
    FETCH c_product INTO l_product_row;
    EXIT WHEN c_product%notfound;
    dbms_output.put_line(c_product%rowcount);
    dbms_output.put_line(l_product_row.product_name);
   END LOOP;
   
   close c_product;
END;