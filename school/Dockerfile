# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy jar file into the container
COPY target/school-0.0.1-SNAPSHOT.jar app.jar

# Command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

ENV PORT=9090
ENV MONGO_DB=mongodb://localhost:27017/schoolDb
ENV SONAR_HOST=http://localhost:9000
ENV SONAR_TOKEN=sqa_71d584e83febc2eece947f6ba6eace9b2dde29a6