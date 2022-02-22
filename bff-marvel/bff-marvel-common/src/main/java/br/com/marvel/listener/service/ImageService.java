package br.com.marvel.listener.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.listener.exception.FileListenerException;
import br.com.marvel.listener.service.port.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageService {

	@Autowired
	private MarvelClient client;

	@Autowired
	private FileService fileService;

	public void saveImageFile(MarvelCharacter marvelCharacter, ThumbnailCharacter thumbnailCharacter, String size)
			throws FileListenerException {
		try {
			URI uri = new URI(
					String.format("%s/%s.%s", thumbnailCharacter.getUrl(), size, thumbnailCharacter.getExtension()));
			String file = fileService.getFileName(size, marvelCharacter.getName(),
					marvelCharacter.getId().toPlainString(), thumbnailCharacter.getExtension());

			if (fileService.isFileExists(file))
				throw new FileListenerException(String.format("Arquivo já existente: %s", file));

			Resource response = client.image(uri);
			fileService.saveFile(response.getInputStream(), file);
			log.info(String.format("Arquivo Salvo com Sucesso: %s", file));
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new FileListenerException(ex.getMessage(), ex);
		}
	}

}
