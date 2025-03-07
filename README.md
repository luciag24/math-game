# Matematická hra

Aplikace pro generování a řešení matematických příkladů pro různé ročníky základní školy.

## Popis projektu

Matematická hra je Spring Boot aplikace, která umožňuje:
- Generovat matematické příklady pro 1. až 4. ročník základní školy
- Kontrolovat správnost odpovědí
- Sledovat statistiky úspěšnosti

## Technologie

- Backend: Java 17, Spring Boot 3.1.5
- Frontend: HTML, CSS, JavaScript
- Databáze: MySQL 8.0
- Containerization: Docker

## Požadavky pro lokální vývoj

- Java 17+
- Maven 3.8+
- MySQL 8.0 nebo Docker

## Jak spustit aplikaci

### Pomocí Maven (bez Dockeru)

1. Naklonujte repozitář
   ```bash
   git clone <URL_repozitáře>
   cd math-game
   ```

2. Sestavte aplikaci
   ```bash
   mvn clean package -DskipTests
   ```

3. Spusťte aplikaci
   ```bash
   java -jar target/DetApp-1.0-SNAPSHOT.jar
   ```

4. Otevřete aplikaci na adrese `http://localhost:8090`

### Pomocí Docker Compose

1. Naklonujte repozitář
   ```bash
   git clone <URL_repozitáře>
   cd math-game
   ```

2. Sestavte aplikaci (potřeba pro Docker build)
   ```bash
   mvn clean package -DskipTests
   ```

3. Spusťte Docker Compose
   ```bash
   docker-compose up -d
   ```

4. Otevřete aplikaci na adrese `http://localhost:8090`

### Manuální spuštění s Docker

1. Sestavte aplikaci
   ```bash
   mvn clean package -DskipTests
   ```

2. Sestavte Docker image
   ```bash
   docker build -t math-game -f Dockerfile.simple .
   ```

3. Vytvořte Docker síť
   ```bash
   docker network create math-game-network
   ```

4. Spusťte MySQL kontejner
   ```bash
   docker run --name math-game-mysql --network math-game-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=math_game -p 3307:3306 -d mysql:8.0
   ```

5. Spusťte aplikaci
   ```bash
   docker run --name math-game-app --network math-game-network -e SPRING_DATASOURCE_URL=jdbc:mysql://math-game-mysql:3306/math_game -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root -p 8090:8090 -d math-game
   ```

6. Otevřete aplikaci na adrese `http://localhost:8090`

## Problémy a řešení

### Konflikt portů
Pokud máte lokálně běžící MySQL na portu 3306, použijte port 3307 pro Docker MySQL:
```bash
docker run --name math-game-mysql --network math-game-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=math_game -p 3307:3306 -d mysql:8.0
```

### Problém s Maven sestavením v Docker
V některých sítích může být problém s připojením k Maven repozitáři během Docker build. Proto používáme jednodušší přístup s lokálním sestavením a `Dockerfile.simple`.

## Struktura projektu

```
math-game/
├── src/                           # Zdrojové kódy
│   ├── main/
│   │   ├── java/org/example/      # Java kód
│   │   │   ├── config/            # Konfigurace
│   │   │   ├── controllers/       # Řadiče (controllers)
│   │   │   ├── dto/               # Data Transfer Objects
│   │   │   ├── mapper/            # Mapovací třídy
│   │   │   ├── models/            # Datové modely
│   │   │   ├── repositories/      # Repozitáře
│   │   │   └── services/          # Služby (services)
│   │   └── resources/
│   │       ├── static/            # Statické soubory (CSS, JS)
│   │       ├── templates/         # HTML šablony
│   │       └── application.properties # Konfigurace aplikace
├── Dockerfile.simple              # Docker konfigurace
├── docker-compose.yml             # Docker Compose konfigurace
├── pom.xml                        # Maven konfigurace
└── README.md                      # Dokumentace projektu
```

## Licence

Tento projekt je licencován pod [MIT licencí](LICENSE).
---

<img width="723" alt="math-game" src="https://github.com/user-attachments/assets/531e1a06-1d24-4dd1-bdc5-2c7b69b3b9d7" />
