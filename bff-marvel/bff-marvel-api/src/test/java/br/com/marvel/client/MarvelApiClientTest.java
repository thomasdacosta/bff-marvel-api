package br.com.marvel.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.marvel.BffMarvelApiApplication;
import br.com.marvel.configuration.BffConfiguration;
import br.com.marvel.model.ComicDataWrapper;
import br.com.marvel.model.EventDataWrapper;
import br.com.marvel.model.InlineResponse200;
import br.com.marvel.utils.ResourceUtils;
import feign.FeignException.InternalServerError;
import feign.FeignException.NotFound;

@WireMockTest(httpPort = 8081)
@SpringBootTest(classes = BffMarvelApiApplication.class)
@TestPropertySource(locations = "classpath:application-marvelApiClientTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarvelApiClientTest {
	
	private static final String CHARACTERS_NAME = "thor";
	private static final String CHARACTERS_ID = "1009664";
	
	@Autowired
	private MarvelApiClient client;
	
	@Autowired
	private BffConfiguration configuration;
	
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
		try {
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s",
					configuration.getTs(), configuration.getApiKey(), configuration.getHash(), CHARACTERS_NAME))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(listCharactersOK))));
			
			ResponseEntity<InlineResponse200> listCharacters = client.listCharacters(configuration.getTs(),
					configuration.getApiKey(), configuration.getHash(), CHARACTERS_NAME, null, null, null, null, null, null, null,
					null, null);
			
			assertTrue(listCharacters.hasBody());
			assertNotNull(listCharacters.getBody().getData());
			assertEquals(BigDecimal.valueOf(1), listCharacters.getBody().getData().getCount());
			assertFalse(listCharacters.getBody().getData().getResults().isEmpty());
			assertEquals(BigDecimal.valueOf(1009664), listCharacters.getBody().getData().getResults().get(0).getId());
			assertEquals(CHARACTERS_NAME.toLowerCase(), listCharacters.getBody().getData().getResults().get(0).getName().toLowerCase());
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
	
	@Test
	@Order(2)
	@DisplayName("2 - Obtendo as HQ´s de um personagem através do ID")
	public void testGetComicsByCharacter_200() {
		try {
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters/%s/comics?ts=%s&apikey=%s&hash=%s&orderBy=-focDate",
					CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(characterComicsOK))));			
			
			ResponseEntity<ComicDataWrapper> characterComics = client.characterComics(configuration.getTs(),
					configuration.getApiKey(), configuration.getHash(), CHARACTERS_ID, null, null, null, null, null, null, null, null,
					null, null, null, null, null, null, null, null, null, null, null, "-focDate", null, null);			
			
			System.out.println(characterComics);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
	
	@Test
	@Order(3)
	@DisplayName("3 - Obtendo os Eventos de um personagem através do ID")
	public void testGetEventsByCharacter_200() {
		try {
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters/%s/events?ts=%s&apikey=%s&hash=%s",
					CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(characterEventsOK))));			
			
			ResponseEntity<EventDataWrapper> characterEvents = client.characterEvents(configuration.getTs(),
					configuration.getApiKey(), configuration.getHash(), CHARACTERS_ID, null, null, null, null, null, null, null, null,
					null, null);			
			
			System.out.println(characterEvents);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}	
	
	@Test
	@Order(4)
	@DisplayName("4 - Retornando um erro 404 do Client da API")	
	public void testGetCharacter_404() {
		WireMock.stubFor(WireMock.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s",
				configuration.getTs(), configuration.getApiKey(), configuration.getHash(), CHARACTERS_NAME))
				.willReturn(WireMock.aResponse()
						.withStatus(404)
						.withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersOK))));
		
		assertThrows(NotFound.class, () -> {
			client.listCharacters(configuration.getTs(),
					configuration.getApiKey(), configuration.getHash(), CHARACTERS_NAME, null, null, null, null, null, null, null,
					null, null);			
		});
	}
	
	@Test
	@Order(5)
	@DisplayName("5 - Retornando um erro 500 do Client da API")	
	public void testGetCharacter_500() {
		WireMock.stubFor(WireMock.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s",
				configuration.getTs(), configuration.getApiKey(), configuration.getHash(), CHARACTERS_NAME))
				.willReturn(WireMock.aResponse()
						.withStatus(500)
						.withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersOK))));
		
		assertThrows(InternalServerError.class, () -> {
			client.listCharacters(configuration.getTs(),
					configuration.getApiKey(), configuration.getHash(), CHARACTERS_NAME, null, null, null, null, null, null, null,
					null, null);			
		});
	}	
	
}
