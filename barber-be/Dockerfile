FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./
COPY src ./src

RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

RUN useradd -m barberuser
USER barberuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
