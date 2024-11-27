# CRUD de Cliente e Carro com Spring Boot e PostgreSQL

Este projeto implementa um sistema CRUD para gerenciar **Clientes** e **Carros**, utilizando Spring Boot e um banco de dados PostgreSQL.

## Estrutura do Projeto

- **Cliente**
  - Id
  - Nome
  - Idade
  - Email

- **Carro**
  - Id
  - Marca
  - Cor
  - Modelo

## Funcionalidades

Endpoints para Clientes
- **GET** `/clientes`: Retorna todos os clientes adicionados à lista.
- **POST** `/clientes`: Adiciona um novo cliente à lista.
- **PUT** `/clientes/{id}`: Atualiza os dados de um cliente específico pelo ID.
- **DELETE** `/clientes/{id}`: Remove um cliente da lista pelo ID.
- **GET** `/clientes/{id}`: Retorna um cliente específico pelo ID.

Endpoints para Carros
- **GET** `/carros`: Retorna todos os carros adicionados à lista.  
- **POST** `/carros`: Adiciona um novo carro à lista.  
- **PUT** `/carros/{id}`: Atualiza os dados de um carro específico pelo ID.  
- **DELETE** `/carros/{id}`: Remove um carro da lista pelo ID.  
- **GET** `/carros/{id}`: Retorna um carro específico pelo ID.


## Requisitos

- Docker
- Docker Compose
- Java 17+
- PostgreSQL

## Configuração do Ambiente

### Banco de Dados com Docker

Para rodar o banco de dados PostgreSQL, execute o seguinte comando:

```bash
docker run --name postgres-crud -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=qwe123 -p 5432:5432 -d postgres
