#!/usr/bin/env bash
# -----------------------------------------------------------------------------
# Script: reset.sh
# Purpose: Recreates the local infrastructure from scratch (WIPES DATA).
# Usage:   ./infra/scripts/reset.sh
# Warning: This removes named volumes (-v). You will LOSE database data.
# -----------------------------------------------------------------------------

set -e

ROOT_DIR="$(cd "$(dirname "$0")/../" && pwd)"
cd "$ROOT_DIR/docker"

docker compose --env-file .env down -v
docker compose --env-file .env up -d
docker compose ps
