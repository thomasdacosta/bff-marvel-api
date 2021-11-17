package br.com.marvel.client;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.marvel.configuration.ClientConfiguration;

@FeignClient(contextId = "DefaultApiClient", name = "${marvelPublicAPIV1.name:marvelPublicAPIV1}", url = "${marvelPublicAPIV1.url:http://gateway.marvel.com/v1/public}", configuration = ClientConfiguration.class)
public interface DefaultApiClient extends DefaultApi {
	
}
