package com.indo.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.model.Categorie;
import com.indo.blockchain.repository.ICategorieDao;

@RestController
@RequestMapping(value="/categorie")
public class CategorieApi {
	
	@Autowired
	private ICategorieDao categorieDao;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Categorie>> getAllCategorie() {
		List<Categorie> categories =categorieDao.findAll();
		if(categories.isEmpty()){
			return new ResponseEntity<List<Categorie>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Categorie>>(categorieDao.findAll(),HttpStatus.OK);
	}
}
