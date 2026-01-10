# Architecture Decision Records (ADR)

Este diretório contém os **Architecture Decision Records (ADR)** do projeto **Petstore Microservices com Java, CQRS, DDD e Elasticsearch**.

Os ADRs documentam **decisões arquiteturais relevantes**, o contexto em que foram tomadas e suas consequências, seguindo boas práticas de engenharia de software.

## ADR-001 - Uso do Elasticsearch apenas como Read Model

**Status:** Aceito
**Data:** 10/01/2026

### Contexto 

O desafio propõe o uso do **Elasticsearch como base de dados**. No entanto, Elasticsearch não é um banco de dados transacional e não oferece garantias ACID, integridade relacional ou consistência forte.

O sistema precisa:

* Permitir buscas eficientes e flexíveis
* Manter integridade do domínio
* Ser escalável e defensável arquiteturalmente

### Decisão

O Elasticsearch será utilizado **exclusivamente como Read Model**, dentro de uma arquitetura **CQRS**.

* Escritas (Commands) persistem dados em um **Write Store transacional**
* Eventos de domínio propagam mudanças para o Elasticsearch
* Consultas nunca acessam o banco de escrita

### Consequências

**Positivas**

* Melhor performance de leitura
* Modelo de dados otimizado para busca
* Arquitetura alinhada a sistemas distribuídos reais
* Reindex e evolução de schema sem downtime

**Negativas**

* Aumento de complexidade arquitetural
* Consistência eventual entre escrita e leitura

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