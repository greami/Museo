#!/usr/bin/env bash

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
UI_DIR="$ROOT_DIR/UIApp"
PIDS=()

cleanup() {
  for pid in "${PIDS[@]:-}"; do
    if kill -0 "$pid" 2>/dev/null; then
      kill "$pid" 2>/dev/null || true
    fi
  done
  wait || true
}

wait_for_port() {
  local port="$1"
  local service_name="$2"
  local timeout_seconds="${3:-180}"
  local elapsed=0

  while ! (exec 3<>"/dev/tcp/127.0.0.1/$port") 2>/dev/null; do
    sleep 2
    elapsed=$((elapsed + 2))
    if [ "$elapsed" -ge "$timeout_seconds" ]; then
      echo "Timeout while waiting for ${service_name} on port ${port}" >&2
      exit 1
    fi
  done
}

start_java_service() {
  local service_dir="$1"
  local main_class="$2"

  (
    cd "$service_dir"
    mvn -f pom.xml -pl adapter -am clean package -DskipTests
    mvn -f adapter/pom.xml spring-boot:run -Dspring-boot.run.main-class="$main_class"
  ) &

  PIDS+=("$!")
}

start_ui_app() {
  if [ ! -d "$UI_DIR/node_modules" ]; then
    (cd "$UI_DIR" && npm ci)
  fi

  (
    cd "$UI_DIR"
    npm run build
    npm run dev -- --host 0.0.0.0
  ) &

  PIDS+=("$!")
}

trap cleanup EXIT INT TERM

echo "Starting user-service..."
start_java_service "$ROOT_DIR/user-service" "org.user.service.Start"
wait_for_port 8082 "user-service"

echo "Starting core-service..."
start_java_service "$ROOT_DIR/core-service" "org.core.Start"
wait_for_port 8084 "core-service"

echo "Starting api-gateway..."
start_java_service "$ROOT_DIR/api-gateway" "org.api.gateway.Start"
wait_for_port 8080 "api-gateway"

echo "Starting UIApp..."
start_ui_app
wait_for_port 5173 "UIApp"

echo "All services are running."
wait
