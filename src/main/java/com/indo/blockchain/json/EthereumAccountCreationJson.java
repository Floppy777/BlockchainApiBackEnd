package com.indo.blockchain.json;

public class EthereumAccountCreationJson {
	
	private String password;
	
	private String passwordConfirm;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm(){
		return passwordConfirm;
	}
	
	public void setPasswordConform(String passwordConfirm){
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public String toString() {
		return "EthereumAccountCreationJson [password=" + password + ", passwordConfirm=" + passwordConfirm + "]";
	}
}
