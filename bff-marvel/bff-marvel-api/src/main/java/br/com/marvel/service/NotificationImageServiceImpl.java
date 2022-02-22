package br.com.marvel.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.notification.port.NotificationService;
import br.com.marvel.service.ports.NotificationImageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationImageServiceImpl implements NotificationImageService {

	@Autowired
	private NotificationService notificationService;

	@Async
	@Override
	public void sendNotificationThumbnailCharacter(MarvelCharacter marvelCharacter,
			ThumbnailCharacter thumbnailCharacter) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> headers = new HashMap<>();
			headers.put("marvelCharacter", mapper.writeValueAsString(marvelCharacter));
			notificationService.sendNotification("SUBJECT: THUMBNAIL CHARACTER",
					mapper.writeValueAsString(thumbnailCharacter), headers);
		} catch (JsonProcessingException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
