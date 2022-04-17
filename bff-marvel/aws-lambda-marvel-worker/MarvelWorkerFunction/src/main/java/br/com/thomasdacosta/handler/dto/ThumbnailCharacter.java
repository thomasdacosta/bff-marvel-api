package br.com.thomasdacosta.handler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThumbnailCharacter {

	@JsonProperty("url")
	private String url;

	@JsonProperty("extension")
	private String extension;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
