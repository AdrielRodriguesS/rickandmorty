# API Java Client - Rick and Morty
## Descrição
CRUD completo de Personagens e Localizações baseado na animação Rick & Morty.
## Como Rodar
### Pré Requisitos
- Java 17  
- Maven  
- Porta 8080 disponível
### Instalação do Maven
Para saber se o Maven está instalado, abra o terminal e insira **mvn --version**, caso não apareca a versão, será necessário instalá-lo.  
Link do tutorial da instalação: https://dicasdejava.com.br/como-instalar-o-maven-no-windows/
### Executar a aplicação
- Faça o clone do projeto
- Execute o prompt de comando/terminal na pasta do projeto (cd caminho da pasta).  
- Execute o comando **mvn clean install** para instalar as dependências.  
- Execute o comando **mvn spring-boot:run** e o projeto iniciará na porta 8080.
- A aplicação cria um banco de dados em memória com os dados do arquivo [data.sql](src/main/resources/data.sql).
## Como utilizar a Aplicação
### Postman
Abra o Postman e importe o arquivo [Rick&Morty.postman_collection.json](Rick&Morty.postman_collection.json) que está na pasta do projeto.  
Todos os end-points estão configurados. Os métodos POST e PUT já contém o body da requisição com os dados.
  
![Postman](https://github.com/AdrielRodriguesS/rickandmorty/blob/main/assets/Postman_img.png)
### Swagger
Abra [esse link](http://localhost:8080/swagger-ui/index.html) no seu navegador para acessar a documentação da aplicação implentada com Swagger.  
  
![Swagger](https://github.com/AdrielRodriguesS/rickandmorty/blob/main/assets/Swagger_img.png)
### Observações
- Quando é dado o comando para criar um Personagem (POST), a própria aplicação preenche a url, a data de criação e insere o personagem
na lista de residents da tabela localizações.
- Somente é possível apagar um local quando o mesmo não está sendo utilizado por nenhum personagem. Como sugestão, crie um local e depois o apague.
- Caso não consiga utilizar a porta 8080, edite o arquivo [application.properties](src/main/resources/application.properties) e altere o **server.port** e o
**mainPath** com o número da porta ou url. Edite também o arquivo [data.sql](src/main/resources/data.sql) realizando um **replace all** em todos os textos ou 
urls que contenham "8080".
### be happy!!
  
### Adriel Rodrigues
https://www.linkedin.com/in/adriel-rodrigues-70706551/
