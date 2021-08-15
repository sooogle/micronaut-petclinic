# Micronaut PetClinic Sample Application

Petclinic is a Micronaut port of the [spring-petclinic](https://github.com/spring-projects/spring-petclinic).

## How it works

- Java 16
- Micronaut 2.5.12
- jOOQ for repository implementation
- Flyway for schema migration
- OpenAPI specification

## How to run

You need Java 16 and Docker installed.

#### Launch database

```bash
docker compose up -d db
```

#### Start application

```bash
./gradlew run
```

or using Docker,

```bash
docker compose up web
```

You can test APIs using SwaggerUI: http://localhost:8080/swagger-ui/

<img src="https://gyazo.com/62b34ec3985272e02a7ae3cffecfdb4d.png" alt="swagger-ui">

#### Run unit tests

```bash
./gradlew test
```

A dedicated Postgres container is automatically started for every test execution.
