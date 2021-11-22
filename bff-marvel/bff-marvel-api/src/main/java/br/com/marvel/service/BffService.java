package br.com.marvel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class BffService {

	@Autowired
	private MarvelApiClient client;

	@Autowired
	private BffConfiguration configuration;

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
