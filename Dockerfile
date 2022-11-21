FROM gradle:7-alpine AS builder

WORKDIR /TD/covid-api/covid-api

COPY /TD/covid-api/covid-api /

RUN gradle clean --no-daemon && gradle bootJar --no-daemon

FROM openjdk:19-jdk-slim

WORKDIR /

COPY --from=builder /build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]