package br.com.thomasdacosta.handler.util;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Util {

    public enum Env {
        AWS, LOCALSTACK
    }

    private static final String AWS_REGION = "us-east-1";
    private static final String S3_ENDPOINT = "http://s3.localhost.localstack.cloud:4566/";

    private static AmazonS3ClientBuilder builder = null;
    private static AmazonS3 amazonS3 = null;

    public static AmazonS3 getS3(Env env) {
        if (env == Env.AWS)
            return getS3Aws();
        else if (env == Env.LOCALSTACK)
            return getS3LocalStack();
        else
            return null;
    }

    private static AmazonS3 getS3Aws() {
        if (amazonS3 == null)  {
            amazonS3 = AmazonS3ClientBuilder.standard().build();
        }
        return amazonS3;
    }

    private static AmazonS3 getS3LocalStack() {
        if (builder == null)  {
            AwsClientBuilder.EndpointConfiguration config =
                    new AwsClientBuilder.EndpointConfiguration(S3_ENDPOINT, AWS_REGION);
            AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();
            builder.withEndpointConfiguration(config);
            amazonS3 = builder.build();
        }
        return amazonS3;
    }

}
