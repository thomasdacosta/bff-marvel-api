package br.com.marvel.controller.dto.characters;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class ThumbnailCharacter {

	@JsonProperty("url")
	@Getter
	@Setter
	private String url;

	@JsonProperty("extension")
	@Getter
	@Setter
	private String extension;

}
