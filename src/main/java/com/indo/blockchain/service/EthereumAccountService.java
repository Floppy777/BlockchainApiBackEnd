package com.indo.blockchain.service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indo.blockchain.configuration.Context;
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
	private Context context;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EthereumAccountService.class);
		
	public void createEthereumAccount(User user,String walletPassword,String passwordConfirm) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException {
		if(!walletPassword.equals(passwordConfirm)){
			System.out.println("Les mots de passe ne correspondent pas");
			return;
		}

		String keystoreDirectory = context.getKeystoreDirectory();
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
	
	public EthereumAccount getEthereumAccountById(Integer id){
		return ethereumAccountRepository.findOne(id);
	}

}