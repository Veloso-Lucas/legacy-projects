#!/usr/bin/env bash
# -----------------------------------------------------------------------------
# Script: stop.sh
# Purpose: Stops the local infrastructure containers WITHOUT removing them.
# Usage:   ./infra/scripts/stop.sh
# Notes:   Containers will remain listed as "stopped" in Docker Desktop.
#          Use down.sh to remove containers, or reset.sh to wipe volumes.
# -----------------------------------------------------------------------------

set -e

ROOT_DIR="$(cd "$(dirname "$0")/../" && pwd)"
cd "$ROOT_DIR/docker"

docker compose --env-file .env stop
docker compose ps
