# -------- Build stage --------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom first to leverage Docker layer caching
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN mvn -q -DskipTests dependency:go-offline

# Copy source and build
COPY src src
RUN mvn -q -DskipTests package

# -------- Runtime stage --------
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Install wget (used by docker-compose healthcheck)
RUN apt-get update \
  && apt-get install -y --no-install-recommends wget \
  && rm -rf /var/lib/apt/lists/*

# Copy the built jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8761
ENTRYPOINT ["java","-jar","/app/app.jar"]
