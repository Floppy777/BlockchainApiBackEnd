package com.indo.blockchain.json;

public class ProjectJson {

	private String name;
	
	private String description;
	
	private Integer montant;
	
	private Integer duration;
	
	private Integer categorie;	
	
	private Integer country;

	public Integer getCategorie() {
		return categorie;
	}

	public void setCategorie(Integer categorie) {
		this.categorie = categorie;
	}
	
	public Integer getCountry(){
		return country;
	}
	
	public void setCountry(Integer country){
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
