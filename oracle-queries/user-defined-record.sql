set serveroutput on;
declare
-- creating a record type
type r_product_category is record(
    productname products.product_name%type,
    price products.product_price%type,
    categoryname categories.category_name%type
);

--declare a record
r_prod_cat_info r_product_category;

begin
--  r_prod_cat_info.productname := 'sample product';
--  r_prod_cat_info.price := 1000;
--  r_prod_cat_info.categoryname :='some';

    select p.product_name, p.product_price, c.category_name 
    into r_prod_cat_info
    from products p 
    join categories c 
    on p.category_id=c.category_id 
    where p.product_id=100;
  
  dbms_output.put_line(r_prod_cat_info.productname || r_prod_cat_info.price);
end;

--TYPE address is record(
--    door_no varchar(10),
--    city datatype,
--    ...
--)
--type detils is record(
--    customername ,
--    ship_add address,
--    bill_add address,
--    mobile_no
--)

  