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
