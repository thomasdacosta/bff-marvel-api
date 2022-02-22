package br.com.marvel.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.listener.dto.Header;
import br.com.marvel.listener.dto.Notification;
import br.com.marvel.listener.service.ImageService;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class QueueListener {
	
	@Autowired
	private ImageService imageService;

	@SqsListener("${queue.name}")
	public void queueListener(String message) {
		ObjectMapper objectMapper = new ObjectMapper();
		String url = null;
		String character = null;

		try {
			log.info(String.format("Mensagem Recebida: %s", message));
			Notification notification = objectMapper.readValue(message, Notification.class);
			url = notification.getMessage();

			Header header = notification.getMessageAttributes().get("marvelCharacter");
			character = header.getValue();

			ThumbnailCharacter thumbnailCharacter = objectMapper.readValue(url, ThumbnailCharacter.class);
			MarvelCharacter marvelCharacter = objectMapper.readValue(character, MarvelCharacter.class);

			imageService.saveImageFile(marvelCharacter, thumbnailCharacter, "portrait_uncanny");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}


}
