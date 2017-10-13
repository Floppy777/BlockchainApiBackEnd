package com.indo.blockchain.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class DispatcherContext extends WebMvcConfigurationSupport {
	
	@Bean
	public CurrentUserWebArgumentResolver currentUserMethodArgumentResolver() {
	    return new CurrentUserWebArgumentResolver();
	}
	
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrentUserWebArgumentResolver());
    }
}