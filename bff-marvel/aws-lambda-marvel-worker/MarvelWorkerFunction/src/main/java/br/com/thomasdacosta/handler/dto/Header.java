package br.com.thomasdacosta.handler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Value")
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
