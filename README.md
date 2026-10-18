# Museo

## Avvio locale

Il progetto è aggregato dal `pom.xml` nel root `museo/`.

### macOS / Linux

```sh
chmod +x Start.sh
./Start.sh
```

### Windows

```bat
Start.bat
```

Lo script esegue prima la build dei moduli e poi avvia i servizi in questo ordine:

1. `user-service` su `8082`
2. `core-service` su `8084`
3. `api-gateway` su `8080`
4. `UIApp` su `5173`

## Avvio con Docker

```sh
docker compose up --build
```

##Stop con Docker

```sh
docker compose down
``` 

Servizi esposti:

- `user-service` -> `http://localhost:8082`
- `core-service` -> `http://localhost:8084`
- `api-gateway` -> `http://localhost:8080`
- `UIApp` -> `http://localhost:3000`

## Note

- Serve Java 21 per i moduli Spring Boot.
- Serve Node.js per l'avvio locale di `UIApp`.
- Gli script `Start.sh` e `Start.bat` lanciano i tre servizi backend dal loro `pom.xml` locale e usano le classi `Start` dei moduli `adapter`.
- I Dockerfile dei servizi backend producono jar con artifactId univoci per evitare conflitti nel reactor Maven.
- La versione Docker del frontend usa una build statica servita da Nginx e inoltra le chiamate API al gateway.
