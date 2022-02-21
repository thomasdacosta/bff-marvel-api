package br.com.marvel.notification;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;

import br.com.marvel.notification.port.NotificationService;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;

@Service
public class SnsNotificationService implements NotificationService {

	@Value("${notification.name}")
	private String notificationName;

	private final NotificationMessagingTemplate notificationMessagingTemplate;

	@Autowired
	public SnsNotificationService(AmazonSNS amazonSns) {
		this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
	}

	@Override
	public void sendNotification(String subject, Object message, Map<String, Object> headers) {
		this.notificationMessagingTemplate.convertAndSend(notificationName, message, headers);
	}

}
