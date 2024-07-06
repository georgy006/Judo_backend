CREATE TABLE customers
(
    id bigserial CONSTRAINT customers_PK PRIMARY KEY,
    name varchar(256) NOT NULL,
    email varchar(256) NOT NULL,
    password varchar(256) NOT NULL,
    city varchar(256) NOT NULL,
    phone_number varchar(256) NOT NULL
);
CREATE TABLE orders
(
    id bigserial CONSTRAINT orders_PK PRIMARY KEY,
    orders_date timestamp NOT NULL,
    total_price decimal NOT NULL,
    status_id bigserial NOT NULL,
    customer_id bigserial NOT NULL
);
CREATE TABLE order_items
(
    id bigserial CONSTRAINT order_items_PK PRIMARY KEY,
    orders_id bigserial NOT NULL,
    products_id bigserial NOT NULL,
    quantity bigserial NOT NULL
);
CREATE TABLE products
(
    id bigserial CONSTRAINT products_PK PRIMARY KEY,
    product_name varchar(256) NOT NULL,
    price decimal NOT NULL,
    stock_quantity bigserial NOT NULL,
    category_id bigserial NOT NULL
);
CREATE TABLE categories
(
    id bigserial CONSTRAINT categories_PK PRIMARY KEY,
    name varchar(256) NOT NULL
);
CREATE TABLE order_statuses
(
    id bigserial CONSTRAINT statuses_PK PRIMARY KEY,
    name varchar(256) NOT NULL
);