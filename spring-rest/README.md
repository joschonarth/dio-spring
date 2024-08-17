# Arquitetura de Aplicações REST com Spring Web 🍃

Repositório do curso Arquitetura de Aplicações REST com Spring Web da [DIO](https://www.dio.me/). Este projeto demonstra as melhores práticas e padrões recomendados para construir APIs RESTful robustas e escaláveis com Spring Boot. Abaixo, você encontrará uma visão geral das principais características e funcionalidades incluídas.

## 📑 Sumário

- [Visão Geral](#visão-geral)
- [Spring Initializr](#criação-do-projeto-com-spring-initializr)
- [Principais Componentes](#principais-componentes)
  - [Estilo Arquitetural REST](#estilo-arquitetural-rest)
  - [Endpoints REST](#endpoints-rest)
  - [Tratamento de Exceções](#tratamento-de-exceções)
  - [Spring Security](#spring-security)
  - [Spring Boot Actuator](#spring-boot-actuator)
  - [Testes Unitários](#testes-unitários)
  - [Testando Endpoints REST com MockMvc](#testando-endpoints-rest-com-mockmvc)
- [Documentação](#📄-documentação)
- [Referências](#🔍-referências)

## Visão Geral

Este projeto é uma implementação de referência para aplicações RESTful utilizando as seguintes práticas e tecnologias:

- **Estilo Arquitetural REST**: Adota a arquitetura REST para criar serviços web escaláveis e independentes. Os recursos são expostos por meio de endpoints e manipulados utilizando os métodos HTTP apropriados.
  
- **Endpoints REST**: Utiliza `@RestController` para definir endpoints REST que manipulam requisições e retornam respostas no formato JSON ou XML.

- **Tratamento de Exceções**: Implementa um tratamento centralizado de exceções utilizando `@ControllerAdvice` e `@ExceptionHandler` para capturar e tratar exceções de forma global e personalizada.

- **Spring Security**: Configurado para proteger a aplicação com autenticação e autorização, garantindo que apenas usuários autorizados possam acessar recursos protegidos.

- **Spring Boot Actuator**: Inclui o Actuator para monitoramento e gerenciamento da aplicação, oferecendo endpoints para verificar o estado e a saúde da aplicação.

- **Testes Unitários**: Utiliza JUnit e a anotação `@SpringBootTest` para garantir que a aplicação funcione corretamente. JUnit é um framework que facilita o desenvolvimento e execução de testes unitários em código Java.

- **Teste de Endpoints REST com MockMvc**: Usa `MockMvc` para testar endpoints REST de forma isolada. O `MockMvc` permite realizar requisições e verificar respostas sem precisar iniciar o servidor.

## Criação do Projeto com Spring Initializr

Para criar um novo projeto Spring Boot, você pode usar o [Spring Initializr](https://start.spring.io/), uma ferramenta que gera um projeto base para você com as dependências necessárias. Siga os passos abaixo:

1. Acesse o [Spring Initializr](https://start.spring.io/).

2. Configure o projeto com as seguintes opções:
   - **Project**: Maven Project
   - **Language**: Java
   - **Spring Boot**: Escolha a versão estável mais recente
   - **Group**: com.exemplo
   - **Artifact**: nome-do-projeto
   - **Name**: Nome do Projeto
   - **Description**: Descrição do Projeto
   - **Package Name**: com.exemplo.nomedomprojeto
   - **Packaging**: Jar
   - **Java**: 17 (ou versão mais recente)

3. Adicione as seguintes dependências:
   - **Spring Web**: Para criar APIs RESTful e manipular requisições HTTP.
   - **Spring Data JPA**: Para integrar com bancos de dados relacionais e realizar operações CRUD.
   - **Spring Security**: Para adicionar autenticação e autorização à sua aplicação.
   - **Spring Boot Actuator**: Para monitorar e gerenciar a aplicação.

4. Clique em **Generate** para baixar o projeto.

5. Extraia o arquivo ZIP e abra-o em sua IDE preferida.

Aqui está um exemplo das dependências que você deve adicionar ao seu arquivo `pom.xml` se estiver configurando manualmente:

```xml
<dependencies>
    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- Spring Boot Actuator -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!-- Banco de dados (exemplo: H2) -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Testes -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Principais Componentes

### Estilo Arquitetural REST

O projeto segue o estilo arquitetural REST para criar serviços web que são fáceis de escalar e manter. Os recursos são acessados por meio de URLs específicas e manipulados utilizando métodos HTTP (GET, POST, PUT, DELETE).

### Endpoints REST

Os endpoints são definidos com a anotação `@RestController`. Eles manipulam requisições e retornam respostas em formatos como JSON, facilitando a integração com clientes e outras aplicações.

### Tratamento de Exceções
Utiliza `@ControllerAdvice` para definir manipuladores globais de exceções. A anotação `@ExceptionHandler` é usada para tratar exceções específicas e fornecer respostas personalizadas.

### Spring Security
Spring Security é utilizado para proteger a aplicação. A configuração de segurança é feita na classe `SecurityConfig` para definir as regras de acesso e autenticação.

```bash
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### Spring Boot Actuator
Spring Boot Actuator é utilizado para monitorar e gerenciar a aplicação. Adiciona endpoints que permitem verificar o estado da aplicação e obter informações úteis para manutenção.

Para adicionar o Actuator, adicione a dependência ao seu arquivo de configuração:

```bash
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### Testes Unitários
Os testes unitários são escritos usando JUnit e a anotação `@SpringBootTest`. JUnit é um framework que facilita o desenvolvimento e execução de testes unitários em código Java. A anotação `@SpringBootTest` é utilizada para inicializar o contexto do Spring e disponibilizar os Beans da aplicação para os testes.

### Testando Endpoints REST com MockMvc
Para testar os endpoints REST, utilizamos `MockMvc`, que permite fazer requisições e verificar respostas sem precisar iniciar o servidor. `MockMvcRequestBuilders` é usado para construir as requisições, enquanto `MockMvcResultMatchers` é utilizado para verificar as respostas.

## 📄 Documentação
- [Documentação JAVA](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Web Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
- [Spring Security Documentation](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [JUnit Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [MockMvc Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/test.html#spring-test)
- [Spring Boot Actuator Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)

### 🔍 Referências
- [Digital Innovation One](https://web.dio.me/).
