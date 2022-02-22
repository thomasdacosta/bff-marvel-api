package br.com.marvel.controller.dto.characters;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class MarvelCharacter {

	@JsonProperty("id")
	@Getter
	@Setter
	private BigDecimal id;

	@JsonProperty("name")
	@Getter
	@Setter
	private String name;

	@JsonProperty("description")
	@Getter
	@Setter
	private String description;

	@JsonProperty("modified")
	@Getter
	@Setter
	private String modified;

	@JsonProperty("thumbnail")
	@Getter
	@Setter
	private ThumbnailCharacter thumbnail;

	@JsonProperty("urls")
	@Getter
	@Setter
	private List<UrlCharacter> urlCharacters;

}
