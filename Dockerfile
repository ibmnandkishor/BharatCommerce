
# Use a Maven image with a supported JDK version
FROM maven:3.8.6-jdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src

# Download dependencies (optional but can speed up the build)
RUN mvn dependency:go-offline

# Package the application
RUN mvn package

# Use a smaller image for the runtime
FROM openjdk:11-jre-slim
COPY --from=build /app/target/SpringBootRegistrationLogin.jar /app/your-app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]
