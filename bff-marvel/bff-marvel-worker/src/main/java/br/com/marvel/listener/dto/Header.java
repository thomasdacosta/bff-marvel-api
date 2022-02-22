package br.com.marvel.listener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Header {

	@JsonProperty("Type")
	@Getter
	@Setter
	private String type;

	@JsonProperty("Value")
	@Getter
	@Setter
	private String value;

}
