-- Insert sample customers
INSERT INTO customer (id, name, email, phone) VALUES (1, 'Roman', 'roman@gmail.com', '1234567890');
INSERT INTO customer (id, name, email, phone) VALUES (2, 'Sonu', 'sonu@gmail.com', '0987654321');

-- Insert sample loans
INSERT INTO loan (amount, tenure, interest_rate, customer_id) VALUES (150000.00, 50, 7.5, 1);
INSERT INTO loan (amount, tenure, interest_rate, customer_id) VALUES (200000.00, 36, 8.0, 2);
INSERT INTO loan (amount, tenure, interest_rate, customer_id) VALUES (100000.00, 24, 6.5, 1);
