package br.com.marvel.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.client.WireMock;

import br.com.marvel.client.configuration.ClientConfiguration;

@Component
public class WireMockServers {

	@Autowired
	private ClientConfiguration configuration;

	public void serverCharacter(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverCharacterOffSet(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s&limit=10&offset=0",
						configuration.getTs(), configuration.getApiKey(), configuration.getHash(),
						Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverCharacterNotFound(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME_NOT_FOUND))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverCharactersComics(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters/%s/comics?ts=%s&apikey=%s&hash=%s&orderBy=-focDate",
						Constants.CHARACTERS_ID, configuration.getTs(), configuration.getApiKey(),
						configuration.getHash()))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverCharactersEvents(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters/%s/events?ts=%s&apikey=%s&hash=%s", Constants.CHARACTERS_ID,
						configuration.getTs(), configuration.getApiKey(), configuration.getHash()))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverInternalServerError(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(500).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverNotFound(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/v1/public/characters?ts=%s&apikey=%s&hash=%s&name=%s", configuration.getTs(),
						configuration.getApiKey(), configuration.getHash(), Constants.CHARACTERS_NAME))
				.willReturn(WireMock.aResponse().withStatus(404).withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

}
