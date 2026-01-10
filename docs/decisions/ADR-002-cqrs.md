# Architecture Decision Records (ADR)

Este diretório contém os **Architecture Decision Records (ADR)** do projeto **Petstore Microservices com Java, CQRS, DDD e Elasticsearch**.

Os ADRs documentam **decisões arquiteturais relevantes**, o contexto em que foram tomadas e suas consequências, seguindo boas práticas de engenharia de software.

## ADR-002 – Adoção de CQRS (Command Query Responsibility Segregation)

**Status:** Aceito
**Data:** 10/01/2026

### Contexto

O domínio de usuários possui requisitos distintos para escrita e leitura:

* Escrita exige validações, regras de negócio e consistência
* Leitura exige performance, filtros e buscas textuais

Uma única modelagem atenderia mal a ambos os cenários.

### Decisão

Adotar **CQRS**, separando explicitamente:

* **Command Side**: alteração de estado
* **Query Side**: consultas otimizadas

A separação ocorre em:

* Controllers
* Application Services
* Persistência

### Consequências

**Positivas**

* Código mais claro e coeso
* Modelos otimizados por caso de uso
* Facilidade de escalar leitura independentemente
* Preparação para arquitetura event-driven

**Negativas**

* Curva de aprendizado maior
* Mais componentes para manter
