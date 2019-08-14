--CREATE DATABASE sgh;

CREATE TABLE room
(
    id BIGSERIAL,
    num VARCHAR(10) NOT NULL,
    _type VARCHAR(10) NOT NULL,
    _status VARCHAR(10) NOT NULL default 'checkout',
    date_checkin TIMESTAMP WITHOUT TIME ZONE,
    date_checkout TIMESTAMP WITHOUT TIME ZONE,
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
    _code VARCHAR(20),
    _name VARCHAR(100) NOT NULL,
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