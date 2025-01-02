# Step 1: Build the application
FROM ubuntu:latest AS build

# Update apt-get and install openjdk-17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Copy project files into the container
COPY . .

# Ensure gradle wrapper is executable (if using Gradle)
RUN chmod +x gradlew

# Build the Spring Boot application with Gradle (assuming you're using Gradle)
RUN ./gradlew bootJar --no-daemon

# Step 2: Run the application
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the built JAR file from the build stage
COPY --from=build /build/libs/your-app-name-0.0.1-SNAPSHOT.jar app.jar

# Entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
