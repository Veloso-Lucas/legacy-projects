# AuroraPay

AuroraPay is a fintech reference project that demonstrates how to build a secure, observable payment platform using modern Spring Boot practices.

## Goals
- Clean architecture & domain-driven design (DDD)
- Authentication & authorization with JWT (Spring Security)
- Microservices-ready approach (modular boundaries)
- PostgreSQL persistence, migrations, and robust testing
- Messaging/events (Kafka) for async flows
- Observability (logs, metrics, traces)
- CI/CD pipeline and quality gates

## Tech Stack (initial)
- Java/Kotlin + Spring Boot
- Spring Security (JWT)
- PostgreSQL + Flyway
- Docker Compose (local environment)
- OpenAPI/Swagger
- Observability (Micrometer + OpenTelemetry)
- Kafka (later milestones)

## Modules (planned)
- `aurorapay-auth` – identity & access (signup/login, tokens, roles)
- `aurorapay-payments` – payment intents, charges, refunds
- `aurorapay-ledger` – double-entry ledger / balance tracking
- `aurorapay-notifications` – email/webhook notifications (async)
- `aurorapay-gateway` – API gateway (edge concerns)

## Getting Started
> Coming soon: docker compose + run instructions.
