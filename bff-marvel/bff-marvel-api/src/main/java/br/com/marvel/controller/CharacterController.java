package br.com.marvel.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marvel.controller.dto.Pagination;
import br.com.marvel.controller.exception.NotFoundException;
import br.com.marvel.service.ports.CharacterService;
import br.com.marvel.utils.PaginationUtils;

@RestController
@RequestMapping("/")
public class CharacterController {

	@Autowired
	private CharacterService characterService;

	@GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<?>> findCharacters(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "nameStartsWith", required = false) String nameStartsWith,
			@RequestHeader(name = "limit", defaultValue = "10") BigDecimal limit,
			@RequestHeader(name = "offset", defaultValue = "0") BigDecimal offset) {
		Pagination pagination = characterService.findCharacters(name, nameStartsWith, limit, offset);
		if (pagination == null)
			throw new NotFoundException("Personagens não encontrados. Deve ser da concorrente!!!");

		return ResponseEntity.ok().headers(PaginationUtils.paginationHeaders(pagination))
				.body((List<?>) pagination.getData());
	}

}
