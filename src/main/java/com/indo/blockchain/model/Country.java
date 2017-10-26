package com.indo.blockchain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class Country {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="code")
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", libelle=" + libelle + ", code=" + code + "]";
	}
}
