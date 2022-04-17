package br.com.thomasdacosta.handler;

import br.com.thomasdacosta.handler.dto.Header;
import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.Notification;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import br.com.thomasdacosta.handler.util.S3Util;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationHandler implements RequestHandler<SQSEvent, String> {

    private static final String ENV_TYPE = "ENV_TYPE";

    public String handleRequest(final SQSEvent input, final Context context) {
        ObjectMapper objectMapper = new ObjectMapper();
        String url = null;
        String character = null;
        S3Util.Env env = S3Util.Env.LOCALSTACK;
        String value = System.getenv(ENV_TYPE);

        if ("aws".equals(value))
            env = S3Util.Env.AWS;

        for (SQSEvent.SQSMessage message : input.getRecords()) {
            try {
                Notification notification = objectMapper.readValue(message.getBody(), Notification.class);
                url = notification.getMessage();

                Header header = notification.getMessageAttributes().get("marvelCharacter");
                character = header.getValue();

                ThumbnailCharacter thumbnailCharacter = objectMapper.readValue(url, ThumbnailCharacter.class);
                MarvelCharacter marvelCharacter = objectMapper.readValue(character, MarvelCharacter.class);

                System.out.println(marvelCharacter.getId() + "-" + marvelCharacter.getName());
                S3Util.getS3(env).putObject("marvelcharacter", "marvelcharacter_" + marvelCharacter.getId() + ".txt", message.getBody());
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return "Function Performed";
    }

}
