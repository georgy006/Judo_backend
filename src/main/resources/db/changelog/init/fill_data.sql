INSERT INTO categories (name) VALUES
('Дзюдоги'),
('Пояса'),
('Маты'),
('Аксессуары');

INSERT INTO products (productName, price, stockQuantity, categoryId) VALUES
('Белый дзюдоги', 5000, 20, 1),
('Синий дзюдоги', 5500, 15, 1),
('Черный пояс', 1000, 50, 2),
('Маты для татами', 15000, 5, 3),
('Сумка для дзюдо', 3000, 25, 4);

INSERT INTO customers (name, email, city, phoneNumber) VALUES
('Иван Иванов', 'ivan.ivanov@example.com', 'Москва', '+7-495-123-4567'),
('Мария Смирнова', 'maria.smirnova@example.com', 'Санкт-Петербург', '+7-812-765-4321'),
('Алексей Петров', 'alexey.petrov@example.com', 'Новосибирск', '+7-383-555-1234');

INSERT INTO order_statuses (name) VALUES
('Завершен'),
('В ожидании'),
('Отправлен');

INSERT INTO orders (ordersDate, totalPrice, statusId, customerId) VALUES
('2024-01-15 10:00:00', 10500, 1, 1),
('2024-02-20 15:30:00', 8500, 2, 2),
('2024-03-10 09:45:00', 3000, 3, 3);

INSERT INTO order_items (ordersId, productsId, quantity) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 3, 5),
(2, 4, 1),
(3, 5, 1);
