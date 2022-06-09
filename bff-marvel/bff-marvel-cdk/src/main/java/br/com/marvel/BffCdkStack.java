package br.com.marvel;

import software.amazon.awscdk.SecretValue;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.secretsmanager.Secret;
import software.amazon.awscdk.services.ses.actions.S3;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.Queue;
import software.amazon.awscdk.services.ssm.StringParameterProps;
import software.constructs.Construct;

public class BffCdkStack extends Stack {

    public BffCdkStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public BffCdkStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        // SecretManager
        SecretValue secretValue = new SecretValue("{\\\"ts\\\":\\\"1\\\",\\\"apiKey\\\":\\\"f59dbe01285f1d360542b5c47a9516e3\\\",\\\"hash\\\":\\\"0ea6be79e04ac1b0400d65ffc11088f9\\\"}");
        Secret.Builder
                .create(this, "/secret/bff-marvel-api_localstack")
                .description("Segredos para acesso a API da Marvel")
                .secretStringValue(secretValue);

        Secret.Builder
                .create(this, "/secret/bff-marvel-api")
                .description("Segredos para acesso a API da Marvel")
                .secretStringValue(secretValue);

        Secret.Builder
                .create(this, "/secret/application")
                .description("Segredos para acesso a API da Marvel")
                .secretStringValue(secretValue);

        Secret.Builder
                .create(this, "/secret/application_localstack")
                .description("Segredos para acesso a API da Marvel")
                .secretStringValue(secretValue);

        // SSM Parameter Store
        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/notification.name").stringValue("marvelThumbnailImageNotification");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/queue.name").stringValue("marvelThumbnailImageQueue");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/directory").stringValue("marvelcharacter");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/proxy.host").stringValue("localhost");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/proxy.port").stringValue("8081");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/proxy.enabled").stringValue("false");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/marvelPublicAPIV1.url").stringValue("http://gateway.marvel.com/v1/public");

        StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/marvelPublicAPIV1.name").stringValue("marvelPublicAPIV1");

        // S3
        S3.Builder.create().bucket(new Bucket(this, "marvelcharacter")).build();

        // SQS
        final Queue queue = Queue.Builder.create(this, "marvelThumbnailImageQueue")
                .build();

        // SNS
        final Topic topic = Topic.Builder.create(this, "marvelThumbnailImageNotification")
                .build();

        topic.addSubscription(new SqsSubscription(queue));
    }
}
