# Use a different Maven image if the previous one is not available
FROM maven:3.8.6-openjdk-21 AS build

WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

# Use a smaller image for the runtime
FROM openjdk:21-jdk-slim

COPY --from=build /app/target/your-app.jar /app/your-app.jar

ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]
