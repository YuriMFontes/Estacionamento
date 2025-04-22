# Etapa 1: Construção com Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia todos os arquivos do projeto para o diretório de trabalho
COPY . .

# Compila e empacota o projeto usando Maven, sem rodar os testes (para agilidade)
RUN mvn clean package -DskipTests

# Etapa 2: Configuração do runtime com Java 21
FROM eclipse-temurin:21-jre AS runtime

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar gerado pela etapa anterior para o container
COPY --from=build /app/target/smartparking-app.jar app.jar

# Configurações de variáveis de ambiente para conectar ao banco de dados
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/smartparkingdb \
    SPRING_DATASOURCE_USERNAME=postgres \
    SPRING_DATASOURCE_PASSWORD=123456 \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_SHOW_SQL=true \
    SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true

# Expõe a porta do container onde a aplicação estará disponível
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
