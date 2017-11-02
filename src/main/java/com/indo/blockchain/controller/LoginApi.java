package com.indo.blockchain.controller;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.json.LoginCredentialJson;
import com.indo.blockchain.json.UserJson;
import com.indo.blockchain.model.Account;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.IAccountDao;
import com.indo.blockchain.repository.IUserDao;

@RestController
@RequestMapping(value="/login")
public class LoginApi {
		
	@Autowired
	private IAccountDao accountRepository;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ResponseBody
	@RequestMapping(value="/authentication",method=RequestMethod.POST)
	public ResponseEntity<UserJson> login(@RequestBody LoginCredentialJson loginCredentialJson){
		String username = loginCredentialJson.getUsername();
		Account account = accountRepository.findByUsername(username);
		if(account == null){
			System.out.println("Impossible de récupérer le compte depuis la base de données");
			return new ResponseEntity<UserJson>(HttpStatus.UNAUTHORIZED);
		}
		if(!passwordEncoder.matches(loginCredentialJson.getPassword(),account.getPassword())){
			System.out.println("Le mot de passe de : " + account.getUsername() + " est incorrect") ;
			return new ResponseEntity<UserJson>(HttpStatus.UNAUTHORIZED);
		}
		String base64EncodedPassword = Base64.getEncoder().encodeToString((loginCredentialJson.getUsername()+":"+loginCredentialJson.getPassword()).getBytes());
		User user = userDao.findByUsername(username);
		if(user.getAccount().getStatus().getId() == 1){
			System.out.println("Le compte n'est pas vérifié");
			return new ResponseEntity<UserJson>(HttpStatus.UNAUTHORIZED);
		}
		if(user.getAccount().getStatus().getId() == 3){
			System.out.println("Le compte est suspendu");
			return new ResponseEntity<UserJson>(HttpStatus.UNAUTHORIZED);
		}
		if(user.getAccount().getStatus().getId() == 4){
			System.out.println("Le compte est bloqué");
			return new ResponseEntity<UserJson>(HttpStatus.UNAUTHORIZED);
		}
		UserJson userJson = new UserJson(user,base64EncodedPassword);
		return new ResponseEntity<UserJson>(userJson, HttpStatus.OK);
	}
}
