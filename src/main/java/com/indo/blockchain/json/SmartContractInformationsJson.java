package com.indo.blockchain.json;

public class SmartContractInformationsJson {

	private Integer nbPendingBet;
	
	private Integer minimumBet;
	
	private Integer maxTotalBet;

	public Integer getNbPendingBet() {
		return nbPendingBet;
	}

	public void setNbPendingBet(Integer nbPendingBet) {
		this.nbPendingBet = nbPendingBet;
	}

	public Integer getMinimumBet() {
		return minimumBet;
	}

	public void setMinimumBet(Integer minimumBet) {
		this.minimumBet = minimumBet;
	}

	public Integer getMaxTotalBet() {
		return maxTotalBet;
	}

	public void setMaxTotalBet(Integer maxTotalBet) {
		this.maxTotalBet = maxTotalBet;
	}

	@Override
	public String toString() {
		return "SmartContractInformationsJson [nbPendingBet=" + nbPendingBet + ", minimumBet=" + minimumBet
				+ ", maxTotalBet=" + maxTotalBet + "]";
	}
}
