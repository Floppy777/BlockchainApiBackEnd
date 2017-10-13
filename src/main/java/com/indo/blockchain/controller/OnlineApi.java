package com.indo.blockchain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/connection")
public class OnlineApi {
	
	@RequestMapping(value="/isUp",method=RequestMethod.GET)
	public String isUp(){
		return "Hello World";
	}
}
