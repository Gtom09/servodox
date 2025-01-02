# Step 1: Build the application
FROM maven:3.8.6-openjdk-17-slim AS build

# Copy the project files into the container
COPY . .

# Build the Spring Boot application with Maven
RUN mvn clean package -DskipTests

# Step 2: Run the application
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the built JAR file from the build stage
COPY --from=build /target/your-app-name-0.0.1-SNAPSHOT.jar app.jar

# Entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
