package com.indo.blockchain.json;

import java.text.ParseException;

public class PlayerJson {

	private String mail;
	
	private String password;
	
	private String passwordConfirm;
	
	private String lastname;
	
	private String firstname;
	
	private String birthdate;
	
    
    public PlayerJson() {}

	
	public PlayerJson(String mail, String password, String passwordConfirm, String lastname, String firstname, String date) throws ParseException{
		this.mail = mail;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthdate = date; 
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String brithdate) {
		this.birthdate = brithdate;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public String toString() {
		return "PlayerJson [mail=" + mail + ", password=" + password + ", confirmPassword=" + passwordConfirm
				+ ", lastname=" + lastname + ", firstname=" + firstname + ", birthdate=" + birthdate + "]";
	}
}
