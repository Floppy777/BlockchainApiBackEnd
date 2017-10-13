package com.indo.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.model.Account;
import com.indo.blockchain.repository.IAccountDao;

@RestController
@RequestMapping(value="/account")
public class AccountApi {

	@Autowired
	IAccountDao accountRepository;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable("id") int id) {
		return accountRepository.findOne(id);
	}
	
	@RequestMapping(value ="/username/{username}",method=RequestMethod.GET)
	public Account getAccountByUsername(@PathVariable("username") String username){
		return accountRepository.findByUsername(username);
	}
}
