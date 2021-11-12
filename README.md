# BFF Marvel API

https://developer.marvel.com/

https://speca.io/speca/marvel-public-api-v1#list-characters

wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.29/swagger-codegen-cli-3.0.29.jar -O swagger-codegen-cli.jar

java -jar swagger-codegen-cli.jar generate -i marvel-public-api-v1-swagger.json -l spring --library spring-cloud -o samples/client/petstore/java
