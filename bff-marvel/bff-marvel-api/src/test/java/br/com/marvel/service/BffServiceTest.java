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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestPropertySource;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.marvel.BffMarvelApiApplication;
import br.com.marvel.client.configuration.ClientConfiguration;
import br.com.marvel.controller.dto.MarvelCharacter;
import br.com.marvel.controller.exception.NotFoundException;
import br.com.marvel.service.ports.BffService;
import br.com.marvel.utils.Constants;
import br.com.marvel.utils.ResourceUtils;

@WireMockTest(httpPort = 8083)
@SpringBootTest(classes = BffMarvelApiApplication.class)
@TestPropertySource(locations = "classpath:application-bffServiceTest.java.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BffServiceTest {

	@Autowired
	private BffService service;

	@Autowired
	private ClientConfiguration configuration;

	@Value("classpath:json/listCharacters_OK.json")
	private Resource listCharactersOK;

	@Value("classpath:json/characterComics_OK.json")
	private Resource characterComicsOK;

	@Value("classpath:json/characterEvents_OK.json")
	private Resource characterEventsOK;

	@Value("classpath:json/listCharacters_NotFound.json")
	private Resource listCharactersNotFound;

	@Test
	@Order(1)
	@DisplayName("1 - Executando o Service com a orquestração das chamadas de API da Marvel")
	public void testFindCharacter() {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersOK))));

		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters/%s/comics?ts=%s&apikey=%s&hash=%s&orderBy=-focDate",
						Constants.CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(),
						configuration.getHash()))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(characterComicsOK))));

		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters/%s/events?ts=%s&apikey=%s&hash=%s", Constants.CHARACTERS_ID,
						configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(characterEventsOK))));

		List<MarvelCharacter> result = service.findCharacters(Constants.CHARACTERS_NAME);

		assertFalse(result.isEmpty());
		
		assertThat(result.size(), equalTo(1));
		assertThat(result.get(0).getId(), equalTo(BigDecimal.valueOf(Long.parseLong(Constants.CHARACTERS_ID))));
		assertThat(result.get(0).getName().toLowerCase(), equalTo(Constants.CHARACTERS_NAME.toLowerCase()));
		
		assertNotNull(result.get(0).getDescription());
		assertThat(result.get(0).getComics().size(), equalTo(20));
		assertThat(result.get(0).getEvents().size(), equalTo(20));
	}

	@Test
	@Order(2)
	@DisplayName("2 - Personagem não encontrado")
	public void testNotFoundCharacter() {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME_NOT_FOUND))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(listCharactersNotFound))));

		assertThrows(NotFoundException.class, () -> {
			service.findCharacters(Constants.CHARACTERS_NAME_NOT_FOUND);
		});
	}

}
