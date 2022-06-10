package br.com.marvel;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

public class BffMarvelCdkStackTest {

    @Test
    public void testStack() {
        App app = new App();
        BffMarvelCdkStack stack = new BffMarvelCdkStack(app, "BffMarvelCdkStack");

        Template template = Template.fromStack(stack);

        template.hasResourceProperties("AWS::SQS::Queue", new HashMap<String, Number>() {{
            put("VisibilityTimeout", 300);
        }});

        template.resourceCountIs("AWS::SNS::Topic", 1);
    }

}
