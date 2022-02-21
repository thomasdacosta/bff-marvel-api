package br.com.marvel.listener.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;

import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.listener.exception.FileListenerException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageService {

	@Value("${directory}")
	private String directory;

	@Autowired
	private MarvelClient client;

	@Autowired
	private ResourceLoader resourceLoader;

	public void saveImageFile(MarvelCharacter marvelCharacter, ThumbnailCharacter thumbnailCharacter, String size)
			throws FileListenerException {
		try {
			URI uri = new URI(
					String.format("%s/%s.%s", thumbnailCharacter.getUrl(), size, thumbnailCharacter.getExtension()));
			String file = String.format("%s_%s_%s.%s",
					marvelCharacter.getName().toLowerCase().replace(" ", "_").replace("/", "_"),
					marvelCharacter.getId(), size, thumbnailCharacter.getExtension());

			if (isFileS3Exists(file))
				throw new FileListenerException(String.format("Arquivo já existente: %s", file));

			Resource response = client.image(uri);
			saveS3File(response.getInputStream(), file);
			log.info(String.format("Arquivo Salvo com Sucesso: %s", file));
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new FileListenerException(ex.getMessage(), ex);
		}
	}

	private boolean isFileS3Exists(String file) {
		try {
			Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", directory, file));
			return resource.contentLength() > 0;
		} catch (Exception ex) {
			return false;
		}
	}

	private void saveS3File(InputStream from, String to) throws FileListenerException {
		Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", directory, to));
		WritableResource writableResource = (WritableResource) resource;

		try (OutputStream outputStream = writableResource.getOutputStream()) {
			from.transferTo(outputStream);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new FileListenerException(ex.getMessage(), ex);
		}
	}

}
