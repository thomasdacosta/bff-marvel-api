package br.com.thomasdacosta.handler;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ApplicationHandlerTest {

    @Test
    public void testLambda() {
        ApplicationHandler applicationHandler = new ApplicationHandler();
        applicationHandler.handleRequest(new SQSEvent(), null);
    }

}
