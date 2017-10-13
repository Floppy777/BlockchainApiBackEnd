package com.indo.blockchain.json;

public class WalletContainerJson {

	private String utcFile;
	private WalletJson walletJson;
	private String privateKey;
	
	public String getUtcFile() {
		return utcFile;
	}
	public void setUtcFile(String utcFile) {
		this.utcFile = utcFile;
	}
	public WalletJson getWalletJson() {
		return walletJson;
	}
	public void setWalletJson(WalletJson walletJson) {
		this.walletJson = walletJson;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
}
