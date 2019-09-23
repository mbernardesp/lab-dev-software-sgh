--CREATE DATABASE hacktown;

CREATE TABLE schedule
(
    id BIGSERIAL,
    _type VARCHAR(10) NOT NULL,
    theme VARCHAR(20) NOT NULL,
    speaker VARCHAR(100) NOT NULL,
    place VARCHAR(100) NOT NULL,
    date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);
