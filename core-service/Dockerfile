# syntax=docker/dockerfile:1.7

FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
COPY domain/pom.xml domain/pom.xml
COPY application/pom.xml application/pom.xml
COPY adapter/pom.xml adapter/pom.xml
COPY domain/src domain/src
COPY application/src application/src
COPY adapter/src adapter/src

RUN mvn -q -pl adapter -am -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /workspace/adapter/target/core-service-adapter-*-SNAPSHOT.jar /app/app.jar

RUN apt-get update \
  && apt-get install -y --no-install-recommends curl \
  && rm -rf /var/lib/apt/lists/*

EXPOSE 8080

ENV SERVER_PORT=8084

HEALTHCHECK --interval=10s --timeout=3s --start-period=30s --retries=12 \
  CMD curl --fail --silent "http://localhost:${SERVER_PORT:-8084}/v3/api-docs" >/dev/null

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
