
# Use a Maven image with a supported JDK version
FROM maven:3.8.1-openjdk-11 AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src
RUN mvn clean package
# Download dependencies (optional but can speed up the build)
RUN mvn dependency:go-offline

# Package the application
RUN mvn package

# Use a smaller image for the runtime
FROM openjdk:11-jre-slim
COPY app/SpringBootRegistrationLogin.jar /app/SpringBootRegistrationLogin.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/SpringBootRegistrationLogin.jar"]
