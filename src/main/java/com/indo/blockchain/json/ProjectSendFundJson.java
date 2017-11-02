package com.indo.blockchain.json;

public class ProjectSendFundJson {

	private String address;
	private String password;
	private Float montant;
	private String file;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Float getMontant() {
		return montant;
	}
	
	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
