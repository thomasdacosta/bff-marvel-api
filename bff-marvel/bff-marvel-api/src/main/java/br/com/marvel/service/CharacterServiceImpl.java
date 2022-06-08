package br.com.marvel.service;

import br.com.marvel.client.dto.*;
import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.controller.dto.Pagination;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.dto.characters.ThumbnailCharacter;
import br.com.marvel.controller.dto.characters.UrlCharacter;
import br.com.marvel.controller.exception.MethodNotImplementedException;
import br.com.marvel.listener.service.port.FileService;
import br.com.marvel.service.ports.CharacterService;
import br.com.marvel.service.ports.NotificationImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private MarvelClient client;

    @Autowired
    private FileService fileService;

    @Autowired
    private NotificationImageService notificationImageService;

    @Override
    public MarvelCharacter saveCharacters(MarvelCharacter marvelCharacter) {
        return new MarvelCharacter();
    }

    @Override
    public Pagination findCharacters(String name, String nameStartsWith, BigDecimal limit, BigDecimal offset) {
        InlineResponse200 listCharacters = client.listCharacters(name, nameStartsWith, null, null, null, null, null,
                null, limit, offset);

//        InlineResponse200Data data = listCharacters.getData();
//        Pagination pagination = new Pagination();
//        pagination.setOffset(data.getOffset());
//        pagination.setLimit(data.getLimit());
//        pagination.setTotal(data.getTotal());
//        pagination.setCount(data.getCount());
		Pagination pagination = listCharacters.getData();

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
                null, null, null, null, null, null, null, null, null, null, null, "-focDate", null, null);

        Pagination pagination = characterComics.getData();

        if (!characterComics.getData().getResults().isEmpty()) {
            // TODO - será implementado na próxima versão
        }

        return pagination;
    }

    @Override
    public Pagination findSeriesByCharacter(String id, BigDecimal limit, BigDecimal offset) {
        // TODO Auto-generated method stub
        SeriesDataWrapper characterSeries = client.characterSeries(id, null, null, null, null, null, null, null, null,
                null, null, null, null, null);

        Pagination pagination = characterSeries.getData();

        if (!characterSeries.getData().getResults().isEmpty()) {
            // TODO - será implementado na próxima versão
        }

        return pagination;
    }

    @Override
    public Pagination findStoriesByCharacter(String id, BigDecimal limit, BigDecimal offset) {
        StoryDataWrapper characterStories = client.characterStories(id, null, null, null, null, null, null, null,
                null);

        Pagination pagination = characterStories.getData();

        if (!characterStories.getData().getResults().isEmpty()) {
            // TODO - será implementado na próxima versão
        }

        return pagination;
    }

    @Override
    public Pagination findEventsByCharacter(String id, BigDecimal limit, BigDecimal offset) {
        EventDataWrapper characterEvents = client.characterEvents(id, null, null, null, null, null, null, null, null,
                null, null);

        Pagination pagination = characterEvents.getData();

        if (!characterEvents.getData().getResults().isEmpty()) {
            // TODO - será implementado na próxima versão
        }

        return pagination;
    }

}
