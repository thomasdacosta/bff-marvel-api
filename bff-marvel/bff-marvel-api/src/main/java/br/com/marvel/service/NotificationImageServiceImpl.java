package br.com.marvel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.notification.port.NotificationService;
import br.com.marvel.service.ports.NotificationImageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationImageServiceImpl implements NotificationImageService {
	
	private static final String NOTIFICATION_SUBJECT = "SUBJECT: THUMBNAIL CHARACTER";
	
	@Autowired
	private NotificationService notificationService;

	@Async
	@Override
	public void sendNotificationThumbnailCharacter(ThumbnailCharacter thumbnailCharacter) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			notificationService.sendNotification(NOTIFICATION_SUBJECT, mapper.writeValueAsString(thumbnailCharacter));
		} catch (JsonProcessingException ex) {
			log.error(ex.getMessage(), ex);
		}		
	}	

}
