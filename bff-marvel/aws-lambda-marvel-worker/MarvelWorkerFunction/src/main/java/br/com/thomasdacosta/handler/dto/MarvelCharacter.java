package br.com.thomasdacosta.handler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class MarvelCharacter {

	@JsonProperty("id")
	private BigDecimal id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("modified")
	private String modified;

	@JsonProperty("thumbnail")
	private ThumbnailCharacter thumbnail;

	@JsonProperty("urls")
	private List<UrlCharacter> urlCharacters;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public ThumbnailCharacter getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(ThumbnailCharacter thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<UrlCharacter> getUrlCharacters() {
		return urlCharacters;
	}

	public void setUrlCharacters(List<UrlCharacter> urlCharacters) {
		this.urlCharacters = urlCharacters;
	}

}
