package br.com.marvel.notification;

import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.marvel.notification.port.NotificationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocalNotificationService implements NotificationService {

	@Override
	public void sendNotification(String subject, Object message, Map<String, Object> headers) {
		log.info(String.format("Enviando mensagem com LocalNotificationService: %s, %s", subject, message));
	}

}
