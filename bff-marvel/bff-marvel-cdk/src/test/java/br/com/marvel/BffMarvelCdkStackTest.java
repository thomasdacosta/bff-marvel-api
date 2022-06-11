package br.com.marvel;

import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

import java.util.HashMap;

public class BffMarvelCdkStackTest {

    @Test
    public void testStack() {
        App app = new App();
        BffMarvelCdkStack stack = new BffMarvelCdkStack(app, "BffMarvelCdkStack");
        stack.create();

        Template template = Template.fromStack(stack);

//        template.resourceCountIs("AWS::SecretsManager::Secret", 4);
        template.resourceCountIs("AWS::SSM::Parameter", 11);

        template.resourceCountIs("AWS::S3::Bucket", 1);
        template.hasResourceProperties("AWS::S3::Bucket", new HashMap<String, String>() {{
            put("BucketName", "marvelcharacter");
        }});

        template.resourceCountIs("AWS::SQS::Queue", 1);
        template.hasResourceProperties("AWS::SQS::Queue", new HashMap<String, Number>() {{
            put("VisibilityTimeout", 300);
        }});

        template.resourceCountIs("AWS::SNS::Topic", 1);
        template.resourceCountIs("AWS::IAM::Role", 1);
        template.resourceCountIs("AWS::Lambda::Function", 1);
    }

}
