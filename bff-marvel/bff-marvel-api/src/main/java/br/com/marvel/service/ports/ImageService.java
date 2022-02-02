package br.com.marvel.service.ports;

import br.com.marvel.client.dto.Character;

public interface ImageService {
	
	void getCharacterImage(Character character, String size);

}
