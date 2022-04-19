package br.com.thomasdacosta.handler;

import br.com.thomasdacosta.handler.dto.Header;
import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.Notification;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import br.com.thomasdacosta.handler.exception.FunctionMarvelWorkerException;
import br.com.thomasdacosta.handler.util.ImageUtil;
import br.com.thomasdacosta.handler.util.LoggerUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO criar no Cloudwatch uma regra quando tem uma exception
// TODO verificar com mais carinho os logs
// TODO subir com Cloudformation
// TODO INCLUIR UM DESTINO PARA O LAMBDA NA AWS
// TODO INCLUIR LAMBDA LAYERS
// TODO USAR A LIB COMMON COMO LAYER
public class ApplicationHandler implements RequestHandler<SQSEvent, String> {

    public String handleRequest(final SQSEvent input, final Context context) {
        ObjectMapper objectMapper = new ObjectMapper();
        String url;
        String character;

        try {
            LoggerUtil.setLogger(context);
            LoggerUtil.log("## Executando Function");
            LoggerUtil.log("## Total de Mensagens:" + input.getRecords().size());

            for (SQSEvent.SQSMessage message : input.getRecords()) {

                LoggerUtil.log("## Processando Mensagem...");
                Notification notification = objectMapper.readValue(message.getBody(), Notification.class);
                url = notification.getMessage();

                Header header = notification.getMessageAttributes().get("marvelCharacter");
                character = header.getValue();

                ThumbnailCharacter thumbnailCharacter = objectMapper.readValue(url, ThumbnailCharacter.class);
                MarvelCharacter marvelCharacter = objectMapper.readValue(character, MarvelCharacter.class);

                ImageUtil.saveImage(thumbnailCharacter, marvelCharacter);
            }
        } catch (Exception ex) {
            LoggerUtil.error(ex);
            throw new FunctionMarvelWorkerException(ex.getMessage(), ex);
        }

        LoggerUtil.log("## Function Executada");
        return "## Function Executada";
    }

}
