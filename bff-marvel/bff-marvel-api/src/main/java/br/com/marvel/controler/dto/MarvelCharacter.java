package br.com.marvel.controler.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class MarvelCharacter {
	
	@JsonProperty("id")
	@Getter @Setter
	private BigDecimal id;
	
	@JsonProperty("name")
	@Getter @Setter
	private String name;
	
	@JsonProperty("description")
	@Getter @Setter
	private String description;
	
	@JsonProperty("comics")
	@Getter @Setter	
	private List<MarvelComics> comics;
	
	@JsonProperty("events")
	@Getter @Setter	
	private List<MarvelEvents> events;	

}
