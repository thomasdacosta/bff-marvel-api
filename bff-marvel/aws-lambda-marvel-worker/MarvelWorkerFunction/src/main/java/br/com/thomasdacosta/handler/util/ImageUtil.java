package br.com.thomasdacosta.handler.util;

import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import okhttp3.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ImageUtil {

    public static void saveImage(ThumbnailCharacter thumbnailCharacter, MarvelCharacter marvelCharacter) throws URISyntaxException, IOException {
        S3Util.Env env = S3Util.Env.LOCALSTACK;
        String value = System.getenv(Constants.ENV_TYPE);

        if ("aws".equals(value))
            env = S3Util.Env.AWS;

        URI uri = new URI(
                String.format("%s/%s.%s", thumbnailCharacter.getUrl(), Constants.IMAGE_SIZE, thumbnailCharacter.getExtension()));

        String file = getFileName(Constants.IMAGE_SIZE, marvelCharacter.getName(),
                marvelCharacter.getId().toPlainString(), thumbnailCharacter.getExtension());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(HttpUrl.get(uri)).build();

        Call call = client.newCall(request);
        Response response = call.execute();
        S3Util.getS3(env).putObject("marvelcharacter", file, response.body().byteStream(), null);
    }

    private static String getFileName(String size, String... values) {
        return String.format("%s_%s_%s.%s", patternFile(values[0]), values[1], size, values[2]);
    }

    private static String patternFile(String name) {
        return name.toLowerCase().replace(" ", "_").replace("/", "_");
    }

}
