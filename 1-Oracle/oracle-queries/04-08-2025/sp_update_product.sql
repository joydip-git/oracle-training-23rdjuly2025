create or replace procedure update_product(
pid in products.product_id%type,
pname in products.product_name%type,
pprice in products.product_price%type,
pdesc in products.product_desc%type,
pdate in products.PRODUCT_RELEASED_ON%type,
cid in products.category_id%type,
query_result out int
)
is
begin
    update products set product_id=pid, product_name=pname, product_price=pprice, 
    product_released_on=pdate, product_desc=pdesc,category_id=cid 
    where product_id=pid;    
    commit;
    
    query_result :=1;
    
    EXCEPTION
        when others then
        query_result :=0;
        rollback;
end;