package br.com.marvel.controler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class MarvelEvents {
	
	@JsonProperty("title")
	@Getter @Setter
	private String title;	
	
	@JsonProperty("description")
	@Getter @Setter
	private String description;	

}
