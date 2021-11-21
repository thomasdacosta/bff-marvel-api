# BFF Marvel API



## Gerando o client da API da Marvel

Efetuar o cadastro no portal para obter as chaves e acesso a API da Marvel:

- https://developer.marvel.com/

Baixar o Swagger do site abaixo:

- https://speca.io/speca/marvel-public-api-v1

Com o Swagger, gerar o código da aplicação através do Swagger:

```sh
wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.29/swagger-codegen-cli-3.0.29.jar -O swagger-codegen-cli.jar
java -jar swagger-codegen-cli.jar generate -i marvel-public-api-v1-swagger.json -l spring --library spring-cloud -o marvel
```


