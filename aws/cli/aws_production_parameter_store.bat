@echo off

echo Criando Chaves no AWS Paramter Store do LocalStack...
aws ssm put-parameter --name "/config/bff-marvel-api_production/ts" --value "1" --type String
aws ssm put-parameter --name "/config/bff-marvel-api_production/apiKey" --value "f59dbe01285f1d360542b5c47a9516e3" --type String
aws ssm put-parameter --name "/config/bff-marvel-api_production/hash" --value "0ea6be79e04ac1b0400d65ffc11088f9" --type String

aws ssm put-parameter --name "/config/bff-marvel-api_production/marvelPublicAPIV1.url" --value "http://gateway.marvel.com/v1/public" --type String
aws ssm put-parameter --name "/config/bff-marvel-api_production/marvelPublicAPIV1.name" --value "marvelPublicAPIV1" --type String

aws ssm put-parameter --name "/config/bff-marvel-api_production/directory" --value "marvelcharacter" --type String

aws ssm put-parameter --name "/config/bff-marvel-api_production/proxy.host" --value "localhost" --type String
aws ssm put-parameter --name "/config/bff-marvel-api_production/proxy.port" --value "8081" --type String
aws ssm put-parameter --name "/config/bff-marvel-api_production/proxy.enabled" --value "false" --type String
