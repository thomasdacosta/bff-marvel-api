package br.com.marvel.service.ports;

import java.math.BigDecimal;

import br.com.marvel.controller.dto.Pagination;
import br.com.marvel.controller.dto.characters.MarvelCharacter;

public interface CharacterService {

	Pagination findCharacters(String name, String nameStartsWith, BigDecimal limit, BigDecimal offset);

	Pagination findImageCharacters(String name, BigDecimal offset);

	Pagination findComicsByCharacter(String id, BigDecimal limit, BigDecimal offset);

	Pagination findSeriesByCharacter(String id, BigDecimal limit, BigDecimal offset);

	Pagination findStoriesByCharacter(String id, BigDecimal limit, BigDecimal offset);

	Pagination findEventsByCharacter(String id, BigDecimal limit, BigDecimal offset);

	MarvelCharacter saveCharacters(MarvelCharacter marvelCharacter);

}