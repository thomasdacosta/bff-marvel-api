package br.com.marvel.service.ports;

import java.util.List;

import br.com.marvel.controller.dto.MarvelCharacter;
import br.com.marvel.controller.dto.MarvelComics;
import br.com.marvel.controller.dto.MarvelEvents;

public interface BffService {

	List<MarvelCharacter> findCharacters(String name);

	List<MarvelComics> findComicsByCharacter(String id);

	List<MarvelEvents> findEventsByCharacter(String id);

}