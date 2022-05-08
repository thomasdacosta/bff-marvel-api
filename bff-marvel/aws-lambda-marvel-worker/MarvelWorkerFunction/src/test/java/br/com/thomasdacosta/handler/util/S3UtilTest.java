package br.com.thomasdacosta.handler.util;

import br.com.thomasdacosta.util.Constants;
import br.com.thomasdacosta.util.LocalStackUtil;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.SetEnvironmentVariable;
import org.testcontainers.containers.localstack.LocalStackContainer;

import java.util.Objects;

import static br.com.thomasdacosta.handler.util.Constants.ENV_DOCKER;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class S3UtilTest {

    @Test
    @Order(1)
    @DisplayName("1 - Criando arquivos em um Bucket S3")
    public void testCreateFile() {
        String[] listFiles = new String[4];
        listFiles[0] = "file1.txt";
        listFiles[1] = "file2.txt";
        listFiles[2] = "file3.txt";
        listFiles[3] = "file4.txt";

        S3Util.setEndpointConfiguration(LocalStackUtil.getLocalstack().getEndpointConfiguration(LocalStackContainer.Service.S3));
        AmazonS3 amazonS3 = S3Util.getS3(S3Util.Env.LOCALSTACK);

        Objects.requireNonNull(amazonS3).createBucket(Constants.BUCKET);
        amazonS3.putObject(Constants.BUCKET, listFiles[0], "file1");
        amazonS3.putObject(Constants.BUCKET, listFiles[1], "file2");
        amazonS3.putObject(Constants.BUCKET, listFiles[2], "file3");
        amazonS3.putObject(Constants.BUCKET, listFiles[3], "file4");

        ObjectListing files = amazonS3.listObjects(Constants.BUCKET);

        assertEquals(1, files.getObjectSummaries().stream()
                .filter(p -> p.getKey().equals(listFiles[0])).count());
        assertEquals(1, files.getObjectSummaries().stream()
                .filter(p -> p.getKey().equals(listFiles[1])).count());
        assertEquals(1, files.getObjectSummaries().stream()
                .filter(p -> p.getKey().equals(listFiles[2])).count());
        assertEquals(1, files.getObjectSummaries().stream()
                .filter(p -> p.getKey().equals(listFiles[3])).count());

        S3Util.setAmazonS3(null);
        assertNotNull(S3Util.getS3(S3Util.Env.AWS));
        assertNotNull(S3Util.getS3(S3Util.Env.AWS));

        S3Util.setAmazonS3(null);
        Assertions.assertNull(S3Util.getS3(null));

        S3Util.setAmazonS3(null);
        S3Util.setEndpointConfiguration(null);
        assertNotNull(S3Util.getS3(S3Util.Env.LOCALSTACK));
        assertNotNull(S3Util.getS3(S3Util.Env.LOCALSTACK));
    }

    @Test
    @Order(2)
    @SetEnvironmentVariable(key = ENV_DOCKER, value = "true")
    @DisplayName("2 - Simulando com endpoint do Docker")
    public void testImageAws() {
        S3Util.setAmazonS3(null);
        S3Util.setEndpointConfiguration(null);
        assertNotNull(new S3Util());
        assertNotNull(S3Util.getS3(S3Util.Env.LOCALSTACK));
    }

}
