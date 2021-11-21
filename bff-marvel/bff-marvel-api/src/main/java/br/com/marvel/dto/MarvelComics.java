package br.com.marvel.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class MarvelComics {
	
	@JsonProperty("title")
	@Getter @Setter
	private String title;	
	
	@JsonProperty("issueNumber")
	@Getter @Setter
	private BigDecimal issueNumber;	

}
