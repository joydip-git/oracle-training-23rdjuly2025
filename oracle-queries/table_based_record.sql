--SELECT INTO a row
--table-based record
SET SERVEROUTPUT ON;
DECLARE
    l_product_record products%ROWTYPE;
BEGIN
    SELECT * 
    INTO l_product_record
    FROM products
    WHERE product_id=100;
    
    dbms_output.put_line(l_product_record.product_name ||' '||l_product_record.product_price);
END;