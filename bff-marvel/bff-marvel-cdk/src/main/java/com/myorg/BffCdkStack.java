package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Duration;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.Queue;

public class BffCdkStack extends Stack {
    public BffCdkStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public BffCdkStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        final Queue queue = Queue.Builder.create(this, "BffCdkQueue")
                .visibilityTimeout(Duration.seconds(300))
                .build();

        final Topic topic = Topic.Builder.create(this, "BffCdkTopic")
            .displayName("My First Topic Yeah")
            .build();

        topic.addSubscription(new SqsSubscription(queue));
    }
}
