package com.springboot.microservices.baskets.basketservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean("restClient")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
