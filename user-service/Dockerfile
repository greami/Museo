FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /workspace

COPY pom.xml .
COPY domain/pom.xml domain/pom.xml
COPY application/pom.xml application/pom.xml
COPY adapter/pom.xml adapter/pom.xml
COPY domain/src domain/src
COPY application/src application/src
COPY adapter/src adapter/src

RUN mvn -pl adapter -am clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /workspace/adapter/target/user-service-adapter-0.1.0-SNAPSHOT.jar /app/user-service.jar

RUN apt-get update \
  && apt-get install -y --no-install-recommends curl \
  && rm -rf /var/lib/apt/lists/*

EXPOSE 8082

ENV SERVER_PORT=8082

HEALTHCHECK --interval=10s --timeout=3s --start-period=30s --retries=12 \
  CMD curl --fail --silent "http://localhost:${SERVER_PORT:-8082}/v3/api-docs" >/dev/null

ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]
