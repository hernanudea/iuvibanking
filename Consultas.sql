select * from ticket t ;

select * from reservation r ;

select * from customer c ;

SELECT * FROM reservation r ;

SELECT * FROM hotel h;

SELECT * FROM tour;


-- JPQL
select * from fly f  where f.price < 20.00;

select * from fly f where f.price between 10 and 15;

select * from fly f where f.origin_name = 'Grecia' and f.destiny_name = 'Mexico'; 