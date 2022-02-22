package br.com.marvel.notification.port;

import java.util.Map;

public interface NotificationService {
	
	public void sendNotification(String subject, Object message, Map<String, Object> headers);

}
