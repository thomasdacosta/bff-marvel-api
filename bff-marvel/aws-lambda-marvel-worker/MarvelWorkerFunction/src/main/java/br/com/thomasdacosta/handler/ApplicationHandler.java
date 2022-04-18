package br.com.thomasdacosta.handler;

import br.com.thomasdacosta.handler.dto.Header;
import br.com.thomasdacosta.handler.dto.MarvelCharacter;
import br.com.thomasdacosta.handler.dto.Notification;
import br.com.thomasdacosta.handler.dto.ThumbnailCharacter;
import br.com.thomasdacosta.handler.exception.FunctionMarvelWorkerException;
import br.com.thomasdacosta.handler.util.ImageUtil;
import br.com.thomasdacosta.handler.util.LoggerUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO colocar no AWS CLI a criação com memoria e tempo de execução
// TODO criar no Cloudwatch uma regra quando tem uma exception
// TODO verificar com mais carinho os logs
// TODO subir com Cloudformation
public class ApplicationHandler implements RequestHandler<SQSEvent, String> {

    public String handleRequest(final SQSEvent input, final Context context) {
        ObjectMapper objectMapper = new ObjectMapper();
        String url;
        String character;

        LoggerUtil.setLogger(context);
        LoggerUtil.log("## Executando Function");
        LoggerUtil.log("## Total de Mensagens:" + input.getRecords().size());

//        System.out.println("## Executando Function");
//        System.out.println("## Total de Mensagens:" + input.getRecords().size());

        for (SQSEvent.SQSMessage message : input.getRecords()) {
            try {
//                System.out.println("## Processando Mensagem...");
                LoggerUtil.log("## Processando Mensagem...");
                Notification notification = objectMapper.readValue(message.getBody(), Notification.class);
                url = notification.getMessage();

                Header header = notification.getMessageAttributes().get("marvelCharacter");
                character = header.getValue();

                ThumbnailCharacter thumbnailCharacter = objectMapper.readValue(url, ThumbnailCharacter.class);
                MarvelCharacter marvelCharacter = objectMapper.readValue(character, MarvelCharacter.class);

                ImageUtil.saveImage(thumbnailCharacter, marvelCharacter);
            } catch (Exception ex) {
                LoggerUtil.error(ex);
                throw new FunctionMarvelWorkerException(ex.getMessage(), ex);
            }
        }

//        System.out.println("## Function Executada");
        LoggerUtil.log("## Function Executada");
        return "## Function Executada";
    }

}
