--create or replace function get_product_count 
--return NUMBER
--is
--    l_count NUMBER:=0;
--begin
--    select count(product_name) into l_count from products;
--    return l_count;
--end;

declare
--    l_count_result number;
begin
    dbms_output.put_line(get_product_count());
end;