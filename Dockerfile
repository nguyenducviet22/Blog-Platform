# Use a JDK base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/blog-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
