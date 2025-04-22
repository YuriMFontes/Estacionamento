# Smart Parking API 🚗

API para gerenciamento de vagas de estacionamento inteligente, desenvolvida com Spring Boot e PostgreSQL. O projeto está containerizado com Docker e configurado para CI/CD.

## ✅ Tecnologias utilizadas

- Java 21
- Spring Boot 3.4.4
- PostgreSQL 15
- Docker e Docker Compose
- Maven
- Azure DevOps (CI/CD)
- Lombok

---

## 📦 Pré-requisitos

Antes de começar, você precisa ter instalado:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- (Opcional) [Java 21](https://jdk.java.net/21/) e [Maven](https://maven.apache.org/) para rodar localmente sem Docker.

---

## 🚀 Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/smartparking.git
cd smartparking

docker-compose up --build

mvn test

GET /vagas
POST /vagas
PUT /vagas/{id}
DELETE /vagas/{id}

docker build -t smartparking .

docker run -p 8080:8080 smartparking

