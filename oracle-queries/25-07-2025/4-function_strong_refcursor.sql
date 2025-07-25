--create or replace function get_products_stat
--return SYS_REFCURSOR
--as
--    type product_record is record(
--        max_price products.product_price%type,
--        min_price products.product_price%type
--    );
--    type c_product_result is ref cursor return product_record;
--    c_product_records c_product_result;
--begin
--    open c_product_records for select max(product_price) as maxprice, min(product_price) as minprice from products;
--    return c_product_records;
--end;

set serveroutput on;
declare
--     type product_record is record(
--        max_price products.product_price%type,
--        min_price products.product_price%type
--    );
--    type product_stat is record(
--        max_price products.product_price%type,
--        min_price products.product_price%type
--    );
    type product_stat is record(
        maxprice products.product_price%type,
        minprice products.product_price%type
    );
    c_result SYS_REFCURSOR;   
    l_result_row product_stat;
begin
    c_result := get_products_stat();
        
    LOOP
        FETCH c_result INTO l_result_row;
        EXIT WHEN c_result%notfound;
        
        dbms_output.put_line(l_result_row.maxprice||' '||l_result_row.minprice);
    END LOOP;
    
    close c_result;
end;
