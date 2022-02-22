package br.com.marvel.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.marvel.BffMarvelApiApplication;
import br.com.marvel.controller.dto.characters.MarvelCharacter;
import br.com.marvel.utils.Constants;
import br.com.marvel.utils.DataMapper;
import br.com.marvel.utils.WireMockServers;

@WireMockTest(httpPort = 8085)
@SpringBootTest(classes = BffMarvelApiApplication.class)
@TestPropertySource(locations = "classpath:application-characterControllerTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CharacterControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private DataMapper dataMapper;

	@Autowired
	private WireMockServers wireMock;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	@Order(1)
	@DisplayName("1 - Efetuando a busca de um personagem de acordo com o critério de pesquisa")
	public void testFindCharacters() throws Exception {
		wireMock.serverCharacterOffSet(dataMapper.getListCharactersOK());

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get(String.format("/characters?name=%s", Constants.CHARACTERS_NAME))
						.header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		ObjectMapper mapper = new ObjectMapper();
		List<MarvelCharacter> result = mapper.readValue(mvcResult.getResponse().getContentAsString(),
				new TypeReference<List<MarvelCharacter>>() {
				});

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
	public void testNotFoundCharacter() throws Exception {
		wireMock.serverCharacterNotFound(dataMapper.getListCharactersNotFound());
		mockMvc.perform(
				MockMvcRequestBuilders.get(String.format("/marvel/heros/%s", Constants.CHARACTERS_NAME_NOT_FOUND)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
