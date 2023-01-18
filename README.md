### AircraftAndSeat

I use liquibase as migration tools, which will create two necessary [Seat and Aircraft] tables that are connected many
to one. If you want fill this tables you need start data.sql in resources/sql directory. In testing i use
testcontainers. If you want to run it, please make sure that the docker is started.
