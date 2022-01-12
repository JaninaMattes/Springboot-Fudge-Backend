# Spring Boot Rest API with PostgreSQL Database

## Tech Stack Used
- Spring Boot
- Lombok 
- JWT 

## JWT Token Authentication
Example:
1) register test user 

    {
   "firstName": "James",
   "lastName": "Smith",
   "email": "james.smith@testmail.com",
   "password": "testpassword" 
   }

 
2) receive token 
    ``` {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Mzk4Mjg5NTIsImV4cCI6MTYzOTgzNjE1MiwidXNlcklkIjo0LCJlbWFpbCI6ImphbWVzLnNtaXRoQHRlc3RtYWlsLmNvbSIsImZpcnN0TmFtZSI6IkphbWVzIiwibGFzdE5hbWUiOiJTbWl0aCJ9.ka94HkkM88gPgvIlF5LPyV0bcGCO2Pe-03bVaLKx1os"
}

3) send token 

# Development

## Tutorial Running a Multi-container (Spring Boot and PostgreSQL) Application with Docker Compose
https://www.section.io/engineering-education/running-a-multi-container-springboot-postgresql-application-with-docker-compose/

## Run just Docker Container PostgreSQL
- run container: ```docker run --name postgresdb -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres```

## PostgreSQL Database Container
To create the database with Docker manually follow the steps:
1) ```cd db```
2) Copy database schema and data to container: ```docker cp schema.sql postgresdb:/```
3) ```winpty docker exec -it postgresdb bash```
4) ```psql -U postgres --file schema.sql``` # Exchange user to foodtracker, if docker container has been started with docker-compose
5) ```winpty docker container exec -it postgresdb psql -U postgres```
6) Connect to database: ```\c foodtrackerdb```
7) Display all tables: ```\dt``` 
8) Display all schema: ```\l```
9) Exit: ```\q```

# Production

## Generate food-tracker-api.jar file and copy it to docker directory
- ```mvn install -DskipTests```
- cp the generated target folder to ./src/docker/
- push to gitlab

## Run all Container with Docker-Compose

- start all container in detach mode: ```docker-compose -f docker-compose.yml up -d --build```
- stop all container: ```docker-compose -f docker-compose.yml down -v```
- remove all container: ```docker system prune -a```
