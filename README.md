# Microsserviço de Usuário - PetStore

Este projeto consiste no desenvolvimento de um **Microsserviço de Usuário** em **Java com Spring Boot**, implementando o domínio de _users_ do **Swagger PetStore (OpenAPI 3.0)**. A aplicação segue boas práticas de arquitetura moderna, utilizando **DDD (Domain-Driven Design)** e **CQRS (Command Query Responsibility Segregation)**, com separação clara de responsabilidades entre comandos e consultas.

O Microsserviço utiliza **ElasticSearch** como base de dados, faz parte de uma arquitetura orientada a **microsserviços**, onde cada domínio é isolado em seu próprio serviço, e é totalmente containerizado com **Docker**, incluindo suporte ao **Kibana** para visualização e monitoramento dos dados.

## Tecnologias Principais

- Java 25
- Spring Boot 4.0.1
- Maven
- ElasticSearch
- Docker e Docker Compose
- Arquitetura DDD e CQRS

## Decisões Arquiteturais

As principais decisões arquiteturais estão documentadas em ADRs:

- ADR-001 – Uso do Elasticsearch apenas como Read Model
- ADR-002 – Adoção de CQRS
- ADR-003 – DDD com Bounded Contexts

```text
docs/
 └── decisions/
     ├── ADR-001-elasticsearch-read-model.md
     ├── ADR-002-cqrs.md
     └── ADR-003-ddd-bounded-contexts.md
```


---

## Autora

**Juliane Maran**  
Backend Java Developer | Software Engineer