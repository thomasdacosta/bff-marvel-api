package br.com.marvel.service.ports;

import java.math.BigDecimal;

import br.com.marvel.controller.dto.Pagination;

public interface CharacterService {

	Pagination findCharacters(String name, String nameStartsWith, BigDecimal limit, BigDecimal offset);
	
	Pagination findImageCharacters(String name, BigDecimal offset);

}