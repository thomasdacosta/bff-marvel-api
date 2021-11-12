package io.swagger.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Character
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class Character {
	@JsonProperty("id")
	private BigDecimal id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("modified")
	private String modified = null;

	@JsonProperty("resourceURI")
	private String resourceURI = null;

	@JsonProperty("urls")
	@Valid
	private List<Url> urls = null;

	@JsonProperty("thumbnail")
	private Image thumbnail = null;

	@JsonProperty("comics")
	private ComicList comics = null;

	@JsonProperty("stories")
	private StoryList stories = null;

	@JsonProperty("events")
	private EventList events = null;

	@JsonProperty("series")
	private SeriesList series = null;

	public Character id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique ID of the character resource.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The unique ID of the character resource.")

	@Valid
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Character name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name of the character.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "The name of the character.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A short bio or description of the character.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A short bio or description of the character.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character modified(String modified) {
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

	public Character resourceURI(String resourceURI) {
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

	public Character urls(List<Url> urls) {
		this.urls = urls;
		return this;
	}

	public Character addUrlsItem(Url urlsItem) {
		if (this.urls == null) {
			this.urls = new ArrayList<Url>();
		}
		this.urls.add(urlsItem);
		return this;
	}

	/**
	 * A set of public web site URLs for the resource.
	 * 
	 * @return urls
	 **/
	@ApiModelProperty(value = "A set of public web site URLs for the resource.")
	@Valid
	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Character thumbnail(Image thumbnail) {
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

	public Character comics(ComicList comics) {
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

	public Character stories(StoryList stories) {
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

	public Character events(EventList events) {
		this.events = events;
		return this;
	}

	/**
	 * Get events
	 * 
	 * @return events
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public EventList getEvents() {
		return events;
	}

	public void setEvents(EventList events) {
		this.events = events;
	}

	public Character series(SeriesList series) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Character character = (Character) o;
		return Objects.equals(this.id, character.id) && Objects.equals(this.name, character.name)
				&& Objects.equals(this.description, character.description)
				&& Objects.equals(this.modified, character.modified)
				&& Objects.equals(this.resourceURI, character.resourceURI) && Objects.equals(this.urls, character.urls)
				&& Objects.equals(this.thumbnail, character.thumbnail) && Objects.equals(this.comics, character.comics)
				&& Objects.equals(this.stories, character.stories) && Objects.equals(this.events, character.events)
				&& Objects.equals(this.series, character.series);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, modified, resourceURI, urls, thumbnail, comics, stories, events,
				series);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Character {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
		sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
		sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
		sb.append("    comics: ").append(toIndentedString(comics)).append("\n");
		sb.append("    stories: ").append(toIndentedString(stories)).append("\n");
		sb.append("    events: ").append(toIndentedString(events)).append("\n");
		sb.append("    series: ").append(toIndentedString(series)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
