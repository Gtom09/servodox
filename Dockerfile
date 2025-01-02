# Step 1: Build the application
FROM openjdk:17-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y wget unzip \
    && wget https://archive.apache.org/dist/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip -P /tmp \
    && unzip /tmp/apache-maven-3.8.6-bin.zip -d /opt \
    && rm /tmp/apache-maven-3.8.6-bin.zip \
    && ln -s /opt/apache-maven-3.8.6/bin/mvn /usr/local/bin/mvn

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
