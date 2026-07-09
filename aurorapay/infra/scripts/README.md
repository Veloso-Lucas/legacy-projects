# Infrastructure Scripts

This folder contains helper scripts to manage the local infrastructure (Docker Compose).
They are convenience wrappers around `docker compose` to ensure everyone runs the same commands
from the correct folder with the correct environment file.

## Prerequisites

- Docker Desktop installed and running
- A local environment file at: `infra/docker/.env`

You can create it by copying the example file:

```bash
cp infra/docker/.env.example infra/docker/.env
```