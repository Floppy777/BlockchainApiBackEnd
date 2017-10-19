package com.indo.blockchain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.indo.blockchain.json.WalletJson;

@Entity
@Table(name="ethereum_account")
public class EthereumAccount {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ethereum_address")
	private String ethereumAddress;
	
	@Column(name="password")
	private String password;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="file")
	private String file;
	
	/*
	@Column(name="wallet")
	private WalletJson wallet;
	*/
	/*
	@Column(name="private_key")
	private String privateKey;
	*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEthereumAddress() {
		return ethereumAddress;
	}

	public void setEthereumAddress(String ethereumAddress) {
		this.ethereumAddress = ethereumAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
