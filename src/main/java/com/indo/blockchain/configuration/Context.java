package com.indo.blockchain.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("infra")
public class Context {
	
	private String smtpUrl;
	private String blockchainUrl;
	private Integer blockchainPort;
	private String keystoreDirectory;
	private String blockchainGasPrice;
	private String blockchainGasLimit;
	
	public String getSmtpUrl() {
		return smtpUrl;
	}
	
	public void setSmtpUrl(String smtpUrl) {
		this.smtpUrl = smtpUrl;
	}
	
	public String getBlockchainUrl() {
		return blockchainUrl;
	}
	
	public void setBlockchainUrl(String blockchainUrl) {
		this.blockchainUrl = blockchainUrl;
	}
	
	public Integer getBlockchainPort() {
		return blockchainPort;
	}
	
	public void setBlockchainPort(Integer blockchainPort) {
		this.blockchainPort = blockchainPort;
	}
	
	public String getKeystoreDirectory() {
		return keystoreDirectory;
	}
	
	public void setKeystoreDirectory(String keystoreDirectory) {
		this.keystoreDirectory = keystoreDirectory;
	}
	
	public String getBlockchainGasPrice() {
		return blockchainGasPrice;
	}

	public void setBlockchainGasPrice(String blockchainGasPrice) {
		this.blockchainGasPrice = blockchainGasPrice;
	}

	public String getBlockchainGasLimit() {
		return blockchainGasLimit;
	}

	public void setBlockchainGasLimit(String blockchainGasLimit) {
		this.blockchainGasLimit = blockchainGasLimit;
	}

	@Override
	public String toString() {
		return "Context [smtpUrl=" + smtpUrl + ", blockchainUrl=" + blockchainUrl + ", blockchainPort=" + blockchainPort
				+ ", keystoreDirectory=" + keystoreDirectory + "]";
	}
}
