package br.com.marvel.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQSAsync;

import br.com.marvel.messaging.port.MessageService;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;

@Service
public class SqsMessageService implements MessageService {

	@Value("${queue.name}")
	private String queueName;

	private final QueueMessagingTemplate queueMessagingTemplate;

	@Autowired
	public SqsMessageService(AmazonSQSAsync amazonSQSAsync) {
		this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
	}

	@Override
	public void sendMessage(String message) {
		this.queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(message).build());
	}

}
