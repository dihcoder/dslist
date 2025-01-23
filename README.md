# Backend DSList

> Projeto do Intensivão Java Spring - Dev Superior

## Objetivo do projeto

Criar uma aplicação backend, no padrão camadas, com uma API REST para consulta e listagem de Jogos 

## Tecnologias Utilizadas

- Java
- SQL
- Spring Boot
- H2

## Estrutura padrão camadas

```
dslist/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.dihcoder.dslist/
│   │   │      ├── controllers/ # Controlador REST
│   │   │      ├── dto/
│   │   │      ├── entities/
│   │   │      ├── repositories/
│   │   │      ├── services/
│   │   │      └── DslistApplication.java
|   │   └── resources/
│   │       ├── application.properties
│   │       └── application-test.properties
│   └── test/
├── pom.xml
└── README.md
```

## O que foi desenvolvido em cada aula

### Aula 1 - API REST e Padrão Camadas

#### 1.1. Criação da estrutura do projeto no [Spring Initializr](https://start.spring.io/)

- **Linguagem**: Java
- **Gerenciador de Dependências**: Maven
- **Versão Spring Boot**: 3.4.2
- **Nome Pacote**: com.dihcoder
- **Nome Artefato**: dslist
- **Arquivo build**: jar
- **Versão Java**: 21
- **Dependências**:
  - Spring Web
  - Spring Data JPA
  - H2 Database
  - PostgreSQL Driver

#### 1.2. Configuração de plugin Maven
Adicionado ao `pom.xml`
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-resources-plugin</artifactId>
    <version>3.1.0</version> <!--$NO-MVN-MAN-VER$ -->
</plugin>
```

> Esse plugin é utilizado para processar e copiar recursos (resources) do projeto para o destino do build

#### 1.3. Versionamento do projeto no GitHub

- Repositório com o nome do projeto criado no GitHub 
- Ligação do repositório local com o remoto

    ```
    git init
    git commit -am "Project created"
    git branch -M main
    git remote add origin <link-ssh-do-repositório-remoto-criado>
    git push -u origin main
    ```
- Commit: *"Project created"*

#### 1.4. Configuração dos arquivos `.properties` em `resources`

- Arquivo `application.properties`

  ```
  spring.application.name=dslist
  spring.profiles.active=${APP_PROFILE:test}
  spring.jpa.open-in-view=false
  
  cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
  ```

- Arquivo `application-test.properties`

  ```
  # H2 Connection
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.username=sa
  spring.datasource.password=
  
  # H2 Client
  spring.h2.console.enabled=true
  spring.h2.console.path=/h2-console

  # Show SQL
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  ```

#### 1.5. Criação da entidade Game

- Atributos da Classe
  ```
  Long id;
  String title;
  Integer year;
  String genre;
  String platforms;
  Double score;
  String imgUrl;
  String shortDescription;
  String longDescription;
  ```
- Construtores da classe (com e sem argumentos)
- Getters e Setters
- Métodos Equals e Hashcode

#### 1.6. Mapeamento Objeto Relacional (ORM)

- Adição das Annotations:
  - `@Entity`
  - `@Table`
  - `@Id`
  - `@GeneratedValue`
  - `@Column`
- Commit: *"Config properties, create Game class and impl ORM"*

#### 1.7. Seed dos games (povoamento do banco de dados)

- Criar arquivo `import.sql` em `resources`
- Adicionar o seguinte conteúdo:
  ```
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Mass Effect Trilogy', 4.8, 2012, 'Role-playing (RPG), Shooter', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Red Dead Redemption 2', 4.7, 2018, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('The Witcher 3: Wild Hunt', 4.7, 2014, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Sekiro: Shadows Die Twice', 3.8, 2019, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Ghost of Tsushima', 4.6, 2012, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/5.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Super Mario World', 4.7, 1990, 'Platform', 'Super Ness, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Hollow Knight', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Ori and the Blind Forest', 4, 2015, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Cuphead', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Sonic CD', 4, 1993, 'Platform', 'Sega CD, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
  ```
- Commit: *"Game seed"*

#### 1.8. DTO e camadas `repositorys`, `services`,`controllers`

##### 1.8.1 Criação do DTO

- Atributos da Classe
  ```
  Long id;
  String title;
  Integer year;
  String imgUrl;
  String shortDescription;
  ```
- Construtor da classe com a entidade Game como argumento
- Getters

#### 1.8.2. Criação do objeto de acesso a dados

- Criação da interface GameRepository que extende a interface JPA Repository

#### 1.8.3. Criação da classe GameService

- Registro da classe como um componente do sistema (com a Annotation @Service)
- Injeção de uma instância do GameRepository na classe (com a Annotation @Autowired)
- Implementação do método findAll para retorno de DTOs

#### 1.8.3. Criação do controlador REST

- Registrar a classe como um componente controlador (com @RestController)
- Mapear o recurso Games (com o @RequestMapping)
- Injetar a dependência GameService
- Imlementar o endpoint para buscar a lista de games por DTO (com @GetMapping)
