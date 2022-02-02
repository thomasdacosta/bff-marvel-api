package br.com.marvel.client;

import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.marvel.client.dto.CharacterDataWrapper;
import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.CreatorDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.dto.SeriesDataWrapper;
import br.com.marvel.client.dto.StoryDataWrapper;
import br.com.marvel.client.feign.MarvelApi;

@Component
public class MarvelClientImpl implements MarvelClient {
	
	@Autowired
	private MarvelApi marvelApi;

	@Override
	public ResponseEntity<Resource> image(URI baseUri) {
		return null;
	}

	@Override
	public ResponseEntity<CharacterDataWrapper> characterById(String characterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> characterComics(String characterId,
			@Valid String format, @Valid String formatType, @Valid Boolean noVariants, @Valid String dateDescriptor,
			@Valid BigDecimal dateRange, @Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc,
			@Valid String isbn, @Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid BigDecimal stories, @Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> characterEvents(String characterId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal creators,
			@Valid BigDecimal series, @Valid BigDecimal comics, @Valid BigDecimal stories, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SeriesDataWrapper> characterSeries(String characterId,
			@Valid String title, @Valid String titleStartsWith, @Valid BigDecimal startYear,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal stories, @Valid BigDecimal events,
			@Valid BigDecimal creators, @Valid String seriesType, @Valid String contains, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> characterStories(String characterId,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid BigDecimal creators, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> comicById(String comicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CharacterDataWrapper> comicCharacters(String comicId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal series,
			@Valid BigDecimal events, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CreatorDataWrapper> comicCreators(String comicId,
			@Valid String firstName, @Valid String middleName, @Valid String lastName, @Valid String suffix,
			@Valid String nameStartsWith, @Valid String firstNameStartsWith, @Valid String middleNameStartsWith,
			@Valid String lastNameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> comicEvents(String comicId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid BigDecimal series, @Valid BigDecimal stories, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> comicStories(String comicId,
			@Valid String modifiedSince, @Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CreatorDataWrapper> creatorById(String creatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> creatorComics(String creatorId,
			@Valid String format, @Valid String formatType, @Valid Boolean noVariants, @Valid String dateDescriptor,
			@Valid BigDecimal dateRange, @Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc,
			@Valid String isbn, @Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue,
			@Valid String modifiedSince, @Valid BigDecimal characters, @Valid BigDecimal series,
			@Valid BigDecimal events, @Valid BigDecimal stories, @Valid BigDecimal sharedAppearances,
			@Valid BigDecimal collaborators, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> creatorEvents(String creatorId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal characters,
			@Valid BigDecimal series, @Valid BigDecimal comics, @Valid BigDecimal stories, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SeriesDataWrapper> creatorSeries(String creatorId,
			@Valid String title, @Valid String titleStartsWith, @Valid BigDecimal startYear,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal stories, @Valid BigDecimal events,
			@Valid BigDecimal characters, @Valid String seriesType, @Valid String contains, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> creatorStories(String creatorId,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid BigDecimal characters, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> eventById(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CharacterDataWrapper> eventCharacters(String eventId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> eventComics(String eventId,
			@Valid String format, @Valid String formatType, @Valid Boolean noVariants, @Valid String dateDescriptor,
			@Valid BigDecimal dateRange, @Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc,
			@Valid String isbn, @Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CreatorDataWrapper> eventCreators(String eventId,
			@Valid String firstName, @Valid String middleName, @Valid String lastName, @Valid String suffix,
			@Valid String nameStartsWith, @Valid String firstNameStartsWith, @Valid String middleNameStartsWith,
			@Valid String lastNameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SeriesDataWrapper> eventSeries(String eventId,
			@Valid String title, @Valid String titleStartsWith, @Valid BigDecimal startYear,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal stories,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String seriesType, @Valid String contains,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> eventStories(String eventId,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<InlineResponse200> listCharacters(@Valid String name,
			@Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> listComics(@Valid String format,
			@Valid String formatType, @Valid Boolean noVariants, @Valid String dateDescriptor,
			@Valid BigDecimal dateRange, @Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc,
			@Valid String isbn, @Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories,
			@Valid BigDecimal sharedAppearances, @Valid BigDecimal collaborators, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CreatorDataWrapper> listCreators(String ts, String apikey, String hash,
			@Valid String firstName, @Valid String middleName, @Valid String lastName, @Valid String suffix,
			@Valid String nameStartsWith, @Valid String firstNameStartsWith, @Valid String middleNameStartsWith,
			@Valid String lastNameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal stories, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> listEvents(@Valid String name,
			@Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid BigDecimal series, @Valid BigDecimal comics, @Valid BigDecimal stories,
			@Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SeriesDataWrapper> listSeries(@Valid String title,
			@Valid String titleStartsWith, @Valid BigDecimal startYear, @Valid String modifiedSince,
			@Valid BigDecimal comics, @Valid BigDecimal stories, @Valid BigDecimal events, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid String seriesType, @Valid String contains, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> listStories(String ts, String apikey, String hash,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal series, @Valid BigDecimal events,
			@Valid BigDecimal creators, @Valid BigDecimal characters, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SeriesDataWrapper> seriesById(String seriesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CharacterDataWrapper> seriesCharacters(String seriesId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal events, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> seriesComics(String seriesId,
			@Valid String format, @Valid String formatType, @Valid Boolean noVariants, @Valid String dateDescriptor,
			@Valid BigDecimal dateRange, @Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc,
			@Valid String isbn, @Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal events, @Valid BigDecimal stories, @Valid BigDecimal sharedAppearances,
			@Valid BigDecimal collaborators, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CreatorDataWrapper> seriesCreators(String seriesId,
			@Valid String firstName, @Valid String middleName, @Valid String lastName, @Valid String suffix,
			@Valid String nameStartsWith, @Valid String firstNameStartsWith, @Valid String middleNameStartsWith,
			@Valid String lastNameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal events, @Valid BigDecimal stories, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> seriesEvents(String seriesId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid BigDecimal comics, @Valid BigDecimal stories, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> seriesStories(String seriesId,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal events, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StoryDataWrapper> storyById(String storyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CharacterDataWrapper> storyCharacters(String storyId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ComicDataWrapper> storyComics(String storyId,
			@Valid String format, @Valid String formatType, @Valid Boolean noVariants, @Valid String dateDescriptor,
			@Valid BigDecimal dateRange, @Valid String diamondCode, @Valid BigDecimal digitalId, @Valid String upc,
			@Valid String isbn, @Valid String ean, @Valid String issn, @Valid Boolean hasDigitalIssue,
			@Valid String modifiedSince, @Valid BigDecimal creators, @Valid BigDecimal characters,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid BigDecimal sharedAppearances,
			@Valid BigDecimal collaborators, @Valid String orderBy, @Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CreatorDataWrapper> storyCreators(String storyId,
			@Valid String firstName, @Valid String middleName, @Valid String lastName, @Valid String suffix,
			@Valid String nameStartsWith, @Valid String firstNameStartsWith, @Valid String middleNameStartsWith,
			@Valid String lastNameStartsWith, @Valid String modifiedSince, @Valid BigDecimal comics,
			@Valid BigDecimal series, @Valid BigDecimal events, @Valid String orderBy, @Valid BigDecimal limit,
			@Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EventDataWrapper> storyEvents(String storyId,
			@Valid String name, @Valid String nameStartsWith, @Valid String modifiedSince, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid BigDecimal series, @Valid BigDecimal comics, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SeriesDataWrapper> storySeries(String storyId,
			@Valid BigDecimal events, @Valid String title, @Valid String titleStartsWith, @Valid BigDecimal startYear,
			@Valid String modifiedSince, @Valid BigDecimal comics, @Valid BigDecimal creators,
			@Valid BigDecimal characters, @Valid String seriesType, @Valid String contains, @Valid String orderBy,
			@Valid BigDecimal limit, @Valid BigDecimal offset) {
		// TODO Auto-generated method stub
		return null;
	}

}
