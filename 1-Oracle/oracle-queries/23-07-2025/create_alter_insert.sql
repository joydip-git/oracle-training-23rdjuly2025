--products table

--a. setting constraint at table level
--create table products(
--    product_id int not null,
--    product_name VARCHAR(50) not null,
--    product_price DECIMAL(18,2) default 0,
--    product_desc VARCHAR(500),
--    product_released_on date,
--    constraint pk_product_id  primary key (product_id)
--);

--b. setting constraint after table creation
create table products(
    product_id int not null,
    product_name VARCHAR(50) not null,
    product_price DECIMAL(18,2) default 0,
    product_desc VARCHAR(500),
    product_released_on date
);

alter table products
add constraint pk_product_id primary key (product_id);

--categories table
create table categories(
    category_id int not null,
    category_name varchar2(50) not null,
    CONSTRAINT pk_categories_category_id primary key (category_id)
);

--adding a new column 
alter table products
add category_id int;

--setting forign key constraint
alter table products
add constraint fk_products_category_id foreign key (category_id) references categories (category_id);

--deleting table
--drop table products;

--insert query
insert into categories(category_id,category_name) values(1,'laptop');
insert into categories(category_id,category_name) values(2,'mobile');
insert into categories(category_id,category_name) values(3,'book');

insert into products(product_id, product_name, product_price, product_released_on, product_desc) values(100, 'dell xps 15', 120000.00, current_date,'new laptop from dell');
insert into products(product_id, product_name, product_price, product_released_on, product_desc) values(101, 'iphone 16', 70000.00, '23-JULY-2025','new phone from apple');
insert into products(product_id, product_name, product_price, product_released_on, product_desc) values(102, 'iphone 16', 70000.00, TO_DATE(sysdate,'YYYY-MM-DD'),'new phone from apple');

update products set product_name='Pillars of the Earth', product_price=699.00, product_desc='new book by Ken Follet' where product_id=102;

select * from products;
