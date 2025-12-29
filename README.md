# API REST -  Gerenciamento de Funcionarios


API desenvolvida para gerenciamento de colaboradores, a ideia principal é ter um controle dos funcionarios com dados 
básicos como nome, cpf, data de nascimento e lista de telefones. Essa api é integravel a qualquer sistema que necessite desse controle.

O projeto foi construído focando em boas práticas de desenvolvimento, como o uso de DTOs (Data Transfer Objects), mapeamento eficiente com MapStruct, persistência de dados com Spring Data JPA e deploy automatizado.


## Tecnologias Utilizadas

*   **Java 21**
*   **Spring Boot**
*   **Maven**
*   **Mapeamento de Objetos: MapStruct (Integração com Lombok)**:
*   **Banco de Dados**: H2 (para testes)
*   **Persistência:** Spring Data JPA / Hibernate
*   **Swagger/OpenAPI**: (em implementação)
*   **JUnit 5 & Mockito**: (em implementação)
*   **Outras**: Lombok, Mapstruct, railway para deploy

## Arquitetura do Projeto

* O projeto segue o padrão de camadas para garantir a separação de responsabilidades:

* Controller: Porta de entrada da aplicação, lida com as requisições HTTP.

* Service: Camada de lógica de negócio e transações.

* Repository: Interface de comunicação com o banco de dados.

* Entity: Modelagem das tabelas do banco de dados.

* DTO (Request/Response): Objetos de transferência para evitar exposição de entidades e otimizar a carga de dados.

## Como Executar o Projeto
Pré-requisitos

* JDK 21 instalado.

* Maven 3.8+ instalado.
 

**Passo a Passo**

1. Clone o repositório:
`git clone https://github.com/seu-usuario/collaboratorapi.git`
`cd collaboratorapi`

2. Compile e instale as dependências:
`mvn clean install`

3. Execute a aplicação:
`mvn spring-boot:run`

A API estará disponível em http://localhost:8080.

Endpoints da API

## Endpoints da API

Abaixo estão listados os recursos disponíveis na versão **v1**:

| Método | Endpoint                          | Descrição                              | Status de Sucesso |
|--------|-----------------------------------|----------------------------------------|-------------------|
| POST   | `/api/v1/collaborators`           | Cria um novo colaborador               | 201 Created       |
| GET    | `/api/v1/collaborators`           | Lista todos os colaboradores           | 200 OK            |
| GET    | `/api/v1/collaborators/{id}`      | Busca colaborador por ID               | 200 OK            |
| PUT    | `/api/v1/collaborators/{id}`      | Atualiza dados de um colaborador       | 200 OK            |
| DELETE | `/api/v1/collaborators/{id}`      | Remove um colaborador do sistema       | 204 No Content    |

### Exemplo de Payload para Cadastro/Atualização (JSON)
```json
{
    "firstName": "Emmett ",
    "lastName": "Brown",
    "cpf": "123.456.789-00",
    "birthDate": "21-10-2015",
    "phones": [
        {
            "type": "MOBILE",
            "number": "12996333744"
        }
    ]
}