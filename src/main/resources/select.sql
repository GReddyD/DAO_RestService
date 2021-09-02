--Получаем поле product_name при условии фильтрации по имени
SELECT O.product_name
  FROM netology.public.ORDERS O
INNER JOIN netology.public.CUSTOMERS C
        ON C.id = O.customer_id
WHERE LOWER(C.name) = LOWER(:name);