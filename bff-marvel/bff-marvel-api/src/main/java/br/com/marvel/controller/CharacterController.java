package br.com.marvel.controller;

import br.com.marvel.controller.dto.Pagination;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.exception.CharactersNotFoundException;
import br.com.marvel.service.ports.CharacterService;
import br.com.marvel.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class CharacterController {

	@Autowired
	private CharacterService characterService;
	
	@PostMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCharacters(@RequestBody MarvelCharacter marvelCharacter) {
		return response(characterService.saveCharacters(marvelCharacter));
	}

	@GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findCharacters(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "nameStartsWith", required = false) String nameStartsWith,
			@RequestHeader(name = "limit", defaultValue = "10") BigDecimal limit,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		return response(characterService.findCharacters(name, nameStartsWith, limit, offset));
	}

	@GetMapping(value = "/characters", produces = MediaType.IMAGE_JPEG_VALUE, consumes = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody ResponseEntity<?> findCharactersImage(
			@RequestParam(name = "name", required = false) String name,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		return response(characterService.findImageCharacters(name, offset));
	}

	@GetMapping(value = "/characters/comics/{id_character}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findComicsByCharacter(@PathVariable(name = "id_character") String idCharacter,
			@RequestHeader(name = "limit", defaultValue = "10") BigDecimal limit,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		return response(characterService.findComicsByCharacter(idCharacter, limit, offset));
	}

	@GetMapping(value = "/characters/series/{id_character}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findSeriesByCharacter(@PathVariable(name = "id_character") String idCharacter,
			@RequestHeader(name = "limit", defaultValue = "10") BigDecimal limit,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		return response(characterService.findSeriesByCharacter(idCharacter, limit, offset));
	}

	@GetMapping(value = "/characters/stories/{id_character}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findStoriesByCharacter(@PathVariable(name = "id_character") String idCharacter,
			@RequestHeader(name = "limit", defaultValue = "10") BigDecimal limit,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		return response(characterService.findStoriesByCharacter(idCharacter, limit, offset));
	}

	@GetMapping(value = "/characters/events/{id_character}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findEventsByCharacter(@PathVariable(name = "id_character") String idCharacter,
			@RequestHeader(name = "limit", defaultValue = "10") BigDecimal limit,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		return response(characterService.findEventsByCharacter(idCharacter, limit, offset));
	}

	private ResponseEntity<?> response(Pagination pagination) {
		if (pagination == null)
			throw new CharactersNotFoundException("Personagem não encontrado. Deve ser da concorrente!!!");
		return ResponseEntity.ok().headers(PaginationUtils.paginationHeaders(pagination)).body(pagination.getData());
	}
	
	private ResponseEntity<?> response(MarvelCharacter marvelCharacter) {
		return ResponseEntity.ok().body(marvelCharacter);
	}	

}
