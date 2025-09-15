# ConsultaCrédito Frontend

Frontend Angular para consulta e visualização de créditos.

---

## Pré-requisitos

- Node.js >= 18
- NPM
- Docker e Docker Compose (opcional)
- A API `consultacredito-api` deve estar rodando e acessível

> Observação: dentro do Docker, o frontend acessa a API via `host.docker.internal` no Windows/Mac ou IP da máquina no Linux.

---

## Rodando com Docker

1. Build da imagem e up do container:

```bash
docker compose up --build consultacredito-front
```

2. Frontend disponível em: http://localhost:4200

3. Parar o container:
```bash
docker compose down
```

### Estrutura de acesso

- A tela inicial exibe a lista de créditos
- Funcionalidades principais:
  - Listagem de créditos
  - Busca por número de crédito ou NFSE
  - Visualização detalhada de crédito

