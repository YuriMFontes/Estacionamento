# Etapa 1: Construção com Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia todos os arquivos do projeto para o diretório de trabalho
COPY . .

# Compila e empacota o projeto usando Maven, agora rodando os testes
RUN mvn clean package

# Etapa 2: Configuração do runtime com Java 21
FROM eclipse-temurin:21-jre AS runtime

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar gerado pela etapa anterior para o container
COPY --from=build /app/target/smartparking-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do container onde a aplicação estará disponível
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
