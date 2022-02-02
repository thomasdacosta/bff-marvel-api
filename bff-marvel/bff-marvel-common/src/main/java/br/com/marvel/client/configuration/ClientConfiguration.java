package br.com.marvel.client.configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Client;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {
	
	@Value("${proxy.host}")
	private String proxyHost;
	
	@Value("${proxy.port}")
	private Integer proxyPort;

	@Bean
	@ConditionalOnProperty(value = "proxy.enabled", havingValue = "true", matchIfMissing = false)
	public Client feignClient() {
		return new Client.Proxied(null, null, 
				new Proxy(Proxy.Type.HTTP, 
						new InetSocketAddress(proxyHost, proxyPort)));
	}

}
