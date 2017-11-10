package com.indo.blockchain.service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indo.blockchain.configuration.BlockchainContext;
import com.indo.blockchain.json.AddressInfoJson;
import com.indo.blockchain.json.CryptoInfoJson;
import com.indo.blockchain.json.TransactionInfoJson;
import com.indo.blockchain.model.EthereumAccount;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.IEthereumAccountRepository;
import com.indo.blockchain.repository.IUserDao;

@Service
public class EthereumAccountService {
	
	@Autowired
	private IEthereumAccountRepository ethereumAccountRepository;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private BlockchainContext blockchainContext;
	
	@Autowired
	private Web3j web3;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EthereumAccountService.class);
		
	public void createEthereumAccount(User user,String walletPassword,String passwordConfirm) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException {
		if(!walletPassword.equals(passwordConfirm)){
			System.out.println("Les mots de passe ne correspondent pas");
			return;
		}

		String keystoreDirectory = blockchainContext.getKeystoreDirectory();
		String test = WalletUtils.generateFullNewWalletFile(walletPassword,new File(keystoreDirectory));
		LOGGER.info("LOG : " + keystoreDirectory+"/"+test);
		
		ObjectMapper mapper = new ObjectMapper();
		WalletFile wallet = mapper.readValue(new File(keystoreDirectory+"/"+test), WalletFile.class);
		ECKeyPair keyPair= Wallet.decrypt(walletPassword, wallet);
		LOGGER.info("Private key : " + keyPair.getPrivateKey());
		LOGGER.info("Public key : " + keyPair.getPublicKey());
		LOGGER.info("Addresse : " + wallet.getAddress());
		LOGGER.info("Wallet Json : " + wallet);
		
		EthereumAccount ethereumAccount = new EthereumAccount();
		ethereumAccount.setEthereumAddress("0x" + wallet.getAddress());
		ethereumAccount.setPassword(walletPassword);
		ethereumAccount.setCreatedAt(new Date());
		ethereumAccount.setFile(keystoreDirectory + "/" + test);
		ethereumAccountRepository.save(ethereumAccount);
		
		user.setEthereumAccount(ethereumAccount);
		userDao.save(user);	
	}
	
	/*
	 * Make a request to api.coinmarketcap to get Ethereum Informations
	 */
	public CryptoInfoJson getCryptoInformations(){
		CryptoInfoJson[] c = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/ethereum/?convert=EUR", CryptoInfoJson[].class);
		return c[0];
	}
	
	
	/*
	 * 
	 */
	public AddressInfoJson getEthereumAdressInformations(String address) throws IOException{
		BigInteger ethGetBalance = web3
				  .ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance();
		Integer transactionCount = web3.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).send().getTransactionCount().intValue();
		String value = Convert.fromWei(ethGetBalance.toString(), Unit.ETHER).toString();
	
		return new AddressInfoJson(value,transactionCount);
	}
	
	public TransactionInfoJson getEthereumTransactionInformations(String hash) throws IOException {
	    TransactionReceipt tReceipt = web3.ethGetTransactionReceipt(hash).send().getResult();
	    Transaction transaction = web3.ethGetTransactionByHash(hash).send().getResult();
	    
		TransactionInfoJson t = new TransactionInfoJson();
		t.setFrom(transaction.getFrom());
		t.setTo(transaction.getTo());
		t.setValue(transaction.getValue().toString());
		t.setBlockNumber(transaction.getBlockNumber().toString());
		t.setGasLimit(transaction.getGas().toString());
		t.setGasPrice(transaction.getGasPrice().toString());
		t.setBlockHash(transaction.getBlockHash());
		t.setGasUsed(tReceipt.getGasUsed().toString());
		return t;
	}
	
	public EthereumAccount getEthereumAccountById(Integer id){
		return ethereumAccountRepository.findOne(id);
	}

}