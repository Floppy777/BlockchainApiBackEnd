package com.indo.blockchain.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.exception.BeneficiaryJson;
import com.indo.blockchain.model.User;
import com.indo.blockchain.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserApi {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}
	
	@RequestMapping(value="/current",method = RequestMethod.GET)
	public User  getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return userService.findByMail(name);
	}

	@RequestMapping(value = "/player/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createUserPlayer(@RequestBody BeneficiaryJson beneficiaryJson) {
		System.out.println(beneficiaryJson);
		try {
			userService.createUserPlayer(beneficiaryJson);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
