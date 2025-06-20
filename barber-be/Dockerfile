FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

COPY ../../../mvnw ./
COPY ../../../.mvn .mvn
COPY ../../../pom.xml ./
COPY ../.. ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

RUN useradd -m barberuser
USER barberuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
