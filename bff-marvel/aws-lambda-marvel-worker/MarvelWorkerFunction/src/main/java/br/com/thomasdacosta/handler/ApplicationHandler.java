package br.com.thomasdacosta.handler;

import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.marvel.listener.dto.Header;
import br.com.marvel.listener.dto.Notification;

public class ApplicationHandler implements RequestHandler<SQSEvent, String> {

    public String handleRequest(final SQSEvent input, final Context context) {
        ObjectMapper objectMapper = new ObjectMapper();
        String url = null;
        String character = null;

        for (SQSEvent.SQSMessage message : input.getRecords()) {
            try {
                Notification notification = objectMapper.readValue(message.getBody(), Notification.class);
                url = notification.getMessage();

                Header header = notification.getMessageAttributes().get("marvelCharacter");
                character = header.getValue();

                ThumbnailCharacter thumbnailCharacter = objectMapper.readValue(url, ThumbnailCharacter.class);
                MarvelCharacter marvelCharacter = objectMapper.readValue(character, MarvelCharacter.class);

                System.out.println(marvelCharacter.getId() + "-" + marvelCharacter.getName());
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return "Function Performed";
    }

}
