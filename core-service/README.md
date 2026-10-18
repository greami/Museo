Core - microservice

Modules:
- domain: core domain records and ports
- application: use-cases and mappers
- adapter: Spring Boot application, adapters, infra

Run:
  mvn -f pom.xml -T 1C clean install
  mvn -f adapter/pom.xml spring-boot:run -Dspring-boot.run.main-class=org.core.Start

From the service root, run `spring-boot:run` on `adapter/pom.xml`, not on the parent POM.

Docker:
  1. Start Docker Desktop
  2. docker compose up --build
  3. open http://localhost:8084
  4. docker compose down

Notes:
- Update secrets and versions before production
- openapi-generator configured to read src/main/resources/openapi.yaml
