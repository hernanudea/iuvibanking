CREATE TABLE users
(
    "id"         bigserial   NOT NULL,
    username     varchar(20) NOT NULL,
    password     varchar(32) NOT NULL,
    availability varchar(20) NULL,
    role         varchar(20) NULL,
    created_at   date NULL,
    updated_at   date NULL,
    created_user varchar(50) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT ch_users_availability CHECK (availability in ('ALLOWED', 'BLOCKED')),
    CONSTRAINT ch_users_role CHECK (role in ('USER', 'ADMIN'))
);

CREATE TABLE products
(
    "id"         bigserial   NOT NULL,
    full_name    varchar(50) NOT NULL,
    description  varchar(200) NULL,
    brand        varchar(30) NULL,
    category     varchar(30) NULL,
    supplier     varchar(30) NULL,
    weight       decimal NULL,
    dimension    decimal NULL,
    barcode      varchar(200) NULL,
    availability varchar(20) NULL,
    rating       decimal NULL,
    image_url    varchar(200) NULL,
    created_at   date NULL,
    updated_at   date NULL,
    created_user varchar(50) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id),
    CONSTRAINT ch_products_availability CHECK (availability in ('AVAILABLE', 'UNAVAILABLE'))
);

CREATE TABLE prices
(
    "id"                   bigserial                          NOT NULL,
    product_id             bigserial                          NOT NULL,
    availability           varchar(20) NULL,
    category               varchar(30) NULL,
    price                  double precision CHECK (price > 0) NOT NULL,
    initial_effective_date timestamp                          NOT NULL,
    end_effective_date     timestamp                          NOT NULL,
    created_at             date NULL,
    updated_at             date NULL,
    created_user           varchar(50) NULL,
    CONSTRAINT pk_prices PRIMARY KEY (id),
    CONSTRAINT fk_prices_products FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE NO ACTION,
    CONSTRAINT ch_prices_availability CHECK (availability in ('AVAILABLE', 'UNAVAILABLE'))
);

CREATE TABLE customers
(
    "id"         bigserial   NOT NULL,
    first_name   varchar(50) NOT NULL,
    last_name    varchar(50) NOT NULL,
    credit_card  varchar(32) NULL,
    birthday     date NULL,
    phone_number varchar(20) NOT NULL,
    email        varchar(40) NOT NULL unique,
    created_user varchar(50) NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE operations
(
    "id"           bigserial   NOT NULL,
    type_operation varchar(12) NOT NULL,
    customer_id    bigserial   NOT NULL,
    created_at     date NULL,
    updated_at     date NULL,
    created_user   varchar(50) NULL,
    CONSTRAINT pk_operations PRIMARY KEY (id),
    CONSTRAINT fk_operations_customer FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE RESTRICT,
    CONSTRAINT ch_operations CHECK (type_operation in ('ADDITION', 'SUBTRACTION'))
);


CREATE TABLE kardex
(
    "id"           bigserial   NOT NULL,
    product_id     bigserial   NOT NULL,
    operation_id   bigserial   NOT NULL,
    customer_id    bigserial   NOT NULL,
    cant           integer     NOT NULL,
    price_id       bigserial   NOT NULL,
    new_balance    integer     NOT NULL,
    created_at     date NULL,
    updated_at     date NULL,
    created_user   varchar(50) NULL,
    CONSTRAINT pk_kardex PRIMARY KEY (id),
    CONSTRAINT fk_kardex_products FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE RESTRICT,
    CONSTRAINT fk_kardex_customer FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE RESTRICT,
    CONSTRAINT fk_kardex_operations FOREIGN KEY (operation_id) REFERENCES operations (id) ON DELETE RESTRICT,
    CONSTRAINT fk_kardex_prices FOREIGN KEY (price_id) REFERENCES prices (id) ON DELETE RESTRICT
);

CREATE TABLE stocks
(
    "id"         bigserial NOT NULL,
    product_id   bigserial NOT NULL,
    new_balance  integer   NOT NULL,
    created_at   date NULL,
    updated_at   date NULL,
    created_user varchar(50) NULL,
    CONSTRAINT pk_stocks PRIMARY KEY (id),
    CONSTRAINT fk_stocks_products FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE SET NULL,
    CONSTRAINT ch_stock_balance CHECK (new_balance >= 0)
);


CREATE TABLE shopping_carts
(
    "id"         bigserial NOT NULL,
    product_id   bigserial NOT NULL,
    customer_id  bigserial NOT NULL,
    new_balance  integer   NOT NULL,
    cant         integer   NOT NULL,
    price_id     bigserial NOT NULL,
    created_at   date NULL,
    updated_at   date NULL,
    created_user varchar(50) NULL,
    CONSTRAINT pk_shopping_carts PRIMARY KEY (id),
    CONSTRAINT fk_carts_products FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE,
    CONSTRAINT fk_carts_customer FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE CASCADE,
    CONSTRAINT fk_carts_price FOREIGN KEY (price_id) REFERENCES prices (id) ON DELETE CASCADE
);


/*
drop table kardex ;
drop table stocks ;
drop table shopping_carts ;
drop table operations ;
drop table customers;
drop table prices ;
drop table products ;
drop table users ;

 */


/*
 select * from  users ;
select * from  customers;
select * from  operations ;
select * from  products ;
select * from  shopping_carts ;
select * from  stocks ;
select * from  kardex ;
select * from  prices ;
 */

