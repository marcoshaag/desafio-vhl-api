# Projeto VHL - API Selo Digital

## Visão Geral
API REST para integração com o serviço SOAP do Selo Digital de Fiscalização do TJSC, proporcionando acesso padronizado a dados de entidades de utilidade pública estadual com paginação e filtros.

## Tecnologias e Ferramentas
- **Java 17** 
- **Spring Boot 3.2**
- **Apache CXF 4.0** (Cliente SOAP)
- **SpringDoc OpenAPI 2.3** (Documentação)
- **Lombok** 
- **Maven** 

### Testes
- **JUnit 5** + **Mockito**
- **Spring Boot Test** 

## Funcionalidades

### Endpoint Principal
`GET /api/selo-digital/entes`

#### Capacidades:
- **Paginação** (`page`, `size`)
- **Filtros**:
  - `codigo`
  - `nome`
-  **Documentação Automatizada** (Swagger UI)
-  **Testes Unitários** 

## Configuração

### Pré-requisitos
- Java 17+
- Maven 3.9+
- [Acesso ao ambiente de homologação TJSC](https://selo.tjsc.jus.br/XMLSchema/v4.1/interoperabilidade_sd_4.1.pdf))

### Arquivo `application.properties`
```properties
# Configurações básicas
spring.application.name=VHL.teste

# Integração SOAP
selo.service.username=cartorio
selo.service.password=selodigital
selo.service.address=https://selo.tjsc.jus.br/selo_teste/SeloService 
```

### Execução
```
# Build do projeto
mvn clean install

# Inicialização
mvn spring-boot:run

# Todos os testes
mvn test
```
### Exemplo de Requisição

```
GET http://localhost:8080/api/selo-digital/entes?nome=Prefeitura&page=0&size=5
GET http://localhost:8080/api/selo-digital/entes?codigo=12
GET http://localhost:8080/api/selo-digital/entes?nome=APP

```
### Acesso Swagger
```
http://localhost:8080/swagger-ui.html
```







