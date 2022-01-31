@echo off

echo Criando Segredos no AWS Secret Manager do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/bff-marvel-api_localstack --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/bff-marvel-api --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application_localstack --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"

echo Criando Chaves no AWS Paramter Store do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/proxy.host" --value "localhost" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/proxy.port" --value "8081" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/proxy.enabled" --value "false" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/marvelPublicAPIV1.url" --value "http://gateway.marvel.com/v1/public" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/marvelPublicAPIV1.name" --value "marvelPublicAPIV1" --type String
