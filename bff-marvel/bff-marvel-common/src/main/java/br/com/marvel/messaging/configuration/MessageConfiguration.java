package br.com.marvel.messaging.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.services.sqs.AmazonSQSAsync;

import br.com.marvel.messaging.LocalMessageService;
import br.com.marvel.messaging.SqsMessageService;
import br.com.marvel.messaging.condition.LocalMessageServiceCondition;
import br.com.marvel.messaging.condition.SqsMessageCondition;
import br.com.marvel.messaging.port.MessageService;

@Configuration
public class MessageConfiguration {
	
	@Autowired
	private AmazonSQSAsync amazonSQSAsync;
	
	@Bean
	@Primary
	@Conditional(SqsMessageCondition.class)
	public MessageService getMessageService() {
		return new SqsMessageService(amazonSQSAsync);
	}
	
	@Bean
	@Primary
	@Conditional(LocalMessageServiceCondition.class)
	public MessageService getLocalMessageService() {
		return new LocalMessageService();
	}

}
