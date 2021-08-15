insert into product(product_name, description, price, delivery_price, is_new) VALUES
    ('MacBook Pro','M1 Model Macbook',1500.00,5.00,'Y'),
    ('Dell XPS','13 inch version',1800,5.00,'Y'),
    ('Dell XPS','15 inch version',2300,5.00,'N');


insert into product_options(product_id,option_name,option_desc) values ('1','M1 15 inch', '15 inch M1 chip'),
('1','M1 13 inch','13 inch M1 chip'),
('3','XPS i7 processor', 'XPS  i7 processor');