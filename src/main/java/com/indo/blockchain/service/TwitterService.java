package com.indo.blockchain.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;

public class TwitterService {

	@Autowired
	private Twitter twitter;
	
	private final static Logger LOGGER = Logger.getLogger(TwitterService.class);
	
	public void use(){
		LOGGER.info("Twitter " + twitter);
	}
}
