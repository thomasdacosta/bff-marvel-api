@echo off

echo ### Criando IAM Roles...
aws --endpoint http://localhost:4566 --profile localstack iam create-role --role-name marvelWorkerFunctionRole --assume-role-policy-document "{\"Version\": \"2012-10-17\",\"Statement\": [{ \"Effect\": \"Allow\", \"Principal\": {\"Service\": \"lambda.amazonaws.com\"}, \"Action\": \"sts:AssumeRole\"}]}"
aws --endpoint http://localhost:4566 --profile localstack iam attach-role-policy --role-name marvelWorkerFunctionRole --policy-arn arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole
aws --endpoint http://localhost:4566 --profile localstack iam attach-role-policy --role-name marvelWorkerFunctionRole --policy-arn arn:aws:iam::aws:policy/service-role/AWSLambdaSQSQueueExecutionRole

echo ### Criando Lambda...
aws --endpoint http://localhost:4566 --profile localstack lambda create-function --function-name marvelWorkerFunction --zip-file fileb://aws-lambda-marvel-worker-1.0.jar --handler br.com.thomasdacosta.handler.ApplicationHandler --runtime java11 --role arn:aws:iam::000000000000:role/marvelWorkerFunctionRole
aws --endpoint http://localhost:4566 --profile localstack lambda create-event-source-mapping --function-name marvelWorkerFunction --batch-size 10 --event-source-arn arn:aws:sqs:us-east-1:000000000000:marvelThumbnailImageQueue
