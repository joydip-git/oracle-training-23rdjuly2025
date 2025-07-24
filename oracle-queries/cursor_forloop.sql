--cursor <name> is <query>
set serveroutput on;
declare 
   CURSOR c_product IS
   select * from products
   order by product_name desc;
   
   l_product_row c_product%rowtype;
BEGIN
  
   FOR l_product_row IN c_product
   LOOP
    dbms_output.put_line(l_product_row.product_name);
   END LOOP;
   
END;