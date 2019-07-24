--CREATE DATABASE sgh;

CREATE TABLE room
(
    id BIGSERIAL PRIMARY KEY,
    num VARCHAR(10) NOT NULL,
    _type VARCHAR(10) NOT NULL,
    _status VARCHAR(10) NOT NULL default 'checkout'
);

CREATE TABLE guest
(
    id BIGSERIAL PRIMARY KEY,
    id_room BIGINT,
    _name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    phone VARCHAR(20)
);


--INSERT INTO room(id, num, _type, _status) VALUES (nextval('room_id_seq'), '602', 'luxe', 'checkout');
--INSERT INTO room(id, num, _type, _status) VALUES (nextval('room_id_seq'), '605', 'luxe', 'checkout');

--INSERT INTO public.guest(id, id_room, _name, age, phone) VALUES (nextval('guest_id_seq'), 1,'Marcelo', '38', '35992033441');
--INSERT INTO public.guest(id, id_room, _name, age, phone) VALUES (nextval('guest_id_seq'), 1,'Carina', '29', '35992568844');
--INSERT INTO public.guest(id, id_room, _name, age, phone) VALUES (nextval('guest_id_seq'), null,'Tiago', '36', '35992356688');
--INSERT INTO public.guest(id, id_room, _name, age, phone) VALUES (nextval('guest_id_seq'), null,'Luciene', '32', '35992534477');

--select * from guest inner join room on room.id = guest.id_room;
--select * from guest left join room on room.id = guest.id_room;
--select * from guest right join room on room.id = guest.id_room;

--update guest set id_room = null where id = 5;
