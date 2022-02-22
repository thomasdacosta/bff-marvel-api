package br.com.marvel.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sqs.AmazonSQSAsync;

import br.com.marvel.condition.AwsCondition;
import br.com.marvel.condition.LocalCondition;
import br.com.marvel.messaging.LocalMessageService;
import br.com.marvel.messaging.SqsMessageService;
import br.com.marvel.messaging.port.MessageService;
import br.com.marvel.notification.LocalNotificationService;
import br.com.marvel.notification.SnsNotificationService;
import br.com.marvel.notification.port.NotificationService;

@Configuration
public class GeneralConfiguration {

	@Autowired
	private AmazonSQSAsync amazonSQSAsync;

	@Autowired
	private AmazonSNS amazonSns;

	@Bean
	@Primary
	@Conditional(AwsCondition.class)
	public MessageService getMessageService() {
		return new SqsMessageService(amazonSQSAsync);
	}

	@Bean
	@Primary
	@Conditional(AwsCondition.class)
	public NotificationService getNotificationService() {
		return new SnsNotificationService(amazonSns);
	}

	@Bean
	@Primary
	@Conditional(LocalCondition.class)
	public MessageService getLocalMessageService() {
		return new LocalMessageService();
	}

	@Bean
	@Primary
	@Conditional(LocalCondition.class)
	public NotificationService getLocalNotificationService() {
		return new LocalNotificationService();
	}

}
