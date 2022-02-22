package br.com.marvel.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class DataMapper {

	@Getter
	@Setter
	@Value("classpath:json/listCharacters_OK.json")
	private Resource listCharactersOK;

	@Getter
	@Setter
	@Value("classpath:json/characterComics_OK.json")
	private Resource characterComicsOK;

	@Getter
	@Setter
	@Value("classpath:json/characterEvents_OK.json")
	private Resource characterEventsOK;

	@Getter
	@Setter
	@Value("classpath:json/listCharacters_NotFound.json")
	private Resource listCharactersNotFound;

}
