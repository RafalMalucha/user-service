# Use a minimal base image with JDK
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working dir inside the container
WORKDIR /app

# Copy and build app with Maven
COPY . .
RUN mvn clean package -DskipTests

# Final image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app
COPY --from=builder /app/target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
