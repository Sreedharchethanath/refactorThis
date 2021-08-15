DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_options;

create table product(
    id IDENTITY  NOT NULL AUTO_INCREMENT,
    product_name VARCHAR2(100) NOT NULL,
    description VARCHAR2(150),
    price DECIMAL(10,2),
    delivery_price DECIMAL(10,2),
    is_new BOOLEAN,
    PRIMARY KEY(id)
);

CREATE table product_options(
    id IDENTITY  NOT NULL AUTO_INCREMENT,
    product_id NUMBER,
    option_name varchar2(100),
    option_desc varchar2(100),
    foreign key (product_id) references product(id)
);

--DROP SEQUENCE IF EXISTS PRODUCT_ID_SEQ;

--CREATE SEQUENCE PRODUCT_ID_SEQ
--  MINVALUE 1
  --MAXVALUE 9999999999999999
 -- START WITH 1
  --INCREMENT BY 100
 -- CACHE 100;