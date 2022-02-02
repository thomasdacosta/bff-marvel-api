package br.com.marvel.client;

import java.math.BigDecimal;
import java.net.URI;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import br.com.marvel.client.configuration.ClientConfiguration;
import br.com.marvel.client.dto.CharacterDataWrapper;
import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.CreatorDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.dto.SeriesDataWrapper;
import br.com.marvel.client.dto.StoryDataWrapper;
import br.com.marvel.client.feign.MarvelApi;
import br.com.marvel.client.ports.MarvelClient;

@Component
public class MarvelClientImpl implements MarvelClient {

	@Autowired
	private MarvelApi marvelApi;

	@Autowired
	private ClientConfiguration configuration;

	private String ts = null;
	private String apikey = null;
	private String hash = null;

	@PostConstruct
	public void postConstruct() {
		ts = configuration.getTs();
		apikey = configuration.getApiKey();
		hash = configuration.getHash();
	}

	@Override
	public Resource image(URI baseUri) {
		return marvelApi.image(baseUri).getBody();
	}

	@Override
	public CharacterDataWrapper characterById(String characterId) {
		return marvelApi.characterById(ts, apikey, hash, characterId).getBody();
	}

	@Override
	public ComicDataWrapper characterComics(String characterId, @Valid String format, @Valid String formatType,
			@Valid Boolean noVariants, @Valid String dateDescriptor, @Valid BigDecimal dateRange,
			@Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc, @Valid String isbn,
			@Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue, @Valid String modifiedSince,
			@Valid BigDecimal creators, @Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi
				.characterComics(ts, apikey, hash, characterId, format, formatType, noVariants, dateDescriptor,
						dateRange, diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince,
						creators, series, events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
				.getBody();
	}

	@Override
	public EventDataWrapper characterEvents(String characterId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal series, @Valid BigDecimal comics,
			@Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.characterEvents(ts, apikey, hash, characterId, name, nameStartsWith, modifiedSince, creators,
				series, comics, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public SeriesDataWrapper characterSeries(String characterId, @Valid String title, @Valid String titleStartsWith,
			@Valid BigDecimal startYear, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal stories, @Valid BigDecimal events, @Valid BigDecimal creators, @Valid String seriesType,
			@Valid String contains, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.characterSeries(ts, apikey, hash, characterId, title, titleStartsWith, startYear,
				modifiedSince, comics, stories, events, creators, seriesType, contains, orderBy, limit, offset)
				.getBody();
	}

	@Override
	public StoryDataWrapper characterStories(String characterId, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal creators, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.characterStories(ts, apikey, hash, characterId, modifiedSince, comics, series, events,
				creators, orderBy, limit, offset).getBody();
	}

	@Override
	public ComicDataWrapper comicById(String comicId) {
		return marvelApi.comicById(ts, apikey, apikey, comicId).getBody();
	}

	@Override
	public CharacterDataWrapper comicCharacters(String comicId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.comicCharacters(ts, apikey, hash, comicId, name, nameStartsWith, modifiedSince, series, events,
				stories, orderBy, limit, offset).getBody();
	}

	@Override
	public CreatorDataWrapper comicCreators(String comicId, @Valid String firstName, @Valid String middleName,
			@Valid String lastName, @Valid String suffix, @Valid String nameStartsWith,
			@Valid String firstNameStartsWith, @Valid String middleNameStartsWith, @Valid String lastNameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.comicCreators(ts, apikey, hash, comicId, firstName, middleName, lastName, suffix,
				nameStartsWith, firstNameStartsWith, middleNameStartsWith, lastNameStartsWith, modifiedSince, comics,
				series, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public EventDataWrapper comicEvents(String comicId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal series, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.comicEvents(ts, apikey, hash, comicId, name, nameStartsWith, modifiedSince, creators,
				characters, series, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public StoryDataWrapper comicStories(String comicId, @Valid String modifiedSince, @Valid BigDecimal series,
			@Valid BigDecimal events, @Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.comicStories(ts, apikey, hash, comicId, modifiedSince, series, events, creators, characters,
				orderBy, limit, offset).getBody();
	}

	@Override
	public CreatorDataWrapper creatorById(String creatorId) {
		return marvelApi.creatorById(ts, apikey, hash, creatorId).getBody();
	}

	@Override
	public ComicDataWrapper creatorComics(String creatorId, @Valid String format, @Valid String formatType,
			@Valid Boolean noVariants, @Valid String dateDescriptor, @Valid BigDecimal dateRange,
			@Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc, @Valid String isbn,
			@Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue, @Valid String modifiedSince,
			@Valid BigDecimal characters, @Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.creatorComics(ts, apikey, hash, creatorId, format, formatType, noVariants, dateDescriptor,
				dateRange, diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, characters,
				series, events, stories, sharedAppearances, collaborators, orderBy, limit, offset).getBody();
	}

	@Override
	public EventDataWrapper creatorEvents(String creatorId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal characters, @Valid BigDecimal series,
			@Valid BigDecimal comics, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.creatorEvents(ts, apikey, hash, creatorId, name, nameStartsWith, modifiedSince, characters,
				series, comics, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public SeriesDataWrapper creatorSeries(String creatorId, @Valid String title, @Valid String titleStartsWith,
			@Valid BigDecimal startYear, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal stories, @Valid BigDecimal events, @Valid BigDecimal characters, @Valid String seriesType,
			@Valid String contains, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.creatorSeries(ts, apikey, hash, creatorId, title, titleStartsWith, startYear, modifiedSince,
				comics, stories, events, characters, seriesType, contains, orderBy, limit, offset).getBody();
	}

	@Override
	public StoryDataWrapper creatorStories(String creatorId, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal characters, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.creatorStories(ts, apikey, hash, creatorId, modifiedSince, comics, series, events, characters,
				orderBy, limit, offset).getBody();
	}

	@Override
	public EventDataWrapper eventById(String eventId) {
		return marvelApi.eventById(ts, apikey, hash, eventId).getBody();
	}

	@Override
	public CharacterDataWrapper eventCharacters(String eventId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.eventCharacters(ts, apikey, hash, eventId, name, nameStartsWith, modifiedSince, comics, series,
				stories, orderBy, limit, offset).getBody();
	}

	@Override
	public ComicDataWrapper eventComics(String eventId, @Valid String format, @Valid String formatType,
			@Valid Boolean noVariants, @Valid String dateDescriptor, @Valid BigDecimal dateRange,
			@Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc, @Valid String isbn,
			@Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue, @Valid String modifiedSince,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid BigDecimal series,
			@Valid BigDecimal events, @Valid BigDecimal stories, @Valid BigDecimal sharedAppearances,
			@Valid BigDecimal collaborators, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi
				.eventComics(ts, apikey, hash, eventId, format, formatType, noVariants, dateDescriptor, dateRange,
						diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators,
						characters, series, events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
				.getBody();
	}

	@Override
	public CreatorDataWrapper eventCreators(String eventId, @Valid String firstName, @Valid String middleName,
			@Valid String lastName, @Valid String suffix, @Valid String nameStartsWith,
			@Valid String firstNameStartsWith, @Valid String middleNameStartsWith, @Valid String lastNameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.eventCreators(ts, apikey, hash, eventId, firstName, middleName, lastName, suffix,
				nameStartsWith, firstNameStartsWith, middleNameStartsWith, lastNameStartsWith, modifiedSince, comics,
				series, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public SeriesDataWrapper eventSeries(String eventId, @Valid String title, @Valid String titleStartsWith,
			@Valid BigDecimal startYear, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal stories, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid String seriesType, @Valid String contains, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.eventSeries(ts, apikey, hash, eventId, title, titleStartsWith, startYear, modifiedSince,
				comics, stories, creators, characters, seriesType, contains, orderBy, limit, offset).getBody();
	}

	@Override
	public StoryDataWrapper eventStories(String eventId, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.eventStories(ts, apikey, hash, eventId, modifiedSince, comics, series, creators, characters,
				orderBy, limit, offset).getBody();
	}

	@Override
	public InlineResponse200 listCharacters(@Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.listCharacters(ts, apikey, hash, name, nameStartsWith, modifiedSince, comics, series, events,
				stories, orderBy, limit, offset).getBody();
	}

	@Override
	public ComicDataWrapper listComics(@Valid String format, @Valid String formatType, @Valid Boolean noVariants,
			@Valid String dateDescriptor, @Valid BigDecimal dateRange, @Valid String diamondCode,
			@Valid BigDecimal digitalId, @Valid String upc, @Valid String isbn, @Valid String ean, @Valid String issn,
			@Valid Boolean hasDigitalIssue, @Valid String modifiedSince, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.listComics(ts, apikey, hash, format, formatType, noVariants, dateDescriptor, dateRange,
				diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators, characters,
				series, events, stories, sharedAppearances, collaborators, orderBy, limit, offset).getBody();
	}

	@Override
	public CreatorDataWrapper listCreators(@Valid String firstName, @Valid String middleName, @Valid String lastName,
			@Valid String suffix, @Valid String nameStartsWith, @Valid String firstNameStartsWith,
			@Valid String middleNameStartsWith, @Valid String lastNameStartsWith, @Valid String modifiedSince,
			@Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.listCreators(ts, apikey, hash, firstName, middleName, lastName, suffix, nameStartsWith,
				firstNameStartsWith, middleNameStartsWith, lastNameStartsWith, modifiedSince, comics, series, events,
				stories, orderBy, limit, offset).getBody();
	}

	@Override
	public EventDataWrapper listEvents(@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid BigDecimal series,
			@Valid BigDecimal comics, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.listEvents(ts, apikey, hash, name, nameStartsWith, modifiedSince, creators, characters, series,
				comics, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public SeriesDataWrapper listSeries(@Valid String title, @Valid String titleStartsWith, @Valid BigDecimal startYear,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal stories, @Valid BigDecimal events,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String seriesType, @Valid String contains,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.listSeries(ts, apikey, hash, title, titleStartsWith, startYear, modifiedSince, comics, stories,
				events, creators, characters, seriesType, contains, orderBy, limit, offset).getBody();
	}

	@Override
	public StoryDataWrapper listStories(@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series,
			@Valid BigDecimal events, @Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.listStories(ts, apikey, hash, modifiedSince, comics, series, events, creators, characters,
				orderBy, limit, offset).getBody();
	}

	@Override
	public SeriesDataWrapper seriesById(String seriesId) {
		return marvelApi.seriesById(ts, apikey, hash, seriesId).getBody();
	}

	@Override
	public CharacterDataWrapper seriesCharacters(String seriesId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.seriesCharacters(ts, apikey, hash, seriesId, name, nameStartsWith, modifiedSince, comics,
				events, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public ComicDataWrapper seriesComics(String seriesId, @Valid String format, @Valid String formatType,
			@Valid Boolean noVariants, @Valid String dateDescriptor, @Valid BigDecimal dateRange,
			@Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc, @Valid String isbn,
			@Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue, @Valid String modifiedSince,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid BigDecimal events,
			@Valid BigDecimal stories, @Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi
				.seriesComics(ts, apikey, hash, seriesId, format, formatType, noVariants, dateDescriptor, dateRange,
						diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators,
						characters, events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
				.getBody();
	}

	@Override
	public CreatorDataWrapper seriesCreators(String seriesId, @Valid String firstName, @Valid String middleName,
			@Valid String lastName, @Valid String suffix, @Valid String nameStartsWith,
			@Valid String firstNameStartsWith, @Valid String middleNameStartsWith, @Valid String lastNameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.seriesCreators(ts, apikey, hash, seriesId, firstName, middleName, lastName, suffix,
				nameStartsWith, firstNameStartsWith, middleNameStartsWith, lastNameStartsWith, modifiedSince, comics,
				events, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public EventDataWrapper seriesEvents(String seriesId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal comics, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.seriesEvents(ts, apikey, hash, seriesId, name, nameStartsWith, modifiedSince, creators,
				characters, comics, stories, orderBy, limit, offset).getBody();
	}

	@Override
	public StoryDataWrapper seriesStories(String seriesId, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal events, @Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.seriesStories(ts, apikey, hash, seriesId, modifiedSince, comics, events, creators, characters,
				orderBy, limit, offset).getBody();
	}

	@Override
	public StoryDataWrapper storyById(String storyId) {
		return marvelApi.storyById(ts, apikey, hash, storyId).getBody();
	}

	@Override
	public CharacterDataWrapper storyCharacters(String storyId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.storyCharacters(ts, apikey, hash, storyId, name, nameStartsWith, modifiedSince, comics, series,
				events, orderBy, limit, offset).getBody();
	}

	@Override
	public ComicDataWrapper storyComics(String storyId, @Valid String format, @Valid String formatType,
			@Valid Boolean noVariants, @Valid String dateDescriptor, @Valid BigDecimal dateRange,
			@Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc, @Valid String isbn,
			@Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue, @Valid String modifiedSince,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid BigDecimal series,
			@Valid BigDecimal events, @Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.storyComics(ts, apikey, hash, storyId, format, formatType, noVariants, dateDescriptor,
				dateRange, diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators,
				characters, series, events, sharedAppearances, collaborators, orderBy, limit, offset).getBody();
	}

	@Override
	public CreatorDataWrapper storyCreators(String storyId, @Valid String firstName, @Valid String middleName,
			@Valid String lastName, @Valid String suffix, @Valid String nameStartsWith,
			@Valid String firstNameStartsWith, @Valid String middleNameStartsWith, @Valid String lastNameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		return marvelApi.storyCreators(ts, apikey, hash, storyId, firstName, middleName, lastName, suffix,
				nameStartsWith, firstNameStartsWith, middleNameStartsWith, lastNameStartsWith, modifiedSince, comics,
				series, events, orderBy, limit, offset).getBody();
	}

	@Override
	public EventDataWrapper storyEvents(String storyId, @Valid String name, @Valid String nameStartsWith,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal series, @Valid BigDecimal comics, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.storyEvents(ts, apikey, hash, storyId, name, nameStartsWith, modifiedSince, creators,
				characters, series, comics, orderBy, limit, offset).getBody();
	}

	@Override
	public SeriesDataWrapper storySeries(String storyId, @Valid BigDecimal events, @Valid String title,
			@Valid String titleStartsWith, @Valid BigDecimal startYear, @Valid String modifiedSince,
			@Valid BigDecimal comics, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid String seriesType, @Valid String contains, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		return marvelApi.storySeries(ts, apikey, hash, storyId, events, title, titleStartsWith, startYear,
				modifiedSince, comics, creators, characters, seriesType, contains, orderBy, limit, offset).getBody();
	}

}
