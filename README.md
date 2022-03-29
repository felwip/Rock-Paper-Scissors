# Rock Paper Scissors Browser Game

This is a coding challenge, building a "Rock Paper Scissors" browser game with a backend. Frontend is built with Angular.js, Backend is in Java and built with Spring Boot.

## Build Frontend Application

In your terminal navigate into the project repository `Rock-Paper-Scissors`.
Cd into the `frontend` repo by running `cd frontend`. Subsequently run `ng serve`. In your browser navigate to [localhost:4200](http://localhost:4200/).

## Build Backend Application

In your terminal navigate into the project repository `Rock-Paper-Scissors`.
Cd into the `backend` repo by running `cd backend`. Subsequently run `mvn compile`, which should create a target repository. Now run `mvn package` to create an executable `.jar` file. Finally run `java -jar target/rps-backend-0.0.1-SNAPSHOT.jar` to start the backend application.

In your browser navigate to [localhost:38080](http://localhost:38080/) to check whether the backend is running. You should see the prompt "Backend is up and running. You can send requests to the available routes now."
