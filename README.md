# Sistema Skill (Back-End)

## Descrição do projeto

O BackSistemaSkill é um projeto back-end Maven em Spring Boot (3.1.10), desenvolvido em Java (17.0.11) como parte do teste prático da empresa [Neki](https://neki.com.br/). O objetivo deste projeto é fornecer um sistema de Skills, permitindo operações CRUD de habilidades e usuários, bem como autenticação com geração de senha criptografada e token JWT correspondente.

## Funcionalidades

Este projeto oferece as seguintes funcionalidades:
- Autenticação de usuários com geração de token JWT.
- Operações CRUD para habilidades (Skills).
- Operações CRUD para usuários.
- Associação de habilidades aos usuários com a possibilidade de atualizar o nível de habilidade.

## Pré-requisitos 

Certifique-se de ter o seguinte instalado em sua máquina:

- [Java 17](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
- [Maven](https://maven.apache.org/download.cgi?.)
- [PostgreSQL](https://www.postgresql.org/download/)

## Instalação

1. Clone este repositório:

   ```bash
   git clone https://github.com/juliafclima/mobilesistemaskill.git
   ```

2. Execute o seguinte comando para compilar e empacotar o projeto:

   ```bash
   mvn clean 
   mvn install 
   ```

## Uso

Para executar o projeto, você pode utilizar o plugin Maven Spring Boot:

```bash
mvn spring-boot:run
```

- [Front-End web](https://github.com/juliafclima/FrontSistemaSkill)

- [Front-End mobile](https://github.com/juliafclima/mobilesistemaskill)

## Configuração do Banco de Dados

Certifique-se de ter o PostgreSQL instalado e configurado corretamente. Por padrão, o projeto está configurado para usar o PostgreSQL como banco de dados. Você pode modificar as configurações de conexão no arquivo `application.properties`.  Estas são as configurações do Banco de Dados para este projeto:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/projeto
spring.datasource.username=postgres
spring.datasource.password=123456
```

## Dependências

1. Spring Boot Starter for Data JPA
2. Spring Boot Starter for Web
3. Spring Boot DevTools
4. PostgreSQL Driver
5. Spring Boot Starter for Testing
6. Project Lombok
7. Spring Boot Starter for Security
8. JWT API
9. JWT Implementation
10. JWT Jackson
11. Spring Boot Starter for Mail

## Documentação da API

A documentação da API está disponível no arquivo ```Create SistemaSkill.postman_collection.json``` para importação via Postman


## Conecte-se comigo 
<a href="https://www.linkedin.com/in/juliafclima/" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
[![Portfolio](https://img.shields.io/badge/Portfolio-FF5722?style=for-the-badge&logo=todoist&logoColor=white)](https://projeto-portfolio-ruddy.vercel.app)
[![E-mail](https://img.shields.io/badge/-Email-000?style=for-the-badge&logo=microsoft-outlook&logoColor=007BFF)](mailto:juliafclima@hotmail.com)

## Licença

Este projeto está licenciado sob a [MIT License](https://mit-license.org/).
