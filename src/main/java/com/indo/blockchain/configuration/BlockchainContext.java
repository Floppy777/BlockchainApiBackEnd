package com.indo.blockchain.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("blockchain")
public class BlockchainContext {
	
	private Account account = new Account();
	private Gas gas = new Gas();
	private String keystoreDirectory;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Gas getGas() {
		return gas;
	}

	public void setGas(Gas gas) {
		this.gas = gas;
	}
	
	public String getKeystoreDirectory(){
		return keystoreDirectory;
	}
	
	public void setKeystoreDirectory(String keystoreDirectory){
		this.keystoreDirectory = keystoreDirectory;
	}

	public static class Account {
		
		public String address;
		public String password;
		
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
	}

	public static class Gas {
		
		public String price;
		public String limit;
		
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getLimit() {
			return limit;
		}
		public void setLimit(String limit) {
			this.limit = limit;
		}	
	}

}
