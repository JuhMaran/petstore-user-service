# Petstore Microservices – Java, Spring Boot, CQRS, DDD e Elasticsearch

Este repositório apresenta uma **implementação de portfólio** do domínio **User** do Swagger Petstore, utilizando **Java, Spring Boot, microsserviços, CQRS, DDD e Elasticsearch**, com foco em **boas práticas arquiteturais reais de mercado**.

> ⚠️ **Importante:** Este projeto não trata Elasticsearch como banco transacional. Ele é usado **exclusivamente como Read Model**, respeitando princípios de consistência, escalabilidade e separação de responsabilidades.

---

## Objetivos do Projeto

* Demonstrar **maturidade arquitetural** em Java
* Aplicar **CQRS (Command Query Responsibility Segregation)**
* Utilizar **DDD (Domain-driven Design)** em microsserviços
* Usar **Elasticsearch corretamente** como engine de busca
* Criar um projeto **defensável em entrevistas técnicas**

---

## Visão Geral da Arquitetura

* Arquitetura baseada em **microsserviços**
* Cada microsserviço representa um **Bounded Context**
* Separação explícita entre **Command Model** e **Query Model**
* Comunicação via **REST**
* Infraestrutura conteinerizada com **Docker Compose**

Diagramas C4 disponíveis em: `docs/architecture`

---

## Principais Decisões Arquiteturais

### 1. Por que CQRS?

CQRS foi adotado para:

* Separar responsabilidades de escrita e leitura
* Permitir modelos de dados otimizados por caso de uso
* Facilitar escalabilidade e performance
* Preparar o sistema para event-driven no futuro

➡️ **Commands** alteram o estado do domínio.
➡️ **Queries** nunca alteram estado.

---

### 2. Por que Elasticsearch apenas no Read Model?

Elasticsearch **não é um banco transacional**. Ele não garante:

* Consistência forte
* Transações ACID
* Integridade relacional

Neste projeto:

* Escritas ocorrem em um **Write Store transacional**
* Eventos de domínio atualizam o **Read Model no Elasticsearch**

✔️ Essa abordagem reflete práticas reais de sistemas distribuídos.

---

### 3. DDD aplicado na prática

O projeto segue os princípios de DDD:

* **Domain Layer** isolado
* Agregados com regras de negócio
* Value Objects (`UserId`, `UserStatus`)
* Eventos de domínio explícitos

O domínio **não depende de frameworks**.

---

### 4. Microsserviços e Bounded Contexts

Cada domínio do Petstore é um microsserviço independente:

* `user-service`
* `store-service` (estrutura preparada)

Cada serviço possui:

* Seu próprio modelo
* Seu próprio banco de escrita
* Independência de deploy

---

## Fluxo CQRS – User Service

### Command Flow (Write)

1. Requisição REST (`POST /users`)
2. Controller cria um Command
3. Command Handler executa regras de negócio
4. Persistência no banco transacional
5. Geração de evento de domínio

### Query Flow (Read)

1. Evento de domínio é tratado
2. Documento é indexado no Elasticsearch
3. Consultas REST usam apenas o Read Model

---

## Modelagem no Elasticsearch

* Índices versionados (`users_read_v1`)
* Alias (`users_read`) usado pela aplicação
* Campos `text` para busca
* Campos `keyword` para filtros e agregações

➡️ Isso permite **reindex sem downtime**.

---

## Infraestrutura e Docker

O projeto utiliza **Docker Compose** para ambiente local:

* Elasticsearch
* Kibana
* User Service

Benefícios:

* Setup rápido
* Ambiente reproduzível
* Fácil avaliação por recrutadores

---

## Kibana

O Kibana é utilizado para:

* Explorar documentos indexados
* Criar dashboards de usuários
* Auxiliar debugging e observabilidade

---

## Testes

* Testes unitários no domínio
* Testes de aplicação para handlers
* Testes de integração preparados para Testcontainers

---

## Estrutura do Repositório

```
services/
 └── user-service
     ├── domain
     ├── application
     ├── interfaces
     └── infrastructure
```

A separação reflete **arquitetura hexagonal + DDD**.

---

## Como Executar Localmente

```bash
docker-compose up -d
```

* API: [http://localhost:8080](http://localhost:8080)
* Elasticsearch: [http://localhost:9200](http://localhost:9200)
* Kibana: [http://localhost:5601](http://localhost:5601)

---

## Próximos Passos (Roadmap)

* Kafka para eventos assíncronos
* Saga para consistência entre serviços
* Observabilidade (Prometheus + Grafana)
* Cache com Redis
* Segurança (OAuth2 / JWT)

---

Este projeto aplia CQRS e DDD de forma pragmática, usando ElasticSearch como Read Model e mantendo consistência e escalabilidade. Ele foi desenhado para evoluir e operar em produção

---

## Autora

**Juliane Maran**  
Backend Java Developer | Software Engineer