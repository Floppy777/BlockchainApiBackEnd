package com.indo.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.model.Country;
import com.indo.blockchain.repository.ICountryDao;

@RestController
@RequestMapping(value="/country")
public class CountryApi {
	
	@Autowired
	private ICountryDao countryDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCountry(){
		List<Country> countryList = countryDao.findAll();
		return new ResponseEntity<List<Country>>(countryList,HttpStatus.OK);
	}
}
 