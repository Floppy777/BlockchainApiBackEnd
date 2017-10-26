package com.indo.blockchain.json;

public class BlockchainInformationsJson {

	private String clientVersion;
	private String netVersion;
	private String protocolVersion;
	private Boolean isListening;
	private Integer nbAccountManaged;
	private Integer blockNumber;
	private Boolean isSync;
	
	public String getClientVersion() {
		return clientVersion;
	}
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
	public String getNetVersion() {
		return netVersion;
	}
	public void setNetVersion(String netVersion) {
		this.netVersion = netVersion;
	}
	public String getProtocolVersion() {
		return protocolVersion;
	}
	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	public Boolean getIsListening() {
		return isListening;
	}
	public void setIsListening(Boolean isListening) {
		this.isListening = isListening;
	}
	public Integer getNbAccountManaged() {
		return nbAccountManaged;
	}
	public void setNbAccountManaged(Integer nbAccountManaged) {
		this.nbAccountManaged = nbAccountManaged;
	}
	public Integer getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(Integer blockNumber) {
		this.blockNumber = blockNumber;
	}
	public Boolean getIsSync() {
		return isSync;
	}
	public void setIsSync(Boolean isSync) {
		this.isSync = isSync;
	}
}
