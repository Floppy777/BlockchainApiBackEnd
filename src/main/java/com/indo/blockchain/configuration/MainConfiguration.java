package com.indo.blockchain.configuration;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.indo.blockchain.controller","com.indo.blockchain.service","com.indo.blockchain.configuration"})
@EntityScan("com.indo.blockchain.model")
@EnableJpaRepositories("com.indo.blockchain.repository")
@EnableTransactionManagement
public class MainConfiguration {
	
	public static Logger LOGGER = Logger.getLogger(MainConfiguration.class);
    
	public static void main(String[] args) throws Exception {
		  LOGGER.info("Let's Gooooooooo !!");
	      SpringApplication.run(MainConfiguration.class, args);
	}
}