package io.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import io.swagger.configuration.ClientConfiguration;

@FeignClient(contextId = "DefaultApiClient", name = "${marvelPublicAPIV1.name:marvelPublicAPIV1}", url = "${marvelPublicAPIV1.url:http://gateway.marvel.com/v1/public}", configuration = ClientConfiguration.class)
public interface DefaultApiClient extends DefaultApi {
	
}
