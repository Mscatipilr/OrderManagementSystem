# Step 1: Use an official Java runtime as the base image
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
COPY target/OrderManagementSystem-0.0.1-SNAPSHOT.jar /app/OrderManagementSystem.jar

# Step 4: Expose the necessary port (e.g., 8080)
EXPOSE 8080

# Step 5: Run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app/OrderManagementSystem.jar"]
