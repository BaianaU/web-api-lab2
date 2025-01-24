# Web API Lab 2

## Beskrivning
Detta projekt är en webbaserad applikation byggd med Spring Boot och Postgres. Den hanterar användare och uppgifter via REST API:er.

## Funktioner
- CRUD-operationer för användare.
- CRUD-operationer för uppgifter.
- Autentisering och lösenordskryptering med BCrypt.

---

## Förutsättningar
För att köra detta projekt behöver du ha följande installerat:
- [Docker](https://www.docker.com/)
- [Java 17](https://adoptium.net/)
- [Gradle](https://gradle.org/)

---

## Databas: Postgres med Docker
För att köra Postgres-databasen, kör följande kommando:

```bash
docker run --name web-api-lab2-db \
  -e POSTGRES_DB=web-api-lab2 \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=Benny123 \
  -p 5432:5432 \
  -d postgres
