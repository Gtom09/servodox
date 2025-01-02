# Step 1: Build the application
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project files into the container (including pom.xml)
COPY pom.xml .

# Download Maven dependencies
RUN mvn dependency:go-offline

# Copy the rest of the project files into the container
COPY . .

# Build the Spring Boot application with Maven
RUN mvn clean package -DskipTests

# Step 2: Run the application
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the built JAR file from the build stage
COPY --from=build /app/target/PolicyCalculator-0.0.1-SNAPSHOT.jar app.jar

# Entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
