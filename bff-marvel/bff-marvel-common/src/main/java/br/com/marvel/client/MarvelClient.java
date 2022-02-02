package br.com.marvel.client;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import br.com.marvel.client.dto.CharacterDataWrapper;
import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.CreatorDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.dto.SeriesDataWrapper;
import br.com.marvel.client.dto.StoryDataWrapper;

public interface MarvelClient {

	ResponseEntity<Resource> image(URI baseUri);

	ResponseEntity<CharacterDataWrapper> characterById(String characterId);

	ResponseEntity<ComicDataWrapper> characterComics(String characterId, String format, String formatType,
			Boolean noVariants, String dateDescriptor, BigDecimal dateRange, String diamondCode, BigDecimal digitalId,
			String upc, String isbn, String ean, String issn, Boolean hasDigitalIssue, String modifiedSince,
			BigDecimal creators, BigDecimal series, BigDecimal events, BigDecimal stories, BigDecimal sharedAppearances,
			BigDecimal collaborators, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<EventDataWrapper> characterEvents(String characterId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal creators, BigDecimal series, BigDecimal comics, BigDecimal stories,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<SeriesDataWrapper> characterSeries(String characterId, String title, String titleStartsWith,
			BigDecimal startYear, String modifiedSince, BigDecimal comics, BigDecimal stories, BigDecimal events,
			BigDecimal creators, String seriesType, String contains, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<StoryDataWrapper> characterStories(String characterId, String modifiedSince, BigDecimal comics,
			BigDecimal series, BigDecimal events, BigDecimal creators, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<ComicDataWrapper> comicById(String comicId);

	ResponseEntity<CharacterDataWrapper> comicCharacters(String comicId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal series, BigDecimal events, BigDecimal stories, String orderBy,
			BigDecimal limit, BigDecimal offset);

	ResponseEntity<CreatorDataWrapper> comicCreators(String comicId, String firstName, String middleName,
			String lastName, String suffix, String nameStartsWith, String firstNameStartsWith,
			String middleNameStartsWith, String lastNameStartsWith, String modifiedSince, BigDecimal comics,
			BigDecimal series, BigDecimal stories, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<EventDataWrapper> comicEvents(String comicId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal creators, BigDecimal characters, BigDecimal series, BigDecimal stories,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<StoryDataWrapper> comicStories(String comicId, String modifiedSince, BigDecimal series,
			BigDecimal events, BigDecimal creators, BigDecimal characters, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<CreatorDataWrapper> creatorById(String creatorId);

	ResponseEntity<ComicDataWrapper> creatorComics(String creatorId, String format, String formatType,
			Boolean noVariants, String dateDescriptor, BigDecimal dateRange, String diamondCode, BigDecimal digitalId,
			String upc, String isbn, String ean, String issn, Boolean hasDigitalIssue, String modifiedSince,
			BigDecimal characters, BigDecimal series, BigDecimal events, BigDecimal stories,
			BigDecimal sharedAppearances, BigDecimal collaborators, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<EventDataWrapper> creatorEvents(String creatorId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal characters, BigDecimal series, BigDecimal comics, BigDecimal stories,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<SeriesDataWrapper> creatorSeries(String creatorId, String title, String titleStartsWith,
			BigDecimal startYear, String modifiedSince, BigDecimal comics, BigDecimal stories, BigDecimal events,
			BigDecimal characters, String seriesType, String contains, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<StoryDataWrapper> creatorStories(String creatorId, String modifiedSince, BigDecimal comics,
			BigDecimal series, BigDecimal events, BigDecimal characters, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<EventDataWrapper> eventById(String eventId);

	ResponseEntity<CharacterDataWrapper> eventCharacters(String eventId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal comics, BigDecimal series, BigDecimal stories, String orderBy,
			BigDecimal limit, BigDecimal offset);

	ResponseEntity<ComicDataWrapper> eventComics(String eventId, String format, String formatType, Boolean noVariants,
			String dateDescriptor, BigDecimal dateRange, String diamondCode, BigDecimal digitalId, String upc,
			String isbn, String ean, String issn, Boolean hasDigitalIssue, String modifiedSince, BigDecimal creators,
			BigDecimal characters, BigDecimal series, BigDecimal events, BigDecimal stories,
			BigDecimal sharedAppearances, BigDecimal collaborators, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<CreatorDataWrapper> eventCreators(String eventId, String firstName, String middleName,
			String lastName, String suffix, String nameStartsWith, String firstNameStartsWith,
			String middleNameStartsWith, String lastNameStartsWith, String modifiedSince, BigDecimal comics,
			BigDecimal series, BigDecimal stories, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<SeriesDataWrapper> eventSeries(String eventId, String title, String titleStartsWith,
			BigDecimal startYear, String modifiedSince, BigDecimal comics, BigDecimal stories, BigDecimal creators,
			BigDecimal characters, String seriesType, String contains, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<StoryDataWrapper> eventStories(String eventId, String modifiedSince, BigDecimal comics,
			BigDecimal series, BigDecimal creators, BigDecimal characters, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<InlineResponse200> listCharacters(String name, String nameStartsWith, String modifiedSince,
			BigDecimal comics, BigDecimal series, BigDecimal events, BigDecimal stories, String orderBy,
			BigDecimal limit, BigDecimal offset);

	ResponseEntity<ComicDataWrapper> listComics(String format, String formatType, Boolean noVariants,
			String dateDescriptor, BigDecimal dateRange, String diamondCode, BigDecimal digitalId, String upc,
			String isbn, String ean, String issn, Boolean hasDigitalIssue, String modifiedSince, BigDecimal creators,
			BigDecimal characters, BigDecimal series, BigDecimal events, BigDecimal stories,
			BigDecimal sharedAppearances, BigDecimal collaborators, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<CreatorDataWrapper> listCreators(String firstName, String middleName, String lastName, String suffix,
			String nameStartsWith, String firstNameStartsWith, String middleNameStartsWith, String lastNameStartsWith,
			String modifiedSince, BigDecimal comics, BigDecimal series, BigDecimal events, BigDecimal stories,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<EventDataWrapper> listEvents(String name, String nameStartsWith, String modifiedSince,
			BigDecimal creators, BigDecimal characters, BigDecimal series, BigDecimal comics, BigDecimal stories,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<SeriesDataWrapper> listSeries(String title, String titleStartsWith, BigDecimal startYear,
			String modifiedSince, BigDecimal comics, BigDecimal stories, BigDecimal events, BigDecimal creators,
			BigDecimal characters, String seriesType, String contains, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<StoryDataWrapper> listStories(String modifiedSince,
			BigDecimal comics, BigDecimal series, BigDecimal events, BigDecimal creators, BigDecimal characters,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<SeriesDataWrapper> seriesById(String seriesId);

	ResponseEntity<CharacterDataWrapper> seriesCharacters(String seriesId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal comics, BigDecimal events, BigDecimal stories, String orderBy,
			BigDecimal limit, BigDecimal offset);

	ResponseEntity<ComicDataWrapper> seriesComics(String seriesId, String format, String formatType, Boolean noVariants,
			String dateDescriptor, BigDecimal dateRange, String diamondCode, BigDecimal digitalId, String upc,
			String isbn, String ean, String issn, Boolean hasDigitalIssue, String modifiedSince, BigDecimal creators,
			BigDecimal characters, BigDecimal events, BigDecimal stories, BigDecimal sharedAppearances,
			BigDecimal collaborators, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<CreatorDataWrapper> seriesCreators(String seriesId, String firstName, String middleName,
			String lastName, String suffix, String nameStartsWith, String firstNameStartsWith,
			String middleNameStartsWith, String lastNameStartsWith, String modifiedSince, BigDecimal comics,
			BigDecimal events, BigDecimal stories, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<EventDataWrapper> seriesEvents(String seriesId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal creators, BigDecimal characters, BigDecimal comics, BigDecimal stories,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<StoryDataWrapper> seriesStories(String seriesId, String modifiedSince, BigDecimal comics,
			BigDecimal events, BigDecimal creators, BigDecimal characters, String orderBy, BigDecimal limit,
			BigDecimal offset);

	ResponseEntity<StoryDataWrapper> storyById(String storyId);

	ResponseEntity<CharacterDataWrapper> storyCharacters(String storyId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal comics, BigDecimal series, BigDecimal events, String orderBy,
			BigDecimal limit, BigDecimal offset);

	ResponseEntity<ComicDataWrapper> storyComics(String storyId, String format, String formatType, Boolean noVariants,
			String dateDescriptor, BigDecimal dateRange, String diamondCode, BigDecimal digitalId, String upc,
			String isbn, String ean, String issn, Boolean hasDigitalIssue, String modifiedSince, BigDecimal creators,
			BigDecimal characters, BigDecimal series, BigDecimal events, BigDecimal sharedAppearances,
			BigDecimal collaborators, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<CreatorDataWrapper> storyCreators(String storyId, String firstName, String middleName,
			String lastName, String suffix, String nameStartsWith, String firstNameStartsWith,
			String middleNameStartsWith, String lastNameStartsWith, String modifiedSince, BigDecimal comics,
			BigDecimal series, BigDecimal events, String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<EventDataWrapper> storyEvents(String storyId, String name, String nameStartsWith,
			String modifiedSince, BigDecimal creators, BigDecimal characters, BigDecimal series, BigDecimal comics,
			String orderBy, BigDecimal limit, BigDecimal offset);

	ResponseEntity<SeriesDataWrapper> storySeries(String storyId, BigDecimal events, String title,
			String titleStartsWith, BigDecimal startYear, String modifiedSince, BigDecimal comics, BigDecimal creators,
			BigDecimal characters, String seriesType, String contains, String orderBy, BigDecimal limit,
			BigDecimal offset);

}