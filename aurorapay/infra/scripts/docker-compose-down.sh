#!/usr/bin/env bash
# -----------------------------------------------------------------------------
# Script: down.sh
# Purpose: Stops and removes the local infrastructure containers (keeps volumes).
# Usage:   ./infra/scripts/down.sh
# Warning: Data in named volumes is preserved. Use reset.sh to wipe data.
# -----------------------------------------------------------------------------

set -e

ROOT_DIR="$(cd "$(dirname "$0")/../" && pwd)"
cd "$ROOT_DIR/docker"

docker compose --env-file .env down
