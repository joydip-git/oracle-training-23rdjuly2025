set serveroutput on;
declare
type r_product_category is record(
    productname products.product_name%type,
    price products.product_price%type,
    categoryname categories.category_name%type
);
type c_prod_cat_result is ref cursor return r_product_category;
c_data_row c_prod_cat_result;
l_data_row r_product_category;
begin
    open c_data_row for  
    select p.product_name, p.product_price, c.category_name 
    from products p 
    join categories c 
    on p.category_id=c.category_id;
    
    LOOP
     FETCH c_data_row INTO l_data_row;
     EXIT WHEN c_data_row%notfound;
     dbms_output.put_line(l_data_row.productname);
    END LOOP;
    close c_data_row;
end;

