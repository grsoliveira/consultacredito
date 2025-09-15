# ConsultaCrédito API

API Spring Boot para gerenciamento de créditos.

---

## Pré-requisitos

- Java 17+
- Maven 3.x
- PostgreSQL rodando na máquina host (fora do Docker), banco: `consultacredito`
- Docker e Docker Compose (opcional)

> Observação: dentro do Docker, use `host.docker.internal` no Windows/Mac ou o IP da máquina no Linux para acessar o banco.

---

## Configuração do banco

`application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/consultacredito
spring.datasource.username=postgres
spring.datasource.password=pwd123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database=postgresql
```

## Rodando com Docker

1. Build e up do container:
```bash
docker compose up --build consultacredito-api
```

2. API disponível em: http://localhost:8080/api/v1/creditos

3. Parar o container:
```bash
docker compose down
```

### Endpoints principais

- GET /api/v1/creditos → Lista todos os créditos
- GET /api/v1/creditos/credito/{numeroCredito} → Consulta por número de crédito
- GET /api/v1/creditos/{numeroNfse} → Consulta por número NFSE
