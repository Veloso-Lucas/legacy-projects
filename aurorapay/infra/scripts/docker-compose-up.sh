#!/usr/bin/env bash
# -----------------------------------------------------------------------------
# Script: up.sh
# Purpose: Starts the local infrastructure (Docker Compose) in detached mode.
# Usage:   ./infra/scripts/up.sh
# Notes:   Requires infra/docker/.env to exist (not committed to Git).
# -----------------------------------------------------------------------------

set -e

ROOT_DIR="$(cd "$(dirname "$0")/../" && pwd)"
cd "$ROOT_DIR/docker"

docker compose --env-file .env up -d
docker compose ps
