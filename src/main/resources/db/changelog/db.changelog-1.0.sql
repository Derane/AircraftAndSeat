--liquibase formatted sql

--changeset sierhieiev:1
CREATE TABLE aircraft
(
    id SERIAL PRIMARY KEY ,
    model VARCHAR(128) NOT NULL
);

--changeset sierhieiev:2
CREATE TABLE seat
(
    id SERIAL PRIMARY KEY,
    aircraft_id INT REFERENCES aircraft (id),
    seat_no VARCHAR(4) NOT NULL
);