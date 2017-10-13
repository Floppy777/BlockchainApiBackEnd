package com.indo.blockchain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game_type")
public class GameType {

	@Id
	@Column(name="id")
	public Integer id;
	
	@Column(name="libelle")
	public String libelle;
	
	private GameType(){}

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
}
