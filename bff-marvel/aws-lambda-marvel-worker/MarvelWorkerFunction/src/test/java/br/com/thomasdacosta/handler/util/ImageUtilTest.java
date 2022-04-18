package br.com.thomasdacosta.handler.util;

import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import br.com.thomasdacosta.util.Constants;
import br.com.thomasdacosta.util.LocalStackUtil;
import br.com.thomasdacosta.util.WireMockUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.localstack.LocalStackContainer;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest(httpPort = 8082)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImageUtilTest {

    @Test
    @Order(1)
    @DisplayName("1 - Criando as imagens em um Bucket S3")
    public void testCreateImage() throws URISyntaxException, IOException {
        WireMockUtils.serverImage();

        S3Util.setEndpointConfiguration(LocalStackUtil.getLocalstack().getEndpointConfiguration(LocalStackContainer.Service.S3));
        AmazonS3 amazonS3 = S3Util.getS3(S3Util.Env.LOCALSTACK);

        S3Util.deleteBucket(amazonS3, Constants.BUCKET);
        Objects.requireNonNull(amazonS3).createBucket(Constants.BUCKET);

        ThumbnailCharacter thumbnailCharacter = new ThumbnailCharacter();
        thumbnailCharacter.setUrl("http://localhost:8082/imageMarvel");
        thumbnailCharacter.setExtension("jpg");

        MarvelCharacter marvelCharacter = new MarvelCharacter();
        marvelCharacter.setId(new BigDecimal(1011355));
        marvelCharacter.setName("Captain Midlands");

        ImageUtil.saveImage(thumbnailCharacter, marvelCharacter);
        ObjectListing files = amazonS3.listObjects(Constants.BUCKET);
        assertEquals(1, files.getObjectSummaries().size());
    }

}
