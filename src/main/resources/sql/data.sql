insert into aircraft (model)
values ('Boeing 777-300'),
       ('Boeing 737-300'),
       ('Airbus A320-200'),
       ('Superjet 100');
insert into seat (aircraft_id, seat_no)
select id, s.column1
from aircraft
         cross join (values ('A1'), ('A2'), ('B1'), ('B2'), ('C1'), ('C2'), ('D1'), ('D2') order by 1) s;