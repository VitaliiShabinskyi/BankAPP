-- Вставка данных в таблицу manager с UUID
INSERT INTO manager (first_name, last_name, status) VALUES
('Doe', 1),
('Smith', 1),
('Johnson', 1),
('Brown', 1),
-- Добавьте еще нужное количество записей здесь
;

-- Вставка данных в таблицу client с UUID
INSERT INTO client (id, manager_id, status, tax_code, first_name, last_name, email, address, phone) VALUES
(UUID(), 1, 1, '1234567890', 'Alice', 'Johnson', 'alice@example.com', '123 Main St', '555-555-5555'),
(UUID(), 2, 1, '0987654321', 'Bob', 'Smith', 'bob@example.com', '456 Elm St', '555-123-4567'),
(UUID(), 3, 1, '1122334455', 'Charlie', 'Doe', 'charlie@example.com', '789 Oak St', '555-789-1234'),
(UUID(), 1, 1, '9876543210', 'David', 'Wilson', 'david@example.com', '321 Pine St', '555-987-6543'),
-- Добавьте еще нужное количество записей здесь
;

-- Вставка данных в таблицу product с UUID
INSERT INTO product (manager_id, name, status, currency_code, interest_rate, `limit`) VALUES
(1, 'Savings Account', 1, 1, 0.02, 10000),
(2, 'Checking Account', 1, 1, 0.01, 5000),
(3, 'Fixed Deposit', 1, 1, 0.03, 20000),
(1, 'Credit Card', 1, 1, 0.12, NULL),
-- Добавьте еще нужное количество записей здесь
;

-- Вставка данных в таблицу account с UUID
INSERT INTO account (id, client_id, name, type, status, balance, currency_code) VALUES
(UUID(), UUID(), 'Alice\'s Savings', 1, 1, 5000.00, 1),
(UUID(), UUID(), 'Bob\'s Checking', 2, 1, 2500.00, 1),
(UUID(), UUID(), 'Charlie\'s Fixed Deposit', 3, 1, 10000.00, 1),
(UUID(), UUID(), 'David\'s Credit Card', 4, 1, -500.00, 1),
-- Добавьте еще нужное количество записей здесь
;

-- Вставка данных в таблицу agreement с UUID
INSERT INTO agreement (account_id, product_id, interest_rate, status, sum) VALUES
(UUID(), UUID(), 0.02, 1, 5000.00),
(UUID(), UUID(), 0.01, 1, 2500.00),
(UUID(), UUID(), 0.03, 1, 10000.00),
(UUID(), UUID(), 0.12, 1, 500.00),
-- Добавьте еще нужное количество записей здесь
;

-- Вставка данных в таблицу transaction с UUID
INSERT INTO transaction (id, debit_account_id, credit_account_id, type, amount, description) VALUES
(UUID(), UUID(), UUID(), 1, 1000.00, 'Payment'),
(UUID(), UUID(), UUID(), 2, 500.00, 'Withdrawal'),
(UUID(), UUID(), UUID(), 1, 200.00, 'Deposit'),
(UUID(), UUID(), UUID(), 2, 300.00, 'Withdrawal'),
-- Добавьте еще нужное количество записей здесь
;
