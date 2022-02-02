package br.com.marvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marvel.controler.dto.MarvelCharacter;
import br.com.marvel.service.ports.BffService;

@RestController
@RequestMapping("/")
public class BffController {
	
	@Autowired
	private BffService bffService;
	
	@GetMapping(value = "/marvel/heros/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MarvelCharacter>> findCharacters(@PathVariable("name") String name) {
		return ResponseEntity.ok(bffService.findCharacters(name));
	}

}
