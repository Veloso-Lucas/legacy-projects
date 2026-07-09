#!/usr/bin/env bash
# -----------------------------------------------------------------------------
# Script: logs.sh
# Purpose: Tails logs from Docker Compose services.
# Usage:   ./infra/scripts/logs.sh
# Notes:   Use CTRL+C to stop following logs.
# -----------------------------------------------------------------------------

set -e

ROOT_DIR="$(cd "$(dirname "$0")/../" && pwd)"
cd "$ROOT_DIR/docker"

docker compose --env-file .env logs -f --tail=200
