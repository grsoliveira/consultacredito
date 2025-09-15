# ConsultaCrédito

Monorepo contendo duas aplicações:

- **consultacredito-api**: API Spring Boot para gerenciamento de créditos.
- **consultacredito-front**: Frontend Angular para consulta e visualização de créditos.

---

## Pré-requisitos

- [Docker](https://www.docker.com/get-started) instalado
- [Docker Compose](https://docs.docker.com/compose/install/) instalado
- Node.js >= 18 (para build local do frontend, opcional)
- Maven 3.x (para build local da API, opcional)
- PostgreSQL rodando na máquina host (fora do Docker), banco: `consultacredito`

> Observação: no Docker, o frontend acessa a API via `host.docker.internal` no Windows/Mac ou IP da máquina no Linux.

---

## Estrutura do projeto

- consultacredito/
  - consultacredito-api/ # API Spring Boot
  - consultacredito-front/ # Frontend Angular
  - docker-compose.yml # Orquestração dos containers
  - README.md
 
---

## Configuração do banco de dados

O `application.properties` da API deve apontar para o PostgreSQL local:

```properties
spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/consultacredito
spring.datasource.username=postgres
spring.datasource.password=pwd123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database=postgresql
```

No Linux substitua host.docker.internal pelo IP real da sua máquina.

# Rodando o projeto com Docker

1. Navegue até a raiz do projeto:

```bash
cd consultacredito
```

2. Suba todos os containers:
```bash
docker compose up --build
```
- API: http://localhost:8080/api/v1/creditos
- Frontend: http://localhost:4200


3. Subir apenas a API:
```bash
docker compose up consultacredito-api
```

4. Subir apenas o Frontend:
```bash
docker compose up consultacredito-front
```

5. Parar todos os containers:
```bash
docker compose down
```


# Rodando localmente

### API
```bash
cd consultacredito-api
mvn clean install
mvn spring-boot:run
```

### Frontend
```bash
cd consultacredito-front
npm install
npm run build --configuration production
npm start
```


# Histórico dos projetos

- O repositório foi unificado como monorepo, mantendo o histórico completo de cada projeto.
- `consultacredito-api/` contém todo o histórico da API original.
- `consultacredito-front/` contém todo o histórico do frontend original.
