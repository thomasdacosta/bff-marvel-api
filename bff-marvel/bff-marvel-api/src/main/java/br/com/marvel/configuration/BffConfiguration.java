package br.com.marvel.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
public class BffConfiguration {
	
	@Value("${ts}")
	@Getter @Setter
	private String ts;
	
	@Value("${apiKey}")
	@Getter @Setter
	private String apiKey;	
	
	@Value("${hash}")
	@Getter @Setter
	private String hash;

}
