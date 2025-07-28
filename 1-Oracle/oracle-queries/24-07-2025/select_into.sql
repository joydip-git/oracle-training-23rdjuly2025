--SELECT INTO a single value
SET SERVEROUTPUT ON;
DECLARE
    l_product_name products.product_name%type;
BEGIN
    SELECT product_name 
    INTO l_product_name
    FROM products
    WHERE product_id=100;
    
    dbms_output.put_line(l_product_name);
END;