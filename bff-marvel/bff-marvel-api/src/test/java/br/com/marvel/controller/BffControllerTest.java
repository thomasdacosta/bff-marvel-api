package br.com.marvel.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.marvel.BffMarvelApiApplication;
import br.com.marvel.configuration.BffConfiguration;
import br.com.marvel.dto.MarvelCharacter;
import br.com.marvel.utills.Constants;
import br.com.marvel.utils.ResourceUtils;

@WireMockTest(httpPort = 8085)
@SpringBootTest(classes = BffMarvelApiApplication.class)
@TestPropertySource(locations = "classpath:application-bffControllerTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BffControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;	
	
	@Autowired
	private BffConfiguration configuration;
	
	@Value("classpath:json/listCharacters_OK.json")
	private Resource listCharactersOK;
	
	@Value("classpath:json/characterComics_OK.json")
	private Resource characterComicsOK;	
	
	@Value("classpath:json/characterEvents_OK.json")
	private Resource characterEventsOK;
	
	@Value("classpath:json/listCharacters_NotFound.json")
	private Resource listCharactersNotFound;	
	
	@BeforeEach
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}	
	
	@Test
	@Order(1)
	@DisplayName("1 - Efetuando a busca de um personagem de acordo com o critério de pesquisa")
	public void testFindCharacters() {
		try {
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s",
					configuration.getTs(), configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(listCharactersOK))));
			
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters/%s/comics?ts=%s&apikey=%s&hash=%s&orderBy=-focDate",
					Constants.CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(characterComicsOK))));
			
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters/%s/events?ts=%s&apikey=%s&hash=%s",
					Constants.CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(characterEventsOK))));			
			
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
					.get(String.format("/marvel/heros/%s", Constants.CHARACTERS_NAME)))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
			
			ObjectMapper mapper = new ObjectMapper();
			List<MarvelCharacter> result = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<MarvelCharacter>>() {});
			
			assertFalse(result.isEmpty());
			assertEquals(1, result.size());
			assertEquals(BigDecimal.valueOf(Long.parseLong(Constants.CHARACTERS_ID)), result.get(0).getId());
			assertEquals(Constants.CHARACTERS_NAME.toLowerCase(), result.get(0).getName().toLowerCase());
			assertFalse(result.get(0).getComics().isEmpty());
			assertEquals(20, result.get(0).getComics().size());
			assertFalse(result.get(0).getEvents().isEmpty());
			assertEquals(20, result.get(0).getEvents().size());
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
	
	@Test
	@Order(2)	
	@DisplayName("2 - Personagem não encontrado")
	public void testNotFoundCharacter() {
		try {
			WireMock.stubFor(WireMock.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s",
					configuration.getTs(), configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME_NOT_FOUND))
					.willReturn(WireMock.aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody(ResourceUtils.getContentFile(listCharactersNotFound))));
			
			mockMvc.perform(MockMvcRequestBuilders
					.get(String.format("/marvel/heros/%s", Constants.CHARACTERS_NAME_NOT_FOUND)))
					.andExpect(MockMvcResultMatchers.status().isNotFound());
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
