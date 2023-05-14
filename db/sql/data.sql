INSERT INTO users (username, "password", availability, "role", created_at, updated_at, created_user)
VALUES ('hernan', '12345', 'ALLOWED', 'ADMIN', '2023-05-13', null, 'hernan'),
       ('samuel', '4567', 'ALLOWED', 'USER', '2023-05-13', null, 'hernan');


INSERT INTO customers (first_name, last_name, credit_card, birthday, phone_number, email, created_user)
VALUES ('Matias', 'Velasquez', '1234-1122-3334-1112-3333', '2013-10-30', '3122223344', 'mati.velasquez@gmail.com', 'hernan'),
       ('Eliana', 'Cuadros', '6644-1122-2222-3332-6603', '1992-08-04', '3195337788', 'eli.cuadros@gmail.com', 'hernan');


INSERT INTO operations (type_operation, customer_id, created_at, created_user)
VALUES ('ADDITION', 1, '2023-05-13', 'hernan'),
       ('ADDITION', 1, '2023-05-13', 'hernan'),
       ('SUBTRACTION', 2, '2023-05-13', 'hernan');


INSERT INTO public.products (full_name, description, brand, category, supplier, weight, dimension, barcode,
                             availability, rating, image_url, created_at, created_user)
VALUES ('Camiseta Logo Marvel', 'Camiseta talla única con logo Marvel', 'Marvel', 'ROPA', 'Proveedor 01', 1, 1,
        '77023232242334',
        'AVAILABLE', 5, 'https://static.dafiti.com.co/p/dc-shoes-7910-26856-1-product.jpg', '2023-05-13', 'hernan'),
       ('Camiseta Logo DC', 'Camiseta talla única con logo DC', 'DC', 'ROPA', 'Proveedor 01', 1, 1, '77023232234234',
        'AVAILABLE', 5, 'https://i.linio.com/p/e5d0a68906cb335ee0eb50361ad6dbae-product.webp', '2023-05-13', 'hernan'),
       ('Mug DC', 'Mug con logo DC', 'DC', 'ACCESORIOS', 'Proveedor 02', 1, 1, '7702323223454',
        'AVAILABLE', 5, 'https://www.abystyle.com/5864-large_default/dc-comics-tea-mug-harley-quinn-mad-love.jpg',
        '2023-05-13', 'hernan')
;

INSERT INTO public.prices (product_id, availability, category, price, initial_effective_date, end_effective_date,
                           created_at, created_user)
VALUES (1, 'AVAILABLE', 'ALL', 25000.0, '2023-05-13', '2025-05-13', '2023-05-13', 'hernan'),
       (2, 'AVAILABLE', 'ALL', 35000.0, '2023-05-13', '2025-05-13', '2023-05-13', 'hernan'),
       (3, 'AVAILABLE', 'ALL', 17000.0, '2023-05-13', '2025-05-13', '2023-05-13', 'hernan');


INSERT INTO public.shopping_carts (product_id, customer_id, new_balance, cant, price_id, created_at, created_user)
VALUES (1, 1, 10, 5, 1, '2023-05-13', 'samuel'),
       (2, 2, 8, 1, 2, '2023-05-13', 'samuel');


INSERT INTO public.stocks (product_id,new_balance,created_at,created_user)
VALUES (1,10,'2023-05-13','hernan'),
       (2,12,'2023-05-13','hernan'),
       (3,7,'2023-05-13','hernan');


INSERT INTO public.kardex (product_id,operation_id,customer_id,cant,price_id,new_balance,created_at,created_user)
VALUES (1,1,1,2,1,5,'2023-05-10','hernan'),
       (1,3,1,3,1,8,'2023-05-11','hernan'),
       (2,2,2,10,2,25,'2023-05-11','hernan'),
       (2,3,1,1,2,24,'2023-05-12','hernan');
