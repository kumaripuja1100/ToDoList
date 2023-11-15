# Use an official OpenJDK image as the base image
FROM openjdk:20-jdk-slim

# Set, the working directory
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/todolist-0.0.1-SNAPSHOT.jar .

# Expose the port that the Spring Boot application uses
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "todolist-0.0.1-SNAPSHOT.jar"]
