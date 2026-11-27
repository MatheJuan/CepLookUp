# Cep-Lookup


\


## Sobre o projeto

O Cep-Lookup é uma API REST desenvolvida em Java com Spring Boot para consulta de endereços brasileiros a partir do CEP, utilizando a integração com o serviço externo ViaCEP.
Tem como objetivo por em prática conceitos de integração entre sistemas, consumo de APIs externas, arquitetura em camadas, injeção de dependências e tratamento centralizado de exceções.

A comunicação com o serviço externo é realizada utilizando o HttpClient nativo do Java, enquanto o Jackson é responsável pelo processamento dos dados JSON.

## Funcionalidades

- Consulta de endereços por CEP.
- Integração com a API ViaCEP.
- Validação do formato do CEP.
- Identificação de CEPs inexistentes.
- Tratamento de falhas de comunicação externa.
- Tratamento de timeout.
- Tratamento global de exceções.
- Padronização das respostas de erro.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Java HttpClient
- Jackson
- Maven

## Arquitetura

O projeto utiliza uma arquitetura em camadas para manter a separação de responsabilidades e reduzir o acoplamento entre os componentes.

```text
src/main/java/br/com/devlpjuan/ceplookup/
├── client/
├── config/
├── controller/
├── dto/
├── exception/
├── service/
└── CepLookupApplication.java
```

| Camada     | Responsabilidade                             |
| ---------- | -------------------------------------------- |
| Controller | Exposição dos endpoints REST                 |
| Service    | Validação e regras de negócio                |
| Client     | Comunicação com a API externa                |
| DTO        | Transferência de dados                       |
| Exception  | Definição e tratamento de exceções           |
| Config     | Configuração e gerenciamento de dependências |

### Fluxo da aplicação

```text
HTTP Request
     |
CepController
     |
 CepService
     |
  CepClient
     |
  ViaCEP API
```

## Endpoints

### Consultar endereço por CEP

```http
GET /api/ceps/{cep}
```

Exemplo de requisição:

```http
GET http://localhost:8080/api/ceps/01001000
```

Exemplo de resposta:

```json
{
    "cep": "01001-000",
    "logradouro": "Praça da Sé",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP"
}
```

## Tratamento de exceções

| Status HTTP         | Descrição                                  |
| ------------------- | ------------------------------------------ |
| 200 OK              | Consulta realizada com sucesso             |
| 400 Bad Request     | Formato de CEP inválido                    |
| 404 Not Found       | CEP não encontrado                         |
| 502 Bad Gateway     | Falha na comunicação com o serviço externo |
| 504 Gateway Timeout | Tempo limite da requisição excedido        |

Exemplo de resposta de erro:

```json
{
    "status": 400,
    "message": "CEP inválido",
    "timestamp": "2026-11-26T20:00:00Z"
}
```

## Decisões técnicas

### HttpClient nativo do Java

A utilização do HttpClient tem como objetivo explorar os recursos nativos da linguagem Java para comunicação HTTP, incluindo configuração de requisições, gerenciamento de timeouts e tratamento de falhas.

### Injeção de dependências

O HttpClient é registrado como um Bean no container do Spring, permitindo a centralização de suas configurações, reutilização da instância e maior facilidade na realização de testes.

### Tratamento centralizado de exceções

As exceções técnicas da integração externa são convertidas em exceções personalizadas, evitando que detalhes da implementação HTTP sejam propagados desnecessariamente para as demais camadas.

## Como executar o projeto

### Pré-requisitos

- JDK compatível com o projeto.
- Maven.
- Conexão com a internet.

### Executando a aplicação

Na pasta raiz do projeto, execute:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```
## Serviço externo

- [ViaCEP — Documentação oficial](https://viacep.com.br/)
