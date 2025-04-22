## Description

- This is a Spring Boot application that demonstrates basic CRUD operations for a movie application, the user can write, update, read, and delete movie album.

## Prerequisites

- **Java**: 17 or later
- **Build Tool**: Maven 3.6

## Building the Application

To build the application, navigate to the project root directory and run:

```bash
mvn clean package
```

## Running the Application

To run the application locally, use:
```bash
  mvn spring-boot:run
 ```

## How to Use

- Access the application at `http://localhost:8080`.
- the endpoints of this applications consist of:
    - `GET /api/movie/{movieId}` retrieve movie based on id
    - `GET /api/movie` retrieve all movie
    - `POST /api/movie` store a movie album
    - `PUT /api/movie/{movieId}` update specific movie album
    - `DELETE /api/movie/{movieId}` delete specific movie album
    - `DELETE /api/movie` delete all movie album
- Alternatively you can access http://localhost:8080/swagger-ui/index.html

## Links

- Spring Boot Documentation
- Spring Initializr