package com.indo.blockchain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Configuration
public class BeanConfiguration {

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate template  = new RestTemplate();
		return template;
	}
	
	@Bean
	public UrlConfigurator urlConfigurator(){
		UrlConfigurator urlConfigurator = new UrlConfigurator();
		return urlConfigurator;
	}
	
	@Bean
    public AsyncRestTemplate asyncRestTemplate() {
        return new AsyncRestTemplate();
    }
}
	
