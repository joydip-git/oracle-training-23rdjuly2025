--create table products(
--    product_id int not null,
--    product_name VARCHAR(50) not null,
--    product_price DECIMAL(18,2) default 0,
--    product_desc VARCHAR(500),
--    product_released_on date,
--    constraint pk_product_id  primary key (product_id)
--);

create table products(
    product_id int not null,
    product_name VARCHAR(50) not null,
    product_price DECIMAL(18,2) default 0,
    product_desc VARCHAR(500),
    product_released_on date
);
alter table products
add constraint pk_product_id primary key (product_id);

create table categories(
    category_id int not null,
    category_name varchar2(50) not null,
    CONSTRAINT pk_categories_category_id primary key (category_id)
);

alter table products
add category_id int;

alter table products
add constraint fk_products_category_id foreign key (category_id) references categories (category_id);

drop table products;