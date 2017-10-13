package com.indo.blockchain.service;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.indo.blockchain.configuration.Context;
import com.indo.blockchain.configuration.UrlConfigurator;
import com.indo.blockchain.json.WalletContainerJson;
import com.indo.blockchain.json.WalletJson;
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
	private RestTemplate restTemplate;
	
	@Autowired
	private UrlConfigurator urlConfigurator;
	
	@Autowired
	private Context context;
		
	public void createEthereumAccount(User user,String walletPassword,String passwordConfirm) throws IOException{
		if(!walletPassword.equals(passwordConfirm)){
			System.out.println("Les mots de passe ne correspondent pas");
			return;
		}
		System.out.println(urlConfigurator.getUrlWalletCreation(walletPassword));
		// Envoyer une requete au serveur node pour la création du wallet
		WalletContainerJson walletContainerJson = restTemplate.postForObject(urlConfigurator.getUrlWalletCreation(walletPassword), null, WalletContainerJson.class);
		System.out.println(walletContainerJson.getWalletJson());
		System.out.println(walletContainerJson.getUtcFile());
		
		// Persister le wallet dans la base de données
		EthereumAccount ethereumAccount = new EthereumAccount();
		ethereumAccount.setEthereumAddress("0x" + walletContainerJson.getWalletJson().getAddress());
		ethereumAccount.setPassword(walletPassword);
		ethereumAccount.setCreatedAt(new Date());
		ethereumAccount.setWallet(walletContainerJson.getWalletJson());
		ethereumAccount.setFile(walletContainerJson.getUtcFile());
		ethereumAccount.setPrivateKey(walletContainerJson.getPrivateKey());
		ethereumAccountRepository.save(ethereumAccount);
		
		user.setEthereumAccount(ethereumAccount);
		userDao.save(user);		
	}
	
	public EthereumAccount getEthereumAccountById(Integer id){
		return ethereumAccountRepository.findOne(id);
	}

}