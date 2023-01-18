
insert into aircraft (id, model)
values (1, 'Boeing 777-300'),
       (2, 'Boeing 737-300'),
       (3, 'Airbus A320-200'),
       (4, 'Superjet 100');

INSERT INTO seat(id, aircraft_id, seat_no)
VALUES (1, 1, 'A1'),
(2, 3, 'B1'),
(3, 2, 'C1'),
(4, 4, 'D1'),
(5, 1, 'B1'),
(6, 1, 'C1'),
(7, 2, 'B1'),
(8, 2, 'C1'),
(9, 2, 'D1'),
(10, 2, 'C1'),
(11, 2, 'D1'),
(12, 3, 'F5');
SELECT SETVAL('seat_id_seq', (SELECT MAX(id) FROM seat));