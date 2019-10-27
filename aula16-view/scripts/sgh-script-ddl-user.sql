CREATE TABLE users
(
    id BIGSERIAL,
    _user VARCHAR(20) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    _name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    _level VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE users
ADD CONSTRAINT unique_user
UNIQUE(_user);