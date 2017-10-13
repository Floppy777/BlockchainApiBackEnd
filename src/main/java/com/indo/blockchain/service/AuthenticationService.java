package com.indo.blockchain.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indo.blockchain.model.Account;
import com.indo.blockchain.repository.IAccountDao;
import com.indo.blockchain.repository.IUserDao;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private IAccountDao accountDao;
	
	@Autowired
	private IUserDao userDao;
	
	public AuthenticationService(){
		super();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account currentAccount = accountDao.findByUsername(username);
		if(currentAccount == null){
			throw new UsernameNotFoundException("On trouve pas le copek " + username);
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		UserDetails userDetails = (UserDetails)new User(currentAccount.getUsername(), 
				currentAccount.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
	
	public com.indo.blockchain.model.User currentUserAuthenticated(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    return userDao.findByUsername(name);  
	}
}
