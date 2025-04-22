# Etapa 1: Build com Maven e Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Definir diretório de trabalho
WORKDIR /app

# Copiar arquivos do projeto para o contêiner
COPY . .

# Executar o comando Maven para compilar o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com Java 21
FROM eclipse-temurin:21-jre

# Definir diretório de trabalho no contêiner de execução
WORKDIR /app

# Copiar o arquivo JAR gerado do contêiner de build
# Substitua 'your-artifact-name.jar' pelo nome exato do arquivo JAR gerado
COPY --from=build /app/target/smartparking-app.jar app.jar

# Definir variáveis de ambiente para a conexão com o banco de dados
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://smartparking-db:5432/smartparkingdb \
    SPRING_DATASOURCE_USERNAME=postgres \
    SPRING_DATASOURCE_PASSWORD=123456 \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_SHOW_SQL=true \
    SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true

# Expor a porta que a aplicação vai rodar
EXPOSE 8080

# Definir o ponto de entrada para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
