INSERT INTO room(id, num, _type, _status, date_checkin, date_checkout) VALUES (nextval('room_id_seq'), '602', 'lux', 'checkin', NULL, NULL);
INSERT INTO room(id, num, _type, _status, date_checkin, date_checkout) VALUES (nextval('room_id_seq'), '605', 'std', 'checkout', NULL, NULL);

---------------------------------------------------------

INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), 1,'Marcelo', '38', '11111111111', '35992033458');
INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), 1,'Carina', '29', '22222222222', '35992568844');
INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), null,'Tiago', '36', '33333333333', '35992356688');
INSERT INTO guest(id, id_room, _name, age, cpf, phone) VALUES (nextval('guest_id_seq'), null,'Luciene', '32', '44444444444', '35992534477');

---------------------------------------------------------

INSERT INTO product(id, _name, _code) VALUES (nextval('product_id_seq'), 'Coca', '0025');
INSERT INTO product(id, _name, _code) VALUES (nextval('product_id_seq'), 'Pepsi', '0028');

---------------------------------------------------------

INSERT INTO room_product(id_room, id_product, amount) VALUES (1, 1, 10);
INSERT INTO room_product(id_room, id_product, amount) VALUES (1, 2, 3);

---------------------------------------------------------

SELECT * FROM guest WHERE id_room = 1;
SELECT * FROM room WHERE id = 1;
SELECT * FROM guest INNER JOIN room on guest.id_room = room.id WHERE num LIKE '60%';

---------------------------------------------------------

SELECT * FROM room INNER JOIN room_product ON room.id = room_product.id_room;

---------------------------------------------------------

SELECT * FROM room INNER JOIN room_product ON room.id = room_product.id_room 
    INNER JOIN product ON product.id = room_product.id_product;

SELECT num, _status, _name, _code, amount FROM room INNER JOIN room_product ON room.id = room_product.id_room 
    INNER JOIN product ON product.id = room_product.id_product;

SELECT * FROM guest INNER JOIN room ON room.id = guest.id_room;
SELECT * FROM guest LEFT JOIN room ON room.id = guest.id_room;
SELECT * FROM guest RIGHT JOIN room ON room.id = guest.id_room;

---------------------------------------------------------

UPDATE guest SET id_room = NULL WHERE id = 5;