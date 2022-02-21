package br.com.marvel.service.ports;

import br.com.marvel.controller.dto.characters.ThumbnailCharacter;

public interface NotificationImageService {
	
	void sendNotificationThumbnailCharacter(ThumbnailCharacter thumbnailCharacter);

}
