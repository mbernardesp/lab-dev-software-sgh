--CREATE DATABASE sgh;

CREATE TABLE room
(
    id BIGSERIAL,
    num VARCHAR(10) NOT NULL,
    _type VARCHAR(10) NOT NULL,
    _status VARCHAR(10) NOT NULL default 'checkout',
     PRIMARY KEY(id)
);

ALTER TABLE room 
ADD CONSTRAINT unique_num 
UNIQUE(num);

---------------------------------------------------------

CREATE TABLE guest
(
    id BIGSERIAL,
    id_room BIGINT,
    _name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    cpf VARCHAR(20),
    phone VARCHAR(20),
    PRIMARY KEY(id)
);

ALTER TABLE guest 
ADD CONSTRAINT fk_guest_room 
FOREIGN KEY (id_room) 
REFERENCES room (id) 
ON DELETE SET NULL;

ALTER TABLE guest
ADD CONSTRAINT unique_cpf 
UNIQUE(cpf);

---------------------------------------------------------

CREATE TABLE product
(
    id BIGSERIAL,
    id_room BIGINT,
    _name VARCHAR(100) NOT NULL,
    _code VARCHAR(20),
    PRIMARY KEY(id)
);

ALTER TABLE product
ADD CONSTRAINT unique_code 
UNIQUE(_code);

---------------------------------------------------------

CREATE TABLE room_product
(
    id_room BIGINT,
    id_product BIGINT,
    amount INT,
    PRIMARY KEY(id_room, id_product)
);

ALTER TABLE room_product 
ADD CONSTRAINT fk_room_product_room 
FOREIGN KEY (id_room) 
REFERENCES room (id) 
ON DELETE CASCADE;

ALTER TABLE room_product 
ADD CONSTRAINT fk_room_product_product 
FOREIGN KEY (id_product) 
REFERENCES product (id) 
ON DELETE CASCADE;

---------------------------------------------------------

--INSERT INTO room(id, num, _type, _status) VALUES (nextval('room_id_seq'), '602', 'luxe', 'checkout');
--INSERT INTO room(id, num, _type, _status) VALUES (nextval('room_id_seq'), '605', 'luxe', 'checkout');

--INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), 1,'Marcelo', '38', '11111111111', '35992033458');
--INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), 1,'Carina', '29', '22222222222', '35992568844');
--INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), null,'Tiago', '36', '33333333333', '35992356688');
--INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), null,'Luciene', '32', '44444444444', '35992534477');

--INSERT INTO product(id, id_room, _name, _code) VALUES (nextval('product_id_seq'), 1, 'Coca', '0025');
--INSERT INTO product(id, id_room, _name, _code) VALUES (nextval('product_id_seq'), 1, 'Pepsi', '0028');

--INSERT INTO room_product(id_room, id_product, amount) VALUES (1, 1, 10);
--INSERT INTO room_product(id_room, id_product, amount) VALUES (1, 2, 3);

--SELECT * FROM guest WHERE id_room = 1;
--SELECT * FROM roomguest WHERE id_room = 1;
--SELECT * FROM guest INNER JOIN room on guest.id_room = room.id WHERE num LIKE '60%';

--SELECT * FROM room INNER JOIN room_product ON room.id = room_product.id_room;

--SELECT * FROM room INNER JOIN room_product ON room.id = room_product.id_room 
--INNER JOIN product ON product.id = room_product.id_product;

--SELECT num, _status, _name, _code, amount FROM room INNER JOIN room_product ON room.id = room_product.id_room 
--INNER JOIN product ON product.id = room_product.id_product;

--SELECT * FROM guest INNER JOIN room ON room.id = guest.id_room;
--SELECT * FROM guest LEFT JOIN room ON room.id = guest.id_room;
--SELECT * FROM guest RIGHT JOIN room ON room.id = guest.id_room;

--update guest set id_room = null where id = 5;
