# AuroraPay Eureka Server (Discovery Server)

This module provides the **Eureka Server** (service registry) for the AuroraPay ecosystem.

Eureka is used for **service discovery**:
- Microservices register themselves in Eureka.
- The API Gateway (and other clients) query Eureka to locate available service instances.
- Load balancing is performed client-side (e.g., Spring Cloud LoadBalancer), using Eureka as the source of instances.

---

## Running locally (IntelliJ / Maven)

### Requirements
- Java 21+

### Start
```bash
./mvnw spring-boot:run
```

#### Access

- Eureka Dashboard: http://localhost:8761
- Health endpoint: http://localhost:8761/actuator/health

---

## Running with Docker Compose

This service is designed to run via the AuroraPay `docker-compose.yml` using `build:`.

### Build & start

From the folder where your compose file lives:

```bash
docker compose up -d --build discovery-server
```

### Verify

- Eureka Dashboard: http://localhost:8761
- Health endpoint: http://localhost:8761/actuator/health

You can also check container health status:

```bash
docker ps
docker logs -f aurorapay-eureka-server
```
