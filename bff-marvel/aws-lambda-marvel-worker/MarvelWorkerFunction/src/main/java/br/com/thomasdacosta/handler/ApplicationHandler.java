package br.com.thomasdacosta.handler;

import br.com.thomasdacosta.handler.dto.Header;
import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.Notification;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import br.com.thomasdacosta.handler.util.ImageUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

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

                ImageUtil.saveImage(thumbnailCharacter, marvelCharacter);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
                // TODO colocar uma expection personalizada
                // TODO colocar no AWS CLI a criação com memoria e tempo de execução
                // TODO criar no Cloudwatch uma regra quando tem uma exception
                // TODO verificar com mais carinho os logs
                // TODO subir com Cloudformation
            }
        }
        return "Function Performed";
    }

}
