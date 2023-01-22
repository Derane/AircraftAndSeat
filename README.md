### AircraftAndSeat

I use liquibase as migration tools, which will create two necessary [Seat and Aircraft] tables that are connected many
to one. In testing i use
testcontainers. If you want to run it, please make sure that the docker is started(you can choose your version Postgre SQL in IntegrationTestBase.class), may not be the perfect job with Spring 3.0.

**Note if you want to start application manually(not via tests) you need configure it in resources/application.properties and if you want fill this tables you need use data.sql in resources/sql directory.**
