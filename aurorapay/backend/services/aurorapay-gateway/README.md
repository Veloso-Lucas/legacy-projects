# AuroraPay Gateway (Notes)

## What it is
AuroraPay Gateway is the **single entry point** to backend services. It:
- validates **JWT** tokens (Keycloak) as an **OAuth2 Resource Server**
- registers in **Eureka** and can route to services via discovery
- exposes basic Actuator endpoints for observability

## Public vs Protected
- Public: `/actuator/health`, `/actuator/info`
- Protected: everything else (JWT required)

## Profiles
We keep profiles to make the execution environment explicit:
- `local`: gateway runs locally and usually uses `localhost` addresses
- `docker`: gateway runs in Docker Compose and uses internal DNS (service names)

Set it with:
- `SPRING_PROFILES_ACTIVE=local` or `SPRING_PROFILES_ACTIVE=docker`

## Environment Variables
- `KEYCLOAK_ISSUER_URI`  
  Issuer used to validate JWTs. **Must match the token `iss` claim**.  
  Example (Docker Desktop): `http://host.docker.internal:8081/realms/aurorapay`

- `EUREKA_CLIENT_SERVICEURL_DEFAULTZONE` (or `EUREKA_DEFAULTZONE`, depending on your YAML)  
  Eureka registry URL. Example: `http://discovery-server:8761/eureka`

## Common pitfall
**401 with a valid token** usually means issuer mismatch:
- token `iss` ≠ `KEYCLOAK_ISSUER_URI`
