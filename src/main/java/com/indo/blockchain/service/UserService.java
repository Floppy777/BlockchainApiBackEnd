package com.indo.blockchain.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.indo.blockchain.exception.BeneficiaryJson;
import com.indo.blockchain.model.Account;
import com.indo.blockchain.model.Role;
import com.indo.blockchain.model.Status;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.IRoleDao;
import com.indo.blockchain.repository.IStatusDao;
import com.indo.blockchain.repository.IUserDao;

@Service
public class UserService {
	
	@Autowired private IUserDao userDao;
	@Autowired private IRoleDao roleDao;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private IStatusDao statusDao;
	@Autowired private MailService mailService;
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	//private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	
	public void createUserPlayer(BeneficiaryJson beneficiaryJson ) throws ParseException, MessagingException {
		Status status = statusDao.findOne(1);
		LOGGER.info("Status = " + status);
		
		Account account = new Account();
		account.setUsername(beneficiaryJson.getMail());
		account.setPassword(passwordEncoder.encode(beneficiaryJson.getPassword()));
		account.setStatus(status);
		LOGGER.info("Account = " + account);
		
		Role role = roleDao.findByRole("player");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
	
		User user = new User();
		user.setFirstname(beneficiaryJson.getFirstname());
		user.setLastname(beneficiaryJson.getLastname());
		user.setMail(beneficiaryJson.getMail());
		user.setCellphoneNumber(beneficiaryJson.getCellphoneNumber());
		user.setCreatedAt(new Date());
		user.setRole(roles);
		user.setAccount(account);
		LOGGER.info("User = " + user);
		//userDao.save(user);
		mailService.sendMailCreateUser(beneficiaryJson);
	}
	
	public User findByMail(String mail){
		return userDao.findByUsername(mail);
	}
}
