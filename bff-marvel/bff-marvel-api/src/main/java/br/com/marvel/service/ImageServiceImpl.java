package br.com.marvel.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.marvel.client.dto.Character;
import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.file.ports.FileService;
import br.com.marvel.service.ports.ImageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private MarvelClient client;

	@Autowired
	private FileService fileService;	
	
	@Async("processExecutor")
	@Override
	public void getCharacterImage(Character character, String size) {
		try {
			Resource response = client
					.image(new URI(String.format("%s/%s.jpg", character.getThumbnail().getPath(), size)));
			fileService.saveFile(response.getInputStream(),
					String.format("%s_%s_%s.%s", character.getName().toUpperCase(), character.getId(), size,
							character.getThumbnail().getExtension()));
		} catch (URISyntaxException ex) {
			log.error(ex.getMessage(), ex);
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
