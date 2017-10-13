package com.indo.blockchain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.indo.blockchain.json.PlayerJson;
import com.indo.blockchain.model.Account;
import com.indo.blockchain.model.Role;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.IRoleDao;
import com.indo.blockchain.repository.IUserDao;

@Service
public class UserService {
	
	@Autowired private IUserDao userDao;
	@Autowired private IRoleDao roleDao;
	@Autowired private PasswordEncoder passwordEncoder;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	
	public void createUserPlayer(PlayerJson playerJson ) throws ParseException {
		Account account = new Account();
		account.setUsername(playerJson.getMail());
		account.setPassword(passwordEncoder.encode(playerJson.getPassword()));
		account.setEnabled(true);
		
		Role role = roleDao.findByRole("player");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
	
		User user = new User();
		user.setFirstname(playerJson.getFirstname());
		user.setLastname(playerJson.getLastname());
		user.setMail(playerJson.getMail());
		user.setBirthdate(formatter.parse(playerJson.getBirthdate()));
		user.setCreatedAt(new Date());
		user.setRole(roles);
		user.setAccount(account);
		System.out.println(user);
		userDao.save(user);
	}
	
	public User findByMail(String mail){
		return userDao.findByUsername(mail);
	}
}
