package com.indo.blockchain.json;

public class AddressInfoJson {

	private String balance;
	private Integer transactionCount;
	
	public AddressInfoJson(String balance, Integer transactionCount) {
		this.balance = balance;
		this.transactionCount = transactionCount;
	}
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public Integer getTransactionCount() {
		return transactionCount;
	}
	public void setTransactionCount(Integer transactionCount) {
		this.transactionCount = transactionCount;
	}
	
	
}
