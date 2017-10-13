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

	@Override
	public String toString() {
		return "Context [smtpUrl=" + smtpUrl + ", blockchainUrl=" + blockchainUrl + ", blockchainPort=" + blockchainPort
				+ ", keystoreDirectory=" + keystoreDirectory + "]";
	}
}
