user-service

Modules:
- domain: core domain records and ports
- application: use-cases and mappers
- adapter: Spring Boot application, adapters, infra

UML diagrams (PlantUML sources):
- [Class diagram](docs/uml/class-diagram.puml)
- [Use-case diagram](docs/uml/use-case-diagram.puml)
- [Database ER diagram](docs/uml/database-er-diagram.puml)

Run:
  mvn -f pom.xml -T 1C clean install
  mvn -f adapter/pom.xml spring-boot:run -Dspring-boot.run.main-class=org.user.service.Start

From the service root, run `spring-boot:run` on `adapter/pom.xml`, not on the parent POM.
