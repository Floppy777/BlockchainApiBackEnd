package com.indo.blockchain.exception;

public class BeneficiaryJson {

	private String mail;

	private String password;

	private String passwordConfirm;

	private String lastname;

	private String firstname;

	//private String birthdate;
	
	private String cellphoneNumber;

	public BeneficiaryJson() {
	}

	public BeneficiaryJson(String mail, String password, String passwordConfirm, String lastname, String firstname, String cellphoneNumber) {
		this.mail = mail;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.lastname = lastname;
		this.firstname = firstname;
		//this.birthdate = date;
		this.cellphoneNumber = cellphoneNumber;
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

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
}
