package br.com.marvel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.controller.dto.MarvelCharacter;
import br.com.marvel.controller.dto.MarvelComics;
import br.com.marvel.controller.dto.MarvelEvents;
import br.com.marvel.controller.exception.NotFoundException;
import br.com.marvel.service.ports.BffService;
import br.com.marvel.service.ports.ImageService;

@Service
public class BffServiceImpl implements BffService {

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
	private MarvelClient client;

	@Autowired
	private ImageService imageService;

	@Override
	public List<MarvelCharacter> findCharacters(String name) {
		List<MarvelCharacter> marvelCharacters = new ArrayList<>();
		InlineResponse200 listCharacters = client.listCharacters(name, null, null, null, null, null,
				null, null, null, null);

		if (!listCharacters.getData().getResults().isEmpty()) {
			listCharacters.getData().getResults().forEach(c -> {
				MarvelCharacter marvelCharacter = new MarvelCharacter();

				marvelCharacter.setDescription(c.getDescription());
				marvelCharacter.setId(c.getId());
				marvelCharacter.setName(c.getName());

				marvelCharacter.setComics(findComicsByCharacter(String.valueOf(c.getId())));
				marvelCharacter.setEvents(findEventsByCharacter(String.valueOf(c.getId())));

				marvelCharacters.add(marvelCharacter);

				imageService.getCharacterImage(c, PORTRAIT_SMALL);
				imageService.getCharacterImage(c, PORTRAIT_MEDIUM);
				imageService.getCharacterImage(c, PORTRAIT_XLARGE);
				imageService.getCharacterImage(c, PORTRAIT_FANTASTIC);
				imageService.getCharacterImage(c, PORTRAIT_UNCANNY);
				imageService.getCharacterImage(c, PORTRAIT_INCREDIBLE);

				imageService.getCharacterImage(c, STANDARD_SMALL);
				imageService.getCharacterImage(c, STANDARD_MEDIUM);
				imageService.getCharacterImage(c, STANDARD_LARGE);
				imageService.getCharacterImage(c, STANDARD_XLARGE);
				imageService.getCharacterImage(c, STANDARD_FANTASTIC);
				imageService.getCharacterImage(c, STANDARD_AMAZING);

				imageService.getCharacterImage(c, LANDSCAPE_SMALL);
				imageService.getCharacterImage(c, LANDSCAPE_MEDIUM);
				imageService.getCharacterImage(c, LANDSCAPE_LARGE);
				imageService.getCharacterImage(c, LANDSCAPE_XLARGE);
				imageService.getCharacterImage(c, LANDSCAPE_AMAZING);
				imageService.getCharacterImage(c, LANDSCAPE_INCREDIBLE);
			});
		} else {
			throw new NotFoundException("Personagens não encontrados. Deve ser da concorrente!!!");
		}

		return marvelCharacters;
	}

	@Override
	public List<MarvelComics> findComicsByCharacter(String id) {
		ComicDataWrapper characterComics = client.characterComics(id, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, "-focDate", null,
				null);

		if (!characterComics.getData().getResults().isEmpty()) {
			return characterComics.getData().getResults().stream().map(m -> {
				MarvelComics marvelComics = new MarvelComics();
				marvelComics.setTitle(m.getTitle());
				marvelComics.setIssueNumber(m.getIssueNumber());
				return marvelComics;
			}).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<MarvelEvents> findEventsByCharacter(String id) {
		EventDataWrapper characterEvents = client.characterEvents(id, null, null, null, null, null,
				null, null, null, null, null);

		if (!characterEvents.getData().getResults().isEmpty()) {
			return characterEvents.getData().getResults().stream().map(m -> {
				MarvelEvents marvelEvents = new MarvelEvents();
				marvelEvents.setDescription(m.getDescription());
				marvelEvents.setTitle(m.getTitle());
				return marvelEvents;
			}).collect(Collectors.toList());
		}
		return null;
	}

}
