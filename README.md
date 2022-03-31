# Rock Paper Scissors Browser Game

This is a coding challenge, building a "Rock Paper Scissors" browser game including a backend. The frontend is built with Angular.js, the backend built with Spring Boot.

## Build complete RPS application using `docker`

To run the entire app by just one command you need to have Docker installed on your machine.
Cd into the root repository `Rpck-Paper-Scissors` and run `docker compose up` in your terminal. Wait for the backend and frontend service to start. Now you can access the application on [localhost:34200](http://localhost:4200).

## Build and start both applications individually using `ng` and `mvn`

### Build Frontend Application

In your terminal navigate into the project repository `Rock-Paper-Scissors`.
Cd into the `frontend` repo by running `cd frontend`. Subsequently run `ng serve`. In your browser navigate to [localhost:4200](http://localhost:4200/).

### Build Backend Application

In your terminal navigate into the project repository `Rock-Paper-Scissors`.
Cd into the `backend` repo by running `cd backend`. Subsequently run `mvn compile`, which should create a target repository. Now run `mvn package` to create an executable `.jar` file. Finally run `java -jar target/rps-backend-0.0.1-SNAPSHOT.jar` to start the backend application.

In your browser navigate to [localhost:38080](http://localhost:38080/) to check whether the backend is running. You should see the prompt "Backend is up and running. You can send requests to the available routes now."

## Logs and Metrics

### Logging level

The log level of the backend defaults to `INFO`. You can switch the level in the `application.properties` file. To test if the desired log level applies, you may uncomment the test logs on the `RpsController` and navigate to [localhost:38080](http://localhost:38080). Subsequently check your terminal for the log messages.

### Available Actuator Endpoints

A basic healthcheck and some additional application-info for the spring-boot backend is available through spring-boot's actuator.

After starting the backend application, you can check the health status on [localhost:38080/actuator/health](http://localhost:38080/actuator/health)

Metrics can be reached on [localhost:38080/actuator/metrics](http://localhost:38080/actuator/metrics)

Additional actuator endpoints currently are `/info` and `/loggers`. See the updated overview of all available endpoints on [localhost:38080/actuator](http://localhost:38080/actuator)
