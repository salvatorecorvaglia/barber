# Stage 1: Build
FROM eclipse-temurin:24-jdk as builder

WORKDIR /app

# Copia e build
COPY pom.xml ./
COPY src ./src

RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:24-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Usa un utente non-root
RUN useradd -m barberuser
USER barberuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
