package br.com.thomasdacosta.handler;

import br.com.thomasdacosta.handler.exception.FunctionMarvelWorkerException;
import br.com.thomasdacosta.handler.util.S3Util;
import br.com.thomasdacosta.util.Constants;
import br.com.thomasdacosta.util.LocalStackUtil;
import br.com.thomasdacosta.util.WireMockUtils;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.localstack.LocalStackContainer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WireMockTest(httpPort = 8081)
public class ApplicationHandlerTest {

    @Test
    @Order(1)
    @DisplayName("1 - Executando o Lambda")
    public void testLambdaOk() throws URISyntaxException, IOException {
        WireMockUtils.serverImage();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String file = new String(Files.readAllBytes(Paths.get(
                Objects.requireNonNull(classloader.getResource("event-sqs.json")).toURI())));

        S3Util.setEndpointConfiguration(LocalStackUtil.getLocalstack().getEndpointConfiguration(LocalStackContainer.Service.S3));

        AmazonS3 amazonS3 = S3Util.getS3(S3Util.Env.LOCALSTACK);
        Objects.requireNonNull(amazonS3).createBucket(Constants.BUCKET);

        SQSEvent sqsEvent = new SQSEvent();
        SQSEvent.SQSMessage message = new SQSEvent.SQSMessage();
        message.setBody(file);

        List<SQSEvent.SQSMessage> records = new ArrayList<>();
        records.add(message);
        sqsEvent.setRecords(records);

        ApplicationHandler applicationHandler = new ApplicationHandler();
        applicationHandler.handleRequest(sqsEvent, null);

        ObjectListing files = amazonS3.listObjects(Constants.BUCKET);
        assertEquals(1, files.getObjectSummaries().stream()
                .filter(p -> p.getKey().equals("captain_midlands_1011355_portrait_uncanny.jpg")).count());
    }

    @Test
    @Order(2)
    @DisplayName("2 - Executando o Lambda com erro")
    public void testLambdaError() {
        SQSEvent sqsEvent = new SQSEvent();
        SQSEvent.SQSMessage message = new SQSEvent.SQSMessage();
        message.setBody(null);

        List<SQSEvent.SQSMessage> records = new ArrayList<>();
        records.add(message);
        sqsEvent.setRecords(records);

        ApplicationHandler applicationHandler = new ApplicationHandler();

        assertThrows(FunctionMarvelWorkerException.class,
                () -> applicationHandler.handleRequest(sqsEvent, null));
    }
}
