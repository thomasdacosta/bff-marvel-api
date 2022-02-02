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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestPropertySource;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.marvel.BffMarvelApiApplication;
import br.com.marvel.client.configuration.ClientConfiguration;
import br.com.marvel.client.dto.ComicDataWrapper;
import br.com.marvel.client.dto.EventDataWrapper;
import br.com.marvel.client.dto.InlineResponse200;
import br.com.marvel.client.ports.MarvelClient;
import br.com.marvel.utils.Constants;
import br.com.marvel.utils.ResourceUtils;
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
	private ClientConfiguration configuration;

	@Value("classpath:json/listCharacters_OK.json")
	private Resource listCharactersOK;

	@Value("classpath:json/characterComics_OK.json")
	private Resource characterComicsOK;

	@Value("classpath:json/characterEvents_OK.json")
	private Resource characterEventsOK;

	@Test
	@Order(1)
	@DisplayName("1 - Obtendo um personagem através do nome")
	public void testGetCharacter_200() {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersOK))));

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
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters/%s/comics?ts=%s&apikey=%s&hash=%s&orderBy=-focDate",
						Constants.CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(),
						configuration.getHash()))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(characterComicsOK))));

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
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters/%s/events?ts=%s&apikey=%s&hash=%s", Constants.CHARACTERS_ID,
						configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(characterEventsOK))));

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
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(404).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersOK))));

		assertThrows(NotFound.class, () -> {
			client.listCharacters(Constants.CHARACTERS_NAME, null, null, null, null, null, null, null, null, null);
		});
	}

	@Test
	@Order(5)
	@DisplayName("5 - Retornando um erro 500 do Client da API")
	public void testGetCharacter_500() {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(500).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersOK))));

		assertThrows(InternalServerError.class, () -> {
			client.listCharacters(Constants.CHARACTERS_NAME, null, null, null, null, null, null, null, null, null);
		});
	}

}
