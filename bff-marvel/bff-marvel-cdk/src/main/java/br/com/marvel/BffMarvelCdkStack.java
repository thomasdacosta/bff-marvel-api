package br.com.marvel;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.SecretValue;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.iam.ManagedPolicy;
import software.amazon.awscdk.services.iam.Role;
import software.amazon.awscdk.services.iam.RoleProps;
import software.amazon.awscdk.services.iam.ServicePrincipal;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.lambda.*;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketProps;
import software.amazon.awscdk.services.secretsmanager.Secret;
import software.amazon.awscdk.services.ses.actions.S3;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.IQueue;
import software.amazon.awscdk.services.sqs.Queue;
import software.amazon.awscdk.services.ssm.StringParameter;
import software.amazon.awscdk.services.ssm.StringParameterProps;
import software.constructs.Construct;

import java.util.HashMap;
import java.util.Map;

public class BffMarvelCdkStack extends Stack {

    public BffMarvelCdkStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public BffMarvelCdkStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
    }

    public void create() {
        createSecretsManager();
        createParameterStore();
        createS3();
        Queue queue = createSQS();
        createSNS(queue);
        createLambda(queue);
    }

    private void createSecretsManager() {
        // SecretManager
        SecretValue secretValue = new SecretValue("{" +
                "\"ts\":\"1\"," +
                "\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\"," +
                "\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}");

        Secret.Builder
                .create(this, "secretBffMarvelApiLocalstack")
                .description("Segredos para acesso a API da Marvel")
                .secretName("/secret/bff-marvel-api_localstack")
                .secretStringValue(secretValue)
                .build();

        Secret.Builder
                .create(this, "secretBffMarvelApi")
                .description("Segredos para acesso a API da Marvel")
                .secretName("/secret/bff-marvel-api")
                .secretStringValue(secretValue)
                .build();

        Secret.Builder
                .create(this, "secretApplication")
                .description("Segredos para acesso a API da Marvel")
                .secretName("/secret/application")
                .secretStringValue(secretValue)
                .build();

        Secret.Builder
                .create(this, "secretApplicationLocalstack")
                .description("Segredos para acesso a API da Marvel")
                .secretName("/secret/application_localstack")
                .secretStringValue(secretValue)
                .build();
    }

    private void createParameterStore() {
        // SSM Parameter Store
        new StringParameter(this, "configBffMarvelApiLocalstackNotificationName", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/notification.name")
                .stringValue("marvelThumbnailImageNotification")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackQueueName", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/queue.name")
                .stringValue("marvelThumbnailImageQueue")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackDirectory", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/directory")
                .stringValue("marvelcharacter")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackProxyHost", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/proxy.host")
                .stringValue("localhost")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackProxyPort", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/proxy.port")
                .stringValue("8081")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackProxyEnabled", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/proxy.enabled")
                .stringValue("false")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackMarvelPublicAPIV1Url", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/marvelPublicAPIV1.url")
                .stringValue("http://gateway.marvel.com/v1/public")
                .build());

        new StringParameter(this, "configBffMarvelApiLocalstackMarvelPublicAPIV1Name", StringParameterProps
                .builder()
                .parameterName("/config/bff-marvel-api_localstack/marvelPublicAPIV1.name")
                .stringValue("marvelPublicAPIV1")
                .build());
    }

    private void createS3() {
        // S3
        S3.Builder.create().bucket(new Bucket(this, "marvelCharacter",
                BucketProps.builder().bucketName("marvelcharacter")
                        .build())).build();
    }

    private Queue createSQS() {
        // SQS
        return Queue.Builder.create(this, "marvelThumbnailImageQueue")
                .queueName("marvelThumbnailImageQueue")
                .visibilityTimeout(Duration.seconds(300))
                .build();
    }

    private void createSNS(IQueue queue) {
        // SNS
        final Topic topic = Topic.Builder.create(this, "marvelThumbnailImageNotification")
                .topicName("marvelThumbnailImageNotification")
                .build();
        topic.addSubscription(new SqsSubscription(queue));
    }

    private void createLambda(IQueue queue) {
        // IAM Role
        Role role = new Role(this, "marvelWorkerFunctionRole", RoleProps.builder()
                .assumedBy(new ServicePrincipal("lambda.amazonaws.com"))
                .roleName("marvelWorkerFunctionRole")
                .build());

        role.addManagedPolicy(ManagedPolicy.fromAwsManagedPolicyName("AWSLambdaExecute"));
        role.addManagedPolicy(ManagedPolicy.fromAwsManagedPolicyName("AmazonSQSFullAccess"));
        role.addManagedPolicy(ManagedPolicy.fromAwsManagedPolicyName("AmazonS3FullAccess"));

        // Lambda
        Map<String, String> environment = new HashMap<>();
        environment.put("ENV_TYPE", "localstack");

        IFunction function = new Function(this, "marvelWorkerFunction", FunctionProps.builder()
                .functionName("marvelWorkerFunction")
                .role(role)
                .code(Code.fromAsset("../aws-lambda-marvel-worker/MarvelWorkerFunction/target/aws-lambda-marvel-worker-1.0.0-SNAPSHOT.jar"))
                .handler("br.com.thomasdacosta.handler.ApplicationHandler")
                .runtime(Runtime.JAVA_11)
                .environment(environment)
                .timeout(Duration.seconds(600))
                .memorySize(512)
                .build());

        new EventSourceMapping(this,"eventSourceMappingLambdaSQS", EventSourceMappingProps.builder()
                .target(function)
                .eventSourceArn(queue.getQueueArn())
                .build());
    }
}
