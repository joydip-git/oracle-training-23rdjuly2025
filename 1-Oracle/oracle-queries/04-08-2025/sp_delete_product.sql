create or replace procedure delete_product(
    pid in products.product_id%type,
    query_result out int
)
is
begin
    delete from products  
    where product_id=pid;    
    commit;
    
    query_result :=1;
    
    EXCEPTION
        when others then
        query_result :=0;
        rollback;
end;