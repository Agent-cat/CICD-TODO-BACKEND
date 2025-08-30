
FROM maven:3.9.6-eclipse-temurin-21 AS build
LABEL authors="Vishnu vardhan"

WORKDIR /app

COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src ./src


RUN ./mvnw package -DskipTests


FROM eclipse-temurin:21-jre-jammy


WORKDIR /app


EXPOSE 8081

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
