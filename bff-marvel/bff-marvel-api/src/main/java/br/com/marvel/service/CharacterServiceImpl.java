package br.com.marvel.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.dto.InlineResponse200Data;
import br.com.marvel.client.dto.SeriesDataWrapper;
import br.com.marvel.client.dto.StoryDataWrapper;
import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.controller.dto.Pagination;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.controller.dto.characters.UrlCharacter;
import br.com.marvel.listener.service.port.FileService;
import br.com.marvel.service.ports.CharacterService;
import br.com.marvel.service.ports.NotificationImageService;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private MarvelClient client;

	@Autowired
	private FileService fileService;

	@Autowired
	private NotificationImageService notificationImageService;

	@Override
	public Pagination findCharacters(String name, String nameStartsWith, BigDecimal limit, BigDecimal offset) {
		InlineResponse200 listCharacters = client.listCharacters(name, nameStartsWith, null, null, null, null, null,
				null, limit, offset);

		InlineResponse200Data data = listCharacters.getData();
		Pagination pagination = new Pagination();
		pagination.setOffset(data.getOffset());
		pagination.setLimit(data.getLimit());
		pagination.setTotal(data.getTotal());
		pagination.setCount(data.getCount());

		if (!listCharacters.getData().getResults().isEmpty()) {
			List<MarvelCharacter> characters = listCharacters.getData().getResults().stream().map(c -> {
				MarvelCharacter marvelCharacter = new MarvelCharacter();

				marvelCharacter.setId(c.getId());
				marvelCharacter.setName(c.getName());
				marvelCharacter.setDescription(c.getDescription());
				marvelCharacter.setModified(c.getModified());

				ThumbnailCharacter thumbnailCharacter = new ThumbnailCharacter();
				thumbnailCharacter.setUrl(c.getThumbnail().getPath());
				thumbnailCharacter.setExtension(c.getThumbnail().getExtension());

				marvelCharacter.setThumbnail(thumbnailCharacter);

				// Enviando messagem para o SNS para gravar a imagem do personagem
				notificationImageService.sendNotificationThumbnailCharacter(marvelCharacter, thumbnailCharacter);

				List<UrlCharacter> urlCharacters = c.getUrls().stream().map(u -> {
					UrlCharacter urlCharacter = new UrlCharacter();
					urlCharacter.setType(u.getType());
					urlCharacter.setUrl(u.getUrl());
					return urlCharacter;
				}).collect(Collectors.toList());

				marvelCharacter.setUrlCharacters(urlCharacters);

				return marvelCharacter;
			}).collect(Collectors.toList());

			pagination.setData(characters);
			return pagination;
		} else {
			return null;
		}
	}

	@Override
	public Pagination findImageCharacters(String name, BigDecimal offset) {
		List<Resource> files = fileService.searchFile(fileService.patternFile(name));
		if (files.isEmpty())
			return null;

		if (offset.intValue() > (files.size() - 1))
			offset = BigDecimal.ZERO;

		Resource resource = files.get(offset.intValue());

		Pagination pagination = new Pagination();
		pagination.setOffset(offset);
		pagination.setLimit(BigDecimal.ZERO);
		pagination.setTotal(BigDecimal.valueOf(files.size()));
		pagination.setCount(BigDecimal.valueOf(files.size()));
		pagination.setData(resource);
		pagination.setFileName(resource.getFilename());

		return pagination;
	}

	@Override
	public Pagination findComicsByCharacter(String id, BigDecimal limit, BigDecimal offset) {
		ComicDataWrapper characterComics = client.characterComics(id, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, "-focDate", limit, offset);

		if (!characterComics.getData().getResults().isEmpty()) {
			// TODO - será implementado na próxima versão
		}
		return null;
	}

	@Override
	public Pagination findSeriesByCharacter(String id, BigDecimal limit, BigDecimal offset) {
		// TODO Auto-generated method stub
		SeriesDataWrapper characterSeries = client.characterSeries(id, null, null, null, null, null, null, null, null,
				null, null, null, limit, offset);

		if (!characterSeries.getData().getResults().isEmpty()) {
			// TODO - será implementado na próxima versão
		}
		return null;
	}

	@Override
	public Pagination findStoriesByCharacter(String id, BigDecimal limit, BigDecimal offset) {
		StoryDataWrapper characterStories = client.characterStories(id, null, null, null, null, null, null, limit,
				offset);

		if (!characterStories.getData().getResults().isEmpty()) {
			// TODO - será implementado na próxima versão
		}
		return null;
	}

	@Override
	public Pagination findEventsByCharacter(String id, BigDecimal limit, BigDecimal offset) {
		EventDataWrapper characterEvents = client.characterEvents(id, null, null, null, null, null, null, null, null,
				limit, offset);

		if (!characterEvents.getData().getResults().isEmpty()) {
			// TODO - será implementado na próxima versão
		}
		return null;
	}

}
