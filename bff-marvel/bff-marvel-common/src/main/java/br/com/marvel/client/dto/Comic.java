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
 * Comic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class Comic {
	@JsonProperty("id")
	private BigDecimal id = null;

	@JsonProperty("digitalId")
	private BigDecimal digitalId = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("issueNumber")
	private BigDecimal issueNumber = null;

	@JsonProperty("variantDescription")
	private String variantDescription = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("modified")
	private String modified = null;

	@JsonProperty("isbn")
	private String isbn = null;

	@JsonProperty("upc")
	private String upc = null;

	@JsonProperty("diamondCode")
	private String diamondCode = null;

	@JsonProperty("ean")
	private String ean = null;

	@JsonProperty("issn")
	private String issn = null;

	@JsonProperty("format")
	private String format = null;

	@JsonProperty("pageCount")
	private BigDecimal pageCount = null;

	@JsonProperty("textObjects")
	@Valid
	private List<TextObject> textObjects = null;

	@JsonProperty("resourceURI")
	private String resourceURI = null;

	@JsonProperty("urls")
	@Valid
	private List<Url> urls = null;

	@JsonProperty("series")
	private SeriesSummary series = null;

	@JsonProperty("variants")
	@Valid
	private List<ComicSummary> variants = null;

	@JsonProperty("collections")
	@Valid
	private List<ComicSummary> collections = null;

	@JsonProperty("collectedIssues")
	@Valid
	private List<ComicSummary> collectedIssues = null;

	@JsonProperty("dates")
	@Valid
	private List<ComicDate> dates = null;

	@JsonProperty("prices")
	@Valid
	private List<ComicPrice> prices = null;

	@JsonProperty("thumbnail")
	private Image thumbnail = null;

	@JsonProperty("images")
	@Valid
	private List<Image> images = null;

	@JsonProperty("creators")
	private CreatorList creators = null;

	@JsonProperty("characters")
	private CharacterList characters = null;

	@JsonProperty("stories")
	private StoryList stories = null;

	@JsonProperty("events")
	private EventList events = null;

	public Comic id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique ID of the comic resource.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The unique ID of the comic resource.")

	@Valid
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Comic digitalId(BigDecimal digitalId) {
		this.digitalId = digitalId;
		return this;
	}

	/**
	 * The ID of the digital comic representation of this comic. Will be 0 if the
	 * comic is not available digitally.
	 * 
	 * @return digitalId
	 **/
	@ApiModelProperty(value = "The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.")

	@Valid
	public BigDecimal getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(BigDecimal digitalId) {
		this.digitalId = digitalId;
	}

	public Comic title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * The canonical title of the comic.
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "The canonical title of the comic.")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Comic issueNumber(BigDecimal issueNumber) {
		this.issueNumber = issueNumber;
		return this;
	}

	/**
	 * The number of the issue in the series (will generally be 0 for collection
	 * formats).
	 * 
	 * @return issueNumber
	 **/
	@ApiModelProperty(value = "The number of the issue in the series (will generally be 0 for collection formats).")

	@Valid
	public BigDecimal getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(BigDecimal issueNumber) {
		this.issueNumber = issueNumber;
	}

	public Comic variantDescription(String variantDescription) {
		this.variantDescription = variantDescription;
		return this;
	}

	/**
	 * If the issue is a variant (e.g. an alternate cover, second printing, or
	 * director’s cut), a text description of the variant.
	 * 
	 * @return variantDescription
	 **/
	@ApiModelProperty(value = "If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant.")

	public String getVariantDescription() {
		return variantDescription;
	}

	public void setVariantDescription(String variantDescription) {
		this.variantDescription = variantDescription;
	}

	public Comic description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * The preferred description of the comic.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "The preferred description of the comic.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Comic modified(String modified) {
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

	public Comic isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	/**
	 * The ISBN for the comic (generally only populated for collection formats).
	 * 
	 * @return isbn
	 **/
	@ApiModelProperty(value = "The ISBN for the comic (generally only populated for collection formats).")

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Comic upc(String upc) {
		this.upc = upc;
		return this;
	}

	/**
	 * The UPC barcode number for the comic (generally only populated for periodical
	 * formats).
	 * 
	 * @return upc
	 **/
	@ApiModelProperty(value = "The UPC barcode number for the comic (generally only populated for periodical formats).")

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Comic diamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
		return this;
	}

	/**
	 * The Diamond code for the comic.
	 * 
	 * @return diamondCode
	 **/
	@ApiModelProperty(value = "The Diamond code for the comic.")

	public String getDiamondCode() {
		return diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public Comic ean(String ean) {
		this.ean = ean;
		return this;
	}

	/**
	 * The EAN barcode for the comic.
	 * 
	 * @return ean
	 **/
	@ApiModelProperty(value = "The EAN barcode for the comic.")

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public Comic issn(String issn) {
		this.issn = issn;
		return this;
	}

	/**
	 * The ISSN barcode for the comic.
	 * 
	 * @return issn
	 **/
	@ApiModelProperty(value = "The ISSN barcode for the comic.")

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public Comic format(String format) {
		this.format = format;
		return this;
	}

	/**
	 * The publication format of the comic e.g. comic, hardcover, trade paperback.
	 * 
	 * @return format
	 **/
	@ApiModelProperty(value = "The publication format of the comic e.g. comic, hardcover, trade paperback.")

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Comic pageCount(BigDecimal pageCount) {
		this.pageCount = pageCount;
		return this;
	}

	/**
	 * The number of story pages in the comic.
	 * 
	 * @return pageCount
	 **/
	@ApiModelProperty(value = "The number of story pages in the comic.")

	@Valid
	public BigDecimal getPageCount() {
		return pageCount;
	}

	public void setPageCount(BigDecimal pageCount) {
		this.pageCount = pageCount;
	}

	public Comic textObjects(List<TextObject> textObjects) {
		this.textObjects = textObjects;
		return this;
	}

	public Comic addTextObjectsItem(TextObject textObjectsItem) {
		if (this.textObjects == null) {
			this.textObjects = new ArrayList<TextObject>();
		}
		this.textObjects.add(textObjectsItem);
		return this;
	}

	/**
	 * A set of descriptive text blurbs for the comic.
	 * 
	 * @return textObjects
	 **/
	@ApiModelProperty(value = "A set of descriptive text blurbs for the comic.")
	@Valid
	public List<TextObject> getTextObjects() {
		return textObjects;
	}

	public void setTextObjects(List<TextObject> textObjects) {
		this.textObjects = textObjects;
	}

	public Comic resourceURI(String resourceURI) {
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

	public Comic urls(List<Url> urls) {
		this.urls = urls;
		return this;
	}

	public Comic addUrlsItem(Url urlsItem) {
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

	public Comic series(SeriesSummary series) {
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
	public SeriesSummary getSeries() {
		return series;
	}

	public void setSeries(SeriesSummary series) {
		this.series = series;
	}

	public Comic variants(List<ComicSummary> variants) {
		this.variants = variants;
		return this;
	}

	public Comic addVariantsItem(ComicSummary variantsItem) {
		if (this.variants == null) {
			this.variants = new ArrayList<ComicSummary>();
		}
		this.variants.add(variantsItem);
		return this;
	}

	/**
	 * A list of variant issues for this comic (includes the \"original\" issue if
	 * the current issue is a variant).
	 * 
	 * @return variants
	 **/
	@ApiModelProperty(value = "A list of variant issues for this comic (includes the \"original\" issue if the current issue is a variant).")
	@Valid
	public List<ComicSummary> getVariants() {
		return variants;
	}

	public void setVariants(List<ComicSummary> variants) {
		this.variants = variants;
	}

	public Comic collections(List<ComicSummary> collections) {
		this.collections = collections;
		return this;
	}

	public Comic addCollectionsItem(ComicSummary collectionsItem) {
		if (this.collections == null) {
			this.collections = new ArrayList<ComicSummary>();
		}
		this.collections.add(collectionsItem);
		return this;
	}

	/**
	 * A list of collections which include this comic (will generally be empty if
	 * the comic's format is a collection).
	 * 
	 * @return collections
	 **/
	@ApiModelProperty(value = "A list of collections which include this comic (will generally be empty if the comic's format is a collection).")
	@Valid
	public List<ComicSummary> getCollections() {
		return collections;
	}

	public void setCollections(List<ComicSummary> collections) {
		this.collections = collections;
	}

	public Comic collectedIssues(List<ComicSummary> collectedIssues) {
		this.collectedIssues = collectedIssues;
		return this;
	}

	public Comic addCollectedIssuesItem(ComicSummary collectedIssuesItem) {
		if (this.collectedIssues == null) {
			this.collectedIssues = new ArrayList<ComicSummary>();
		}
		this.collectedIssues.add(collectedIssuesItem);
		return this;
	}

	/**
	 * A list of issues collected in this comic (will generally be empty for
	 * periodical formats such as \"comic\" or \"magazine\").
	 * 
	 * @return collectedIssues
	 **/
	@ApiModelProperty(value = "A list of issues collected in this comic (will generally be empty for periodical formats such as \"comic\" or \"magazine\").")
	@Valid
	public List<ComicSummary> getCollectedIssues() {
		return collectedIssues;
	}

	public void setCollectedIssues(List<ComicSummary> collectedIssues) {
		this.collectedIssues = collectedIssues;
	}

	public Comic dates(List<ComicDate> dates) {
		this.dates = dates;
		return this;
	}

	public Comic addDatesItem(ComicDate datesItem) {
		if (this.dates == null) {
			this.dates = new ArrayList<ComicDate>();
		}
		this.dates.add(datesItem);
		return this;
	}

	/**
	 * A list of key dates for this comic.
	 * 
	 * @return dates
	 **/
	@ApiModelProperty(value = "A list of key dates for this comic.")
	@Valid
	public List<ComicDate> getDates() {
		return dates;
	}

	public void setDates(List<ComicDate> dates) {
		this.dates = dates;
	}

	public Comic prices(List<ComicPrice> prices) {
		this.prices = prices;
		return this;
	}

	public Comic addPricesItem(ComicPrice pricesItem) {
		if (this.prices == null) {
			this.prices = new ArrayList<ComicPrice>();
		}
		this.prices.add(pricesItem);
		return this;
	}

	/**
	 * A list of prices for this comic.
	 * 
	 * @return prices
	 **/
	@ApiModelProperty(value = "A list of prices for this comic.")
	@Valid
	public List<ComicPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ComicPrice> prices) {
		this.prices = prices;
	}

	public Comic thumbnail(Image thumbnail) {
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

	public Comic images(List<Image> images) {
		this.images = images;
		return this;
	}

	public Comic addImagesItem(Image imagesItem) {
		if (this.images == null) {
			this.images = new ArrayList<Image>();
		}
		this.images.add(imagesItem);
		return this;
	}

	/**
	 * A list of promotional images associated with this comic.
	 * 
	 * @return images
	 **/
	@ApiModelProperty(value = "A list of promotional images associated with this comic.")
	@Valid
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Comic creators(CreatorList creators) {
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

	public Comic characters(CharacterList characters) {
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

	public Comic stories(StoryList stories) {
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

	public Comic events(EventList events) {
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Comic comic = (Comic) o;
		return Objects.equals(this.id, comic.id) && Objects.equals(this.digitalId, comic.digitalId)
				&& Objects.equals(this.title, comic.title) && Objects.equals(this.issueNumber, comic.issueNumber)
				&& Objects.equals(this.variantDescription, comic.variantDescription)
				&& Objects.equals(this.description, comic.description) && Objects.equals(this.modified, comic.modified)
				&& Objects.equals(this.isbn, comic.isbn) && Objects.equals(this.upc, comic.upc)
				&& Objects.equals(this.diamondCode, comic.diamondCode) && Objects.equals(this.ean, comic.ean)
				&& Objects.equals(this.issn, comic.issn) && Objects.equals(this.format, comic.format)
				&& Objects.equals(this.pageCount, comic.pageCount)
				&& Objects.equals(this.textObjects, comic.textObjects)
				&& Objects.equals(this.resourceURI, comic.resourceURI) && Objects.equals(this.urls, comic.urls)
				&& Objects.equals(this.series, comic.series) && Objects.equals(this.variants, comic.variants)
				&& Objects.equals(this.collections, comic.collections)
				&& Objects.equals(this.collectedIssues, comic.collectedIssues)
				&& Objects.equals(this.dates, comic.dates) && Objects.equals(this.prices, comic.prices)
				&& Objects.equals(this.thumbnail, comic.thumbnail) && Objects.equals(this.images, comic.images)
				&& Objects.equals(this.creators, comic.creators) && Objects.equals(this.characters, comic.characters)
				&& Objects.equals(this.stories, comic.stories) && Objects.equals(this.events, comic.events);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, digitalId, title, issueNumber, variantDescription, description, modified, isbn, upc,
				diamondCode, ean, issn, format, pageCount, textObjects, resourceURI, urls, series, variants,
				collections, collectedIssues, dates, prices, thumbnail, images, creators, characters, stories, events);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Comic {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    digitalId: ").append(toIndentedString(digitalId)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    issueNumber: ").append(toIndentedString(issueNumber)).append("\n");
		sb.append("    variantDescription: ").append(toIndentedString(variantDescription)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
		sb.append("    upc: ").append(toIndentedString(upc)).append("\n");
		sb.append("    diamondCode: ").append(toIndentedString(diamondCode)).append("\n");
		sb.append("    ean: ").append(toIndentedString(ean)).append("\n");
		sb.append("    issn: ").append(toIndentedString(issn)).append("\n");
		sb.append("    format: ").append(toIndentedString(format)).append("\n");
		sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
		sb.append("    textObjects: ").append(toIndentedString(textObjects)).append("\n");
		sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
		sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
		sb.append("    series: ").append(toIndentedString(series)).append("\n");
		sb.append("    variants: ").append(toIndentedString(variants)).append("\n");
		sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
		sb.append("    collectedIssues: ").append(toIndentedString(collectedIssues)).append("\n");
		sb.append("    dates: ").append(toIndentedString(dates)).append("\n");
		sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
		sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
		sb.append("    images: ").append(toIndentedString(images)).append("\n");
		sb.append("    creators: ").append(toIndentedString(creators)).append("\n");
		sb.append("    characters: ").append(toIndentedString(characters)).append("\n");
		sb.append("    stories: ").append(toIndentedString(stories)).append("\n");
		sb.append("    events: ").append(toIndentedString(events)).append("\n");
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
