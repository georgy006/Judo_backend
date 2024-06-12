CREATE TABLE customers
(
    id bigserial CONSTRAINT customers_PK PRIMARY KEY,
    name varchar(256) NOT NULL,
    email varchar(256) NOT NULL,
    city varchar(256) NOT NULL,
    phoneNumber varchar(256) NOT NULL
);
CREATE TABLE orders
(
    id bigserial CONSTRAINT orders_PK PRIMARY KEY,
    ordersDate timestamp NOT NULL,
    totalPrice decimal NOT NULL,
    statusId bigserial NOT NULL,
    customerId bigserial NOT NULL
);
CREATE TABLE order_items
(
    id bigserial CONSTRAINT order_items_PK PRIMARY KEY,
    ordersId bigserial NOT NULL,
    productsId bigserial NOT NULL,
    quantity bigserial NOT NULL
);
CREATE TABLE products
(
    id bigserial CONSTRAINT products_PK PRIMARY KEY,
    productName varchar(256) NOT NULL,
    price decimal NOT NULL,
    stockQuantity bigserial NOT NULL,
    categoryId bigserial NOT NULL
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