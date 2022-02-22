package br.com.marvel.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

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
import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.utils.Constants;
import br.com.marvel.utils.DataMapper;
import br.com.marvel.utils.WireMockServers;
import feign.FeignException.InternalServerError;
import feign.FeignException.NotFound;

@WireMockTest(httpPort = 8081)
@SpringBootTest(classes = BffMarvelApiApplication.class)
@TestPropertySource(locations = "classpath:application-marvelApiClientTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarvelClientTest {

	@Autowired
	private MarvelClient client;

	@Autowired
	private DataMapper dataMapper;

	@Autowired
	private WireMockServers wireMock;

	@Test
	@Order(1)
	@DisplayName("1 - Obtendo um personagem através do nome")
	public void testGetCharacter_200() {
		wireMock.serverCharacter(dataMapper.getListCharactersOK());
		InlineResponse200 listCharacters = client.listCharacters(Constants.CHARACTERS_NAME, null, null, null, null,
				null, null, null, null, null);

		assertNotNull(listCharacters.getData());
		assertThat(listCharacters.getData().getCount(), equalTo(BigDecimal.valueOf(1)));
		assertFalse(listCharacters.getData().getResults().isEmpty());
		assertThat(listCharacters.getData().getResults().get(0).getId(),
				equalTo(BigDecimal.valueOf(Long.parseLong(Constants.CHARACTERS_ID))));
	}

	@Test
	@Order(2)
	@DisplayName("2 - Obtendo as HQ´s de um personagem através do ID")
	public void testGetComicsByCharacter_200() {
		wireMock.serverCharactersComics(dataMapper.getCharacterComicsOK());
		ComicDataWrapper characterComics = client.characterComics(Constants.CHARACTERS_ID, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, "-focDate", null,
				null);

		assertNotNull(characterComics.getData());
		assertThat(characterComics.getData().getCount(), equalTo(BigDecimal.valueOf(20)));
		assertFalse(characterComics.getData().getResults().isEmpty());
	}

	@Test
	@Order(3)
	@DisplayName("3 - Obtendo os Eventos de um personagem através do ID")
	public void testGetEventsByCharacter_200() {
		wireMock.serverCharactersEvents(dataMapper.getCharacterEventsOK());
		EventDataWrapper characterEvents = client.characterEvents(Constants.CHARACTERS_ID, null, null, null, null, null,
				null, null, null, null, null);

		assertNotNull(characterEvents.getData());
		assertThat(characterEvents.getData().getCount(), equalTo(BigDecimal.valueOf(20)));
		assertFalse(characterEvents.getData().getResults().isEmpty());
	}

	@Test
	@Order(4)
	@DisplayName("4 - Retornando um erro 404 do Client da API")
	public void testGetCharacter_404() {
		wireMock.serverNotFound(dataMapper.getListCharactersOK());
		assertThrows(NotFound.class, () -> {
			client.listCharacters(Constants.CHARACTERS_NAME, null, null, null, null, null, null, null, null, null);
		});
	}

	@Test
	@Order(5)
	@DisplayName("5 - Retornando um erro 500 do Client da API")
	public void testGetCharacter_500() {
		wireMock.serverInternalServerError(dataMapper.getListCharactersOK());
		assertThrows(InternalServerError.class, () -> {
			client.listCharacters(Constants.CHARACTERS_NAME, null, null, null, null, null, null, null, null, null);
		});
	}

}
