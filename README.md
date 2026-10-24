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

Prima dell'avvio serve il segreto per firmare i JWT. Se `JWT_SECRET` non è impostata, gli script ne generano uno temporaneo (i token si invalidano al riavvio). Per una sessione stabile:

```sh
export JWT_SECRET=$(openssl rand -base64 64 | tr -d '\n')
```

Gli script impostano `AUTH_COOKIE_SECURE=false` per consentire il cookie di sessione su `http://localhost`. In produzione usare HTTPS e lasciare `AUTH_COOKIE_SECURE=true`.

Lo script esegue prima la build dei moduli e poi avvia i servizi in questo ordine:

1. `user-service` su `8082`
2. `core-service` su `8084`
3. `api-gateway` su `8080`
4. `UIApp` su `5173`

## Avvio con Docker

```sh
JWT_SECRET=$(openssl rand -base64 64 | tr -d '\n') docker compose up --build
```

`JWT_SECRET` è obbligatoria: senza di essa il gateway non si avvia.

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
- Il gateway legge il segreto JWT da `JWT_SECRET` (nessun default nel codice). Il cookie di sessione è `HttpOnly`; il nome è configurabile con `AUTH_COOKIE_NAME` (default `uiapp_token`).
- Gli endpoint `/utenti` sono riservati agli ADMIN, tranne lettura e modifica del proprio profilo.
- Origini CORS consentite configurabili con `CORS_ALLOWED_ORIGINS` (default `http://localhost:5173`).
- Serve Node.js per l'avvio locale di `UIApp`.
- Gli script `Start.sh` e `Start.bat` lanciano i tre servizi backend dal loro `pom.xml` locale e usano le classi `Start` dei moduli `adapter`.
- I Dockerfile dei servizi backend producono jar con artifactId univoci per evitare conflitti nel reactor Maven.
- La versione Docker del frontend usa una build statica servita da Nginx e inoltra le chiamate API al gateway.
