--cursor <name> is <query>
set serveroutput on;
DECLARE
BEGIN
    FOR l_product_row IN (
    select * from products
    order by product_name desc
    )
    LOOP
    dbms_output.put_line(l_product_row.product_name);
    END LOOP;
END;

