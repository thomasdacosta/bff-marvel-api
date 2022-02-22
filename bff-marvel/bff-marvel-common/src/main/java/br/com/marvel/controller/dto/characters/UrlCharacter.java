package br.com.marvel.controller.dto.characters;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class UrlCharacter {

	@JsonProperty("detail")
	@Getter @Setter	
	private String type;
	
	@JsonProperty("url")
	@Getter @Setter	
	private String url;	
	
}
