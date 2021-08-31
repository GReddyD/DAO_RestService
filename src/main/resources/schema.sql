--Создание таблицы CUSTOMERS
CREATE TABLE netology.public.CUSTOMERS (
                      id INT GENERATED ALWAYS AS IDENTITY,
                      name VARCHAR(256),
                      surname VARCHAR(256),
                      age INT,
					  phone_number VARCHAR(15),
					  PRIMARY KEY (id));

--Вставка записей в таблицу CUSTOMERS для проверки
INSERT INTO netology.public.CUSTOMERS (name, surname, age, phone_number)
values ('alexey', 'nontos', 25, '79686341698');
INSERT INTO netology.public.CUSTOMERS (name, surname, age, phone_number)
values ('Aleksander', 'nontos2', 45, '79686341699');


--Создание таблицы ORDERS
CREATE TABLE netology.public.ORDERS (
                      id INT GENERATED ALWAYS AS IDENTITY,
                      date TIMESTAMP,
                      customer_id INT,
                      product_name VARCHAR(256),
                      amount INT,
                      PRIMARY KEY (id),
                      FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id));


--Вставка записей в таблицу ORDERS для проверки
INSERT INTO netology.public.ORDERS (date, customer_id, product_name, amount)
values (TIMESTAMP '2011-05-16 15:00:00', 1, 'продукт для alexey1', 10);
INSERT INTO netology.public.ORDERS (date, customer_id, product_name, amount)
values (TIMESTAMP '2011-05-17 16:00:00', 1, 'продукт для alexe2', 11);
INSERT INTO netology.public.ORDERS (date, customer_id, product_name, amount)
values (TIMESTAMP '2011-05-16 15:00:00', 2, 'продукт для Aleksander1', 1);
INSERT INTO netology.public.ORDERS (date, customer_id, product_name, amount)
values (TIMESTAMP '2011-05-17 16:00:00', 2, 'продукт для Aleksander2', 1);
