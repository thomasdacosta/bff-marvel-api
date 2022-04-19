package br.com.thomasdacosta.handler.util;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Util {

    public enum Env {
        AWS, LOCALSTACK
    }

    private static AwsClientBuilder.EndpointConfiguration endpointConfiguration = null;
    private static AmazonS3 amazonS3 = null;

    public static void setEndpointConfiguration(AwsClientBuilder.EndpointConfiguration endpointConfiguration) {
        S3Util.endpointConfiguration = endpointConfiguration;
    }

    public static void setAmazonS3(AmazonS3 amazonS3) {
        S3Util.amazonS3 = amazonS3;
    }

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
        if (amazonS3 == null)  {
            boolean docker = "true".equals(System.getenv(Constants.ENV_DOCKER));

            if (endpointConfiguration == null) {
                if (docker)
                    endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(Constants.S3_ENDPOINT_DOCKER, Constants.AWS_REGION);
                else
                    endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(Constants.S3_ENDPOINT, Constants.AWS_REGION);
            }
            AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();
            builder.withEndpointConfiguration(endpointConfiguration);

            if (docker)
                builder.setPathStyleAccessEnabled(true);

            amazonS3 = builder.build();
        }
        return amazonS3;
    }

    public static void deleteBucket(AmazonS3 amazonS3, String bucket) {
        try {
            ObjectListing files = amazonS3.listObjects(bucket);
            for (S3ObjectSummary key : files.getObjectSummaries()) {
                try {
                    System.out.println("######" + key.getKey());
                    amazonS3.deleteObject(bucket, key.getKey());
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

}
