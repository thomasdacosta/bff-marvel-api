@echo off

echo ### Criando IAM Roles...
aws iam create-role --role-name marvelWorkerFunctionRole --assume-role-policy-document "{\"Version\": \"2012-10-17\",\"Statement\": [{ \"Effect\": \"Allow\", \"Principal\": {\"Service\": \"lambda.amazonaws.com\"}, \"Action\": \"sts:AssumeRole\"}]}"
aws iam attach-role-policy --role-name marvelWorkerFunctionRole --policy-arn arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole
aws iam attach-role-policy --role-name marvelWorkerFunctionRole --policy-arn arn:aws:iam::aws:policy/service-role/AWSLambdaSQSQueueExecutionRole
aws iam attach-role-policy --role-name marvelWorkerFunctionRole --policy-arn arn:aws:iam::aws:policy/service-role/AmazonS3FullAccess

echo ### Criando Lambda...
aws lambda create-function --function-name marvelWorkerFunction --zip-file fileb://aws-lambda-marvel-worker-1.0.jar --handler br.com.thomasdacosta.handler.ApplicationHandler --runtime java11 --role arn:aws:iam::103638502867:role/marvelWorkerFunctionRole
aws lambda create-event-source-mapping --function-name marvelWorkerFunction --batch-size 10 --event-source-arn arn:aws:sqs:sa-east-1:103638502867:marvelThumbnailImageQueue