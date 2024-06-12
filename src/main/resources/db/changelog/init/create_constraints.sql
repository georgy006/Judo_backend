ALTER TABLE products
    ADD CONSTRAINT categoryId_FK FOREIGN KEY (categoryId)
        REFERENCES categories (id);

ALTER TABLE orders
    ADD CONSTRAINT customerId_FK FOREIGN KEY (customerId)
        REFERENCES customers (id);

ALTER TABLE orders
    ADD CONSTRAINT statusId_FK FOREIGN KEY (statusId)
        REFERENCES order_statuses (id);

ALTER TABLE order_items
    ADD CONSTRAINT ordersId_FK FOREIGN KEY (ordersId)
        REFERENCES orders (id);

ALTER TABLE order_items
    ADD CONSTRAINT productsId_FK FOREIGN KEY (productsId)
        REFERENCES products (id);
