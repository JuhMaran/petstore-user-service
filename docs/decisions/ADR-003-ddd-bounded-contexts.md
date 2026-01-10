# Architecture Decision Records (ADR)

Este diretório contém os **Architecture Decision Records (ADR)** do projeto **Petstore Microservices com Java, CQRS, DDD e Elasticsearch**.

Os ADRs documentam **decisões arquiteturais relevantes**, o contexto em que foram tomadas e suas consequências, seguindo boas práticas de engenharia de software.

## ADR-003 – Aplicação de DDD com Bounded Contexts em Microsserviços

**Status:** Aceito
**Data:** 2026-01-10

### Contexto

O Petstore possui múltiplos domínios (User, Store, Order, etc.) com regras distintas. Uma modelagem única levaria a alto acoplamento e complexidade excessiva.

### Decisão

Aplicar **Domain-driven Design (DDD)**, com:

* **Bounded Contexts** claros por microsserviço
* Domínio isolado de frameworks
* Uso de Aggregates, Value Objects e Domain Events

Cada microsserviço:

* Possui seu próprio modelo
* Possui seu próprio banco de escrita
* Evolui de forma independente

### Consequências

**Positivas**

* Baixo acoplamento entre serviços
* Clareza de responsabilidade
* Código mais expressivo e sustentável
* Facilidade de evolução e manutenção

**Negativas**

* Mais esforço inicial de design
* Necessidade de alinhamento conceitual