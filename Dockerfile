# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim as build

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR do seu projeto para o contêiner
COPY target/smartparking-*.jar app.jar

# Exponha a porta que o Spring Boot vai rodar (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

# Defina o ambiente para execução
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://smartparking-db:5432/smartparkingdb
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=123456
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true
