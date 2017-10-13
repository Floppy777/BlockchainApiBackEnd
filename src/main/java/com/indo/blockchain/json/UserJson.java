package com.indo.blockchain.json;

import java.util.Set;

import com.indo.blockchain.model.Role;
import com.indo.blockchain.model.User;

public class UserJson {

	private String username;
	
	private String firstname;
	
	private String lastname;
	
	private String token;
	
	private Set<Role> role;

	public UserJson(User user,String token){
		this.username = user.getMail();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.token = token;
		this.role = user.getRole();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
