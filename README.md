# Sourtimes (eksisozluk)

A simple monolithic and multi-layered architecture Spring Boot API project.

## Features

- Multi-layered architecture.
- PostgreSQL database integration (can be changed to any other database).
- Global Exception handling.
- Endpoints:
  - `/api/v1/header`(POST): Create header.
  - `/api/v1/header/:id`(GET): Get entries by header id.
  - `/api/v1/header/:id`(POST): Create entry by header id.
  - `/api/v1/entry/:id`(GET): Get entry by id.
  - `/api/v1/entry/:id`(PUT): Update entry by id.
  - `/api/v1/entry/:id`(DELETE): Delete entry by id.

## Getting Started

To get started with this project, follow these steps:

1. Clone this repository.

2. Configure your database settings in the `application.properties` or `application.yml` file.

3. Build and run the application.

```bash
mvn clean install
java -jar target/your-application-name.jar
```

