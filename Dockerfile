# Etapa 1: Build com Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com Java leve
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Variáveis de ambiente do banco de dados
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://smartparking-db:5432/smartparkingdb \
    SPRING_DATASOURCE_USERNAME=postgres \
    SPRING_DATASOURCE_PASSWORD=123456 \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_SHOW_SQL=true \
    SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
