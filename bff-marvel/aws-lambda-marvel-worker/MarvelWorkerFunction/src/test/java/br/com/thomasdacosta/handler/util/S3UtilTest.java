package br.com.thomasdacosta.handler.util;

import com.amazonaws.services.s3.model.ObjectListing;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class S3UtilTest {

    @Test
    public void testCreateFile() {
        String listFiles[] = new String[4];
        listFiles[0] = "file1.txt";
        listFiles[1] = "file2.txt";
        listFiles[2] = "file3.txt";
        listFiles[3] = "file4.txt";

        S3Util.getS3(S3Util.Env.LOCALSTACK).putObject("marvelcharacter", listFiles[0], "file1");
        S3Util.getS3(S3Util.Env.LOCALSTACK).putObject("marvelcharacter", listFiles[1], "file2");
        S3Util.getS3(S3Util.Env.LOCALSTACK).putObject("marvelcharacter", listFiles[2], "file3");
        S3Util.getS3(S3Util.Env.LOCALSTACK).putObject("marvelcharacter", listFiles[3], "file4");

        ObjectListing files = S3Util.getS3(S3Util.Env.LOCALSTACK).listObjects("marvelcharacter");

        assertEquals(4, files.getObjectSummaries().size());
    }

}
