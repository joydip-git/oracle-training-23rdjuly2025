create or replace procedure add_product(
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
    insert into products(product_id, product_name, product_price, product_released_on, product_desc,category_id) 
    values(pid,pname,pprice,pdate,pdesc,cid);
    commit;
    
    query_result :=1;
    
    EXCEPTION
        when others then
        query_result :=0;
        rollback;
end;