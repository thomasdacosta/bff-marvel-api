package br.com.marvel.service;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.marvel.client.MarvelApiClient;
import br.com.marvel.configuration.BffConfiguration;
import br.com.marvel.dto.MarvelCharacter;
import br.com.marvel.dto.MarvelComics;
import br.com.marvel.dto.MarvelEvents;
import br.com.marvel.exception.NotFoundException;
import br.com.marvel.model.ComicDataWrapper;
import br.com.marvel.model.EventDataWrapper;
import br.com.marvel.model.InlineResponse200;
import br.com.marvel.utils.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BffService {

	@Autowired
	private MarvelApiClient client;

	@Autowired
	private BffConfiguration configuration;

	@Autowired
	private FileService fileService;

	private String saveTemporaryFile(String url, String extension) {
		String path = null;
		try {
			String fileName = String.format("character_%s.%s", UUID.randomUUID(), extension);

			ResponseEntity<Resource> response = client.image(new URI(url));
			InputStream inputStream = response.getBody().getInputStream();

			Path tempDir = Files.createTempDirectory("characters");
			File file = new File(
					String.format("%s%s%s", tempDir.toAbsolutePath().toString(), File.separator, fileName));
			Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

			path = file.toString();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return path;
	}

	public List<MarvelCharacter> findCharacters(String name) {
		List<MarvelCharacter> marvelCharacters = new ArrayList<>();
		ResponseEntity<InlineResponse200> listCharacters = client.listCharacters(configuration.getTs(),
				configuration.getApiKey(), configuration.getHash(), name, null, null, null, null, null, null, null,
				null, null);

		if (!listCharacters.getBody().getData().getResults().isEmpty()) {
			listCharacters.getBody().getData().getResults().forEach(c -> {
				MarvelCharacter marvelCharacter = new MarvelCharacter();

				marvelCharacter.setDescription(c.getDescription());
				marvelCharacter.setId(c.getId());
				marvelCharacter.setName(c.getName());

				marvelCharacter.setComics(findComicsByCharacter(String.valueOf(c.getId())));
				marvelCharacter.setEvents(findEventsByCharacter(String.valueOf(c.getId())));

				marvelCharacters.add(marvelCharacter);

				String tempFile = saveTemporaryFile(
						String.format("%s/%s", c.getThumbnail().getPath(), "portrait_xlarge.jpg"),
						c.getThumbnail().getExtension());

				fileService.saveFile(tempFile, String.format("%s-%s.%s", c.getName().toUpperCase(), c.getId(),
						c.getThumbnail().getExtension()));
			});
		} else {
			throw new NotFoundException("Personagens não encontrados. Deve ser da concorrente!!!");
		}

		return marvelCharacters;
	}

	public List<MarvelComics> findComicsByCharacter(String id) {
		ResponseEntity<ComicDataWrapper> characterComics = client.characterComics(configuration.getTs(),
				configuration.getApiKey(), configuration.getHash(), id, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, "-focDate", null, null);

		if (!characterComics.getBody().getData().getResults().isEmpty()) {
			return characterComics.getBody().getData().getResults().stream().map(m -> {
				MarvelComics marvelComics = new MarvelComics();
				marvelComics.setTitle(m.getTitle());
				marvelComics.setIssueNumber(m.getIssueNumber());
				return marvelComics;
			}).collect(Collectors.toList());
		}
		return null;
	}

	public List<MarvelEvents> findEventsByCharacter(String id) {
		ResponseEntity<EventDataWrapper> characterEvents = client.characterEvents(configuration.getTs(),
				configuration.getApiKey(), configuration.getHash(), id, null, null, null, null, null, null, null, null,
				null, null);

		if (!characterEvents.getBody().getData().getResults().isEmpty()) {
			return characterEvents.getBody().getData().getResults().stream().map(m -> {
				MarvelEvents marvelEvents = new MarvelEvents();
				marvelEvents.setDescription(m.getDescription());
				marvelEvents.setTitle(m.getTitle());
				return marvelEvents;
			}).collect(Collectors.toList());
		}
		return null;
	}

}
