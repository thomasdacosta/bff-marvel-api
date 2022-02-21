@echo off

echo Criando Segredos no AWS Secret Manager do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/bff-marvel-api_localstack --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/bff-marvel-api --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application_localstack --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"

echo Criando Chaves no AWS Parameter Store do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/notification.name" --value "marvelThumbnailImageNotification" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/queue.name" --value "marvelThumbnailImageQueue" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/directory" --value "marvelcharacter" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/proxy.host" --value "localhost" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/proxy.port" --value "8081" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/proxy.enabled" --value "false" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/marvelPublicAPIV1.url" --value "http://gateway.marvel.com/v1/public" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/bff-marvel-api_localstack/marvelPublicAPIV1.name" --value "marvelPublicAPIV1" --type String

echo Criando Bucket no S3 do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack s3 mb s3://marvelcharacter

echo Criando Queue(Standard) no SQS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name marvelThumbnailImageQueue

echo Criando Queue(Standard) no SNS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name marvelThumbnailImageNotification
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:marvelThumbnailImageNotification --protocol sqs --notification-endpoint http://localhost:4566/queue/marvelThumbnailImageQueue

echo Criando Queue(FIFO) no SQS do LocalStack...
echo aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name marvelThumbnailImageQueue.fifo --attributes FifoQueue=true

echo Criando Queue(FIFO) no SNS do LocalStack...
echo aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name marvelthumbnailimagenotification.fifo --attributes FifoTopic=true
echo aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:marvelthumbnailimagenotification.fifo --protocol sqs --notification-endpoint http://localhost:4566/queue/marvelThumbnailImageQueue.fifo