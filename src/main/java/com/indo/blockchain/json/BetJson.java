package com.indo.blockchain.json;

import com.indo.blockchain.enums.BetType;

public class BetJson {

	private Integer number;
	
	private Integer amount;
	
	private BetType type;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getAmount(){
		return amount;
	}
	
	public void setAmount(Integer amount){
		this.amount = amount;
	}

	public BetType getType() {
		return type;
	}

	public void setType(BetType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BetJson [number=" + number + ", amount=" + amount + ", type=" + type + "]";
	}
}
