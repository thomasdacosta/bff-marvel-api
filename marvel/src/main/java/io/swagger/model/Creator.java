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
 * Creator
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class Creator {
	@JsonProperty("id")
	private BigDecimal id = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("middleName")
	private String middleName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("suffix")
	private String suffix = null;

	@JsonProperty("fullName")
	private String fullName = null;

	@JsonProperty("modified")
	private String modified = null;

	@JsonProperty("resourceURI")
	private String resourceURI = null;

	@JsonProperty("urls")
	@Valid
	private List<Url> urls = null;

	@JsonProperty("thumbnail")
	private Image thumbnail = null;

	@JsonProperty("series")
	private SeriesList series = null;

	@JsonProperty("stories")
	private StoryList stories = null;

	@JsonProperty("comics")
	private ComicList comics = null;

	@JsonProperty("events")
	private EventList events = null;

	public Creator id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique ID of the creator resource.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The unique ID of the creator resource.")

	@Valid
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Creator firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * The first name of the creator.
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(value = "The first name of the creator.")

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Creator middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	/**
	 * The middle name of the creator.
	 * 
	 * @return middleName
	 **/
	@ApiModelProperty(value = "The middle name of the creator.")

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Creator lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * The last name of the creator.
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(value = "The last name of the creator.")

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Creator suffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

	/**
	 * The suffix or honorific for the creator.
	 * 
	 * @return suffix
	 **/
	@ApiModelProperty(value = "The suffix or honorific for the creator.")

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Creator fullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	/**
	 * The full name of the creator (a space-separated concatenation of the above
	 * four fields).
	 * 
	 * @return fullName
	 **/
	@ApiModelProperty(value = "The full name of the creator (a space-separated concatenation of the above four fields).")

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Creator modified(String modified) {
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

	public Creator resourceURI(String resourceURI) {
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

	public Creator urls(List<Url> urls) {
		this.urls = urls;
		return this;
	}

	public Creator addUrlsItem(Url urlsItem) {
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

	public Creator thumbnail(Image thumbnail) {
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

	public Creator series(SeriesList series) {
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

	public Creator stories(StoryList stories) {
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

	public Creator comics(ComicList comics) {
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

	public Creator events(EventList events) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Creator creator = (Creator) o;
		return Objects.equals(this.id, creator.id) && Objects.equals(this.firstName, creator.firstName)
				&& Objects.equals(this.middleName, creator.middleName)
				&& Objects.equals(this.lastName, creator.lastName) && Objects.equals(this.suffix, creator.suffix)
				&& Objects.equals(this.fullName, creator.fullName) && Objects.equals(this.modified, creator.modified)
				&& Objects.equals(this.resourceURI, creator.resourceURI) && Objects.equals(this.urls, creator.urls)
				&& Objects.equals(this.thumbnail, creator.thumbnail) && Objects.equals(this.series, creator.series)
				&& Objects.equals(this.stories, creator.stories) && Objects.equals(this.comics, creator.comics)
				&& Objects.equals(this.events, creator.events);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, middleName, lastName, suffix, fullName, modified, resourceURI, urls,
				thumbnail, series, stories, comics, events);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Creator {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
		sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
		sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
		sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
		sb.append("    series: ").append(toIndentedString(series)).append("\n");
		sb.append("    stories: ").append(toIndentedString(stories)).append("\n");
		sb.append("    comics: ").append(toIndentedString(comics)).append("\n");
		sb.append("    events: ").append(toIndentedString(events)).append("\n");
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
