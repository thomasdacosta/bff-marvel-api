# BFF Marvel API

BFF (Backends For Frontends) desenvolvido em Spring Boot que efeuta o acesso as API´s Oficiais da Marvel e busca o personagem, HQ´s e eventos de acordo com o nome pesquisado.

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
## Diretórios

- **bff-marvel:** aplicação Maven multi-module com as chamadas da API da Marvel
- **marvel:** exemplo de código gerado a partir do Swagger da API da Marvel

---

Thomás da Costa - [https://thomasdacosta.com.br](https://thomasdacosta.com.br)
