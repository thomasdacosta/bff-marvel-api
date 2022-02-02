package br.com.marvel.client.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class Event {
	@JsonProperty("id")
	private BigDecimal id = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("resourceURI")
	private String resourceURI = null;

	@JsonProperty("urls")
	@Valid
	private List<Url> urls = null;

	@JsonProperty("modified")
	private String modified = null;

	@JsonProperty("start")
	private String start = null;

	@JsonProperty("end")
	private String end = null;

	@JsonProperty("thumbnail")
	private Image thumbnail = null;

	@JsonProperty("comics")
	private ComicList comics = null;

	@JsonProperty("stories")
	private StoryList stories = null;

	@JsonProperty("series")
	private SeriesList series = null;

	@JsonProperty("characters")
	private CharacterList characters = null;

	@JsonProperty("creators")
	private CreatorList creators = null;

	@JsonProperty("next")
	private EventSummary next = null;

	@JsonProperty("previous")
	private EventSummary previous = null;

	public Event id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique ID of the event resource.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The unique ID of the event resource.")

	@Valid
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Event title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * The title of the event.
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "The title of the event.")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Event description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A description of the event.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A description of the event.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Event resourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
		return this;
	}

	/**
	 * The canonical URL identifier for this resource.
	 * 
	 * @return resourceURI
	 **/
	@ApiModelProperty(value = "The canonical URL identifier for this resource.")

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public Event urls(List<Url> urls) {
		this.urls = urls;
		return this;
	}

	public Event addUrlsItem(Url urlsItem) {
		if (this.urls == null) {
			this.urls = new ArrayList<Url>();
		}
		this.urls.add(urlsItem);
		return this;
	}

	/**
	 * A set of public web site URLs for the event.
	 * 
	 * @return urls
	 **/
	@ApiModelProperty(value = "A set of public web site URLs for the event.")
	@Valid
	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Event modified(String modified) {
		this.modified = modified;
		return this;
	}

	/**
	 * The date the resource was most recently modified.
	 * 
	 * @return modified
	 **/
	@ApiModelProperty(value = "The date the resource was most recently modified.")

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public Event start(String start) {
		this.start = start;
		return this;
	}

	/**
	 * The date of publication of the first issue in this event.
	 * 
	 * @return start
	 **/
	@ApiModelProperty(value = "The date of publication of the first issue in this event.")

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public Event end(String end) {
		this.end = end;
		return this;
	}

	/**
	 * The date of publication of the last issue in this event.
	 * 
	 * @return end
	 **/
	@ApiModelProperty(value = "The date of publication of the last issue in this event.")

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Event thumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	/**
	 * Get thumbnail
	 * 
	 * @return thumbnail
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Event comics(ComicList comics) {
		this.comics = comics;
		return this;
	}

	/**
	 * Get comics
	 * 
	 * @return comics
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ComicList getComics() {
		return comics;
	}

	public void setComics(ComicList comics) {
		this.comics = comics;
	}

	public Event stories(StoryList stories) {
		this.stories = stories;
		return this;
	}

	/**
	 * Get stories
	 * 
	 * @return stories
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public StoryList getStories() {
		return stories;
	}

	public void setStories(StoryList stories) {
		this.stories = stories;
	}

	public Event series(SeriesList series) {
		this.series = series;
		return this;
	}

	/**
	 * Get series
	 * 
	 * @return series
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public SeriesList getSeries() {
		return series;
	}

	public void setSeries(SeriesList series) {
		this.series = series;
	}

	public Event characters(CharacterList characters) {
		this.characters = characters;
		return this;
	}

	/**
	 * Get characters
	 * 
	 * @return characters
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public CharacterList getCharacters() {
		return characters;
	}

	public void setCharacters(CharacterList characters) {
		this.characters = characters;
	}

	public Event creators(CreatorList creators) {
		this.creators = creators;
		return this;
	}

	/**
	 * Get creators
	 * 
	 * @return creators
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public CreatorList getCreators() {
		return creators;
	}

	public void setCreators(CreatorList creators) {
		this.creators = creators;
	}

	public Event next(EventSummary next) {
		this.next = next;
		return this;
	}

	/**
	 * Get next
	 * 
	 * @return next
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public EventSummary getNext() {
		return next;
	}

	public void setNext(EventSummary next) {
		this.next = next;
	}

	public Event previous(EventSummary previous) {
		this.previous = previous;
		return this;
	}

	/**
	 * Get previous
	 * 
	 * @return previous
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public EventSummary getPrevious() {
		return previous;
	}

	public void setPrevious(EventSummary previous) {
		this.previous = previous;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Event event = (Event) o;
		return Objects.equals(this.id, event.id) && Objects.equals(this.title, event.title)
				&& Objects.equals(this.description, event.description)
				&& Objects.equals(this.resourceURI, event.resourceURI) && Objects.equals(this.urls, event.urls)
				&& Objects.equals(this.modified, event.modified) && Objects.equals(this.start, event.start)
				&& Objects.equals(this.end, event.end) && Objects.equals(this.thumbnail, event.thumbnail)
				&& Objects.equals(this.comics, event.comics) && Objects.equals(this.stories, event.stories)
				&& Objects.equals(this.series, event.series) && Objects.equals(this.characters, event.characters)
				&& Objects.equals(this.creators, event.creators) && Objects.equals(this.next, event.next)
				&& Objects.equals(this.previous, event.previous);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, description, resourceURI, urls, modified, start, end, thumbnail, comics, stories,
				series, characters, creators, next, previous);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Event {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
		sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
		sb.append("    end: ").append(toIndentedString(end)).append("\n");
		sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
		sb.append("    comics: ").append(toIndentedString(comics)).append("\n");
		sb.append("    stories: ").append(toIndentedString(stories)).append("\n");
		sb.append("    series: ").append(toIndentedString(series)).append("\n");
		sb.append("    characters: ").append(toIndentedString(characters)).append("\n");
		sb.append("    creators: ").append(toIndentedString(creators)).append("\n");
		sb.append("    next: ").append(toIndentedString(next)).append("\n");
		sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
