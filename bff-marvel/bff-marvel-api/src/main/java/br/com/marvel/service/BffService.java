package br.com.marvel.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.marvel.client.MarvelApiClient;
import br.com.marvel.configuration.BffConfiguration;
import br.com.marvel.dto.MarvelCharacter;
import br.com.marvel.dto.MarvelComics;
import br.com.marvel.dto.MarvelEvents;
import br.com.marvel.exception.NotFoundException;
import br.com.marvel.model.Character;
import br.com.marvel.model.ComicDataWrapper;
import br.com.marvel.model.EventDataWrapper;
import br.com.marvel.model.InlineResponse200;
import br.com.marvel.utils.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BffService {
	
	private static final String PORTRAIT_SMALL = "portrait_small";
	private static final String PORTRAIT_MEDIUM = "portrait_medium";
	private static final String PORTRAIT_XLARGE = "portrait_xlarge";
	private static final String PORTRAIT_FANTASTIC = "portrait_fantastic";
	private static final String PORTRAIT_UNCANNY = "portrait_uncanny";
	private static final String PORTRAIT_INCREDIBLE = "portrait_incredible";

	private static final String STANDARD_SMALL = "standard_small";
	private static final String STANDARD_MEDIUM = "standard_medium";
	private static final String STANDARD_LARGE = "standard_large";
	private static final String STANDARD_XLARGE = "standard_xlarge";
	private static final String STANDARD_FANTASTIC = "standard_fantastic";
	private static final String STANDARD_AMAZING = "standard_amazing";

	private static final String LANDSCAPE_SMALL = "landscape_small";
	private static final String LANDSCAPE_MEDIUM = "landscape_medium";
	private static final String LANDSCAPE_LARGE = "landscape_large";
	private static final String LANDSCAPE_XLARGE = "landscape_xlarge";
	private static final String LANDSCAPE_AMAZING = "landscape_amazing";
	private static final String LANDSCAPE_INCREDIBLE = "landscape_incredible";	

	@Autowired
	private MarvelApiClient client;

	@Autowired
	private BffConfiguration configuration;

	@Autowired
	private FileService fileService;

	@Async
	private void getCharacterImage(Character character, String size) {
		try {
			ResponseEntity<Resource> response = client
					.image(new URI(String.format("%s/%s.jpg", character.getThumbnail().getPath(), size)));
			fileService.saveFile(response.getBody().getInputStream(),
					String.format("%s_%s_%s.%s", character.getName().toUpperCase(), character.getId(), size,
							character.getThumbnail().getExtension()));
		} catch (URISyntaxException ex) {
			log.error(ex.getMessage(), ex);
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
		}
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
				
				log.info("Obtendo imagens...");

				getCharacterImage(c, PORTRAIT_SMALL);
				getCharacterImage(c, PORTRAIT_MEDIUM);
				getCharacterImage(c, PORTRAIT_XLARGE);
				getCharacterImage(c, PORTRAIT_FANTASTIC);
				getCharacterImage(c, PORTRAIT_UNCANNY);
				getCharacterImage(c, PORTRAIT_INCREDIBLE);

				getCharacterImage(c, STANDARD_SMALL);
				getCharacterImage(c, STANDARD_MEDIUM);
				getCharacterImage(c, STANDARD_LARGE);
				getCharacterImage(c, STANDARD_XLARGE);
				getCharacterImage(c, STANDARD_FANTASTIC);
				getCharacterImage(c, STANDARD_AMAZING);

				getCharacterImage(c, LANDSCAPE_SMALL);
				getCharacterImage(c, LANDSCAPE_MEDIUM);
				getCharacterImage(c, LANDSCAPE_LARGE);
				getCharacterImage(c, LANDSCAPE_XLARGE);
				getCharacterImage(c, LANDSCAPE_AMAZING);
				getCharacterImage(c, LANDSCAPE_INCREDIBLE);
				
				log.info("Imagens gravadas !!!");
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
