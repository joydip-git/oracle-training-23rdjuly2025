declare
--type c_products is ref cursor return products%rowtype;
--type c_products is ref cursor;
--c_data_row c_products;
c_data_row SYS_REFCURSOR;
l_product_row products%rowtype;
l_cat_row categories%rowtype; 
begin
    open c_data_row for select * from products;
     dbms_output.put_line(c_data_row%rowcount);
    LOOP
     FETCH c_data_row INTO l_product_row;
     EXIT WHEN c_data_row%notfound;
     dbms_output.put_line(c_data_row%rowcount);
     dbms_output.put_line(l_product_row.product_name);
    END LOOP;
    close c_data_row;
    
     open c_data_row for select * from categories;
    LOOP
     FETCH c_data_row INTO l_cat_row;
     EXIT WHEN c_data_row%notfound;
     dbms_output.put_line(c_data_row%rowcount);
     dbms_output.put_line(l_cat_row.category_name);
    END LOOP;
    close c_data_row;
end;

