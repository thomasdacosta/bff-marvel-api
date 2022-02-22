package br.com.marvel.service.ports;

import br.com.marvel.controller.dto.characters.ThumbnailCharacter;

public interface MessageImageService {
	
	void sendMessageThumbnailCharacter(ThumbnailCharacter thumbnailCharacter);

}
