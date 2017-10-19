package com.indo.blockchain.exception;

public class BeneficiaryJson {

	private String mail;

	private String password;

	private String passwordConfirm;

	private String lastname;

	private String firstname;

	private String birthdate;

	public BeneficiaryJson() {
	}

	public BeneficiaryJson(String mail, String password, String passwordConfirm, String lastname, String firstname,
			String date) {
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
}
