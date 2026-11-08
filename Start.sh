#!/usr/bin/env bash

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
UI_DIR="$ROOT_DIR/UIApp"
PIDS=()
SERVICE_PID=""

export AUTH_COOKIE_SECURE="${AUTH_COOKIE_SECURE:-false}"
if [ -z "${JWT_SECRET:-}" ]; then
  SECRET_DIR="${HOME:?HOME must be set}/.museo"
  SECRET_FILE="$SECRET_DIR/jwt-secret"

  if [ -e "$SECRET_FILE" ]; then
    if [ ! -s "$SECRET_FILE" ]; then
      echo "JWT secret file is empty: $SECRET_FILE" >&2
      exit 1
    fi
    if ! JWT_SECRET="$(< "$SECRET_FILE")"; then
      echo "Unable to read JWT secret file: $SECRET_FILE" >&2
      exit 1
    fi
    if [ -z "$JWT_SECRET" ]; then
      echo "JWT secret file contains no value: $SECRET_FILE" >&2
      exit 1
    fi
  else
    if ! (umask 077; mkdir -p "$SECRET_DIR"); then
      echo "Unable to create JWT secret directory: $SECRET_DIR" >&2
      exit 1
    fi
    JWT_SECRET="$(openssl rand -base64 64 | tr -d '\n')"
    if ! (umask 077; set -o noclobber; printf '%s\n' "$JWT_SECRET" > "$SECRET_FILE") 2>/dev/null; then
      if [ ! -s "$SECRET_FILE" ]; then
        echo "Unable to save JWT secret: $SECRET_FILE" >&2
        exit 1
      fi
      JWT_SECRET="$(< "$SECRET_FILE")"
    else
      echo "JWT_SECRET generated and saved to $SECRET_FILE." >&2
    fi
  fi

  if ! chmod 700 "$SECRET_DIR" || ! chmod 600 "$SECRET_FILE"; then
    echo "Unable to restrict permissions on JWT secret files." >&2
    exit 1
  fi

  export JWT_SECRET
fi

cleanup() {
  for pid in "${PIDS[@]:-}"; do
    if kill -0 "$pid" 2>/dev/null; then
      stop_process_tree "$pid"
    fi
  done
  wait || true
}

stop_process_tree() {
  local pid="$1"
  local child

  for child in $(pgrep -P "$pid" 2>/dev/null || true); do
    stop_process_tree "$child"
  done

  kill "$pid" 2>/dev/null || true
}

assert_ports_free() {
  local port

  for port in "$@"; do
    if (exec 3<>"/dev/tcp/127.0.0.1/$port") 2>/dev/null; then
      echo "Port ${port} is already in use; stop its existing service before starting this stack." >&2
      return 1
    fi
  done
}

wait_for_port() {
  local port="$1"
  local service_name="$2"
  local service_pid="$3"
  local timeout_seconds="${4:-180}"
  local elapsed=0

  while ! (exec 3<>"/dev/tcp/127.0.0.1/$port") 2>/dev/null; do
    if ! kill -0 "$service_pid" 2>/dev/null; then
      echo "${service_name} exited before opening port ${port}" >&2
      return 1
    fi
    sleep 2
    elapsed=$((elapsed + 2))
    if [ "$elapsed" -ge "$timeout_seconds" ]; then
      echo "Timeout while waiting for ${service_name} on port ${port}" >&2
      return 1
    fi
  done

  if ! kill -0 "$service_pid" 2>/dev/null; then
    echo "${service_name} exited while opening port ${port}" >&2
    return 1
  fi
}

start_java_service() {
  local service_dir="$1"
  local main_class="$2"

  (
    cd "$service_dir"
    mvn -f pom.xml -pl adapter -am install -DskipTests
    exec mvn -f adapter/pom.xml spring-boot:run -Dspring-boot.run.main-class="$main_class"
  ) &

  PIDS+=("$!")
  SERVICE_PID="$!"
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
  SERVICE_PID="$!"
}

trap cleanup EXIT
trap 'exit 130' INT
trap 'exit 143' TERM

assert_ports_free 8082 8084 8080 5173

echo "Starting user-service..."
start_java_service "$ROOT_DIR/user-service" "org.user.service.Start"
wait_for_port 8082 "user-service" "$SERVICE_PID"

echo "Starting core-service..."
start_java_service "$ROOT_DIR/core-service" "org.core.Start"
wait_for_port 8084 "core-service" "$SERVICE_PID"

echo "Starting api-gateway..."
start_java_service "$ROOT_DIR/api-gateway" "org.api.gateway.Start"
wait_for_port 8080 "api-gateway" "$SERVICE_PID"

echo "Starting UIApp..."
start_ui_app
wait_for_port 5173 "UIApp" "$SERVICE_PID"

echo "All services are running."
wait
