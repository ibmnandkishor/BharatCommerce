FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/BharatCommerce-0.0.1-SNAPSHOT.jar BharatCommerce.jar
EXPOSE 4001
ENTRYPOINT ["java", "-jar", "BharatCommerce.jar"]
 
