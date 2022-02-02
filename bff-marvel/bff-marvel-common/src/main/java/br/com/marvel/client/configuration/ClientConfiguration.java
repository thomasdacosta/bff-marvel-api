package br.com.marvel.client.configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Client;
import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {
	
	@Value("${proxy.host}")
	@Getter @Setter
	private String proxyHost;
	
	@Value("${proxy.port}")
	@Getter @Setter
	private Integer proxyPort;

	@Value("${ts}")
	@Getter @Setter
	private String ts;

	@Value("${apiKey}")
	@Getter @Setter
	private String apiKey;

	@Value("${hash}")
	@Getter @Setter
	private String hash;

	@Bean
	@ConditionalOnProperty(value = "proxy.enabled", havingValue = "true", matchIfMissing = false)
	public Client feignClient() {
		return new Client.Proxied(null, null, 
				new Proxy(Proxy.Type.HTTP, 
						new InetSocketAddress(proxyHost, proxyPort)));
	}

}
