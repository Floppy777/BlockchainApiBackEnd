package com.indo.blockchain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="game_smart_contract")
public class GameSmartContract {

	@Id
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="type",referencedColumnName="id")
	private GameType gameType;
	
	@Column(name="address")
	private String address;
	
	@OneToOne
	@JoinColumn(name="deployed_by",referencedColumnName="id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
