package br.com.marvel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.messaging.port.MessageService;
import br.com.marvel.service.ports.MessageImageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageImageServiceImpl implements MessageImageService {

	@Autowired
	private MessageService messageService;

	@Async
	@Override
	public void sendMessageThumbnailCharacter(ThumbnailCharacter thumbnailCharacter) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			messageService.sendMessage(mapper.writeValueAsString(thumbnailCharacter));
		} catch (JsonProcessingException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
