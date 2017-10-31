package com.indo.blockchain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfiguration {

	@Bean
	public Web3j web3j(){
		return Web3j.build(new HttpService());
	}
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
}
	
