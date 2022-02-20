package br.com.marvel.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.marvel.BffMarvelApiApplication;
import br.com.marvel.controller.dto.Pagination;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.controller.exception.CharactersNotFoundException;
import br.com.marvel.service.ports.CharacterService;
import br.com.marvel.utils.Constants;
import br.com.marvel.utils.DataMapper;
import br.com.marvel.utils.WireMockServers;

@WireMockTest(httpPort = 8083)
@SpringBootTest(classes = BffMarvelApiApplication.class)
@TestPropertySource(locations = "classpath:application-characterServiceTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CharacterServiceTest {

	@Autowired
	private CharacterService service;

	@Autowired
	private DataMapper dataMapper;

	@Autowired
	private WireMockServers wireMock;

	@Test
	@Order(1)
	@DisplayName("1 - Executando busca de um personagem")
	public void testFindCharacter() {
		wireMock.serverCharacter(dataMapper.getListCharactersOK());

		Pagination pagination = service.findCharacters(Constants.CHARACTERS_NAME, null, null, null);

		assertNotNull(pagination);
		assertNotNull(pagination.getData());

		@SuppressWarnings("unchecked")
		List<MarvelCharacter> result = (List<MarvelCharacter>) pagination.getData();

		assertFalse(result.isEmpty());
		assertThat(result.size(), equalTo(1));

		assertThat(result.get(0).getId(), equalTo(BigDecimal.valueOf(Long.parseLong(Constants.CHARACTERS_ID))));
		assertThat(result.get(0).getName().toLowerCase(), equalTo(Constants.CHARACTERS_NAME.toLowerCase()));

		assertNotNull(result.get(0).getDescription());
		assertNotNull(result.get(0).getModified());
		assertNotNull(result.get(0).getThumbnail());

		assertNotNull(result.get(0).getUrlCharacters());
		assertThat(result.get(0).getUrlCharacters().size(), equalTo(3));
	}

	@Test
	@Order(2)
	@DisplayName("2 - Personagem não encontrado")
	public void testNotFoundCharacter() {
		wireMock.serverCharacterNotFound(dataMapper.getListCharactersNotFound());
		assertThrows(CharactersNotFoundException.class, () -> {
			Pagination pagination = service.findCharacters(Constants.CHARACTERS_NAME_NOT_FOUND, null, null, null);
			if (pagination == null)
				throw new CharactersNotFoundException("");
		});
	}

}
