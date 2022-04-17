package br.com.thomasdacosta.handler.util;

import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import okhttp3.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ImageUtil {

    private static final String IMAGE_SIZE = "portrait_uncanny";

    public static void saveImage(ThumbnailCharacter thumbnailCharacter, MarvelCharacter marvelCharacter) throws URISyntaxException, IOException {
        URI uri = new URI(
                String.format("%s/%s.%s", thumbnailCharacter.getUrl(), IMAGE_SIZE, thumbnailCharacter.getExtension()));

        String file = getFileName(IMAGE_SIZE, marvelCharacter.getName(),
                marvelCharacter.getId().toPlainString(), thumbnailCharacter.getExtension());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(HttpUrl.get(uri)).build();

        Call call = client.newCall(request);
        Response response = call.execute();
        S3Util.getS3(S3Util.Env.LOCALSTACK).putObject("marvelcharacter", file, response.body().byteStream(), null);
    }

    private static String getFileName(String size, String... values) {
        return String.format("%s_%s_%s.%s", patternFile(values[0]), values[1], size, values[2]);
    }

    private static String patternFile(String name) {
        return name.toLowerCase().replace(" ", "_").replace("/", "_");
    }

}
