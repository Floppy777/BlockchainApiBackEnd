package com.indo.blockchain.service;

import java.net.URI;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.indo.blockchain.configuration.UrlConfigurator;
import com.indo.blockchain.json.BetJson;
import com.indo.blockchain.json.SmartContractInformationsJson;
import com.indo.blockchain.model.GameSmartContract;
import com.indo.blockchain.repository.IGameSmartContractDao;

@Service
public class GameSmartContractService {

	@Autowired
	private IGameSmartContractDao gameSmartContractDao;
	
	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UrlConfigurator urlConfigurator;
	
	public void save(GameSmartContract gameSmartContract){
		gameSmartContractDao.save(gameSmartContract);
	}
	
	public SmartContractInformationsJson getInformationsFromEthereaumGameSmartContract(String address){
		System.out.println(urlConfigurator.getUrlInformationSmartContract(address));
		ListenableFuture<ResponseEntity<SmartContractInformationsJson>> future = asyncRestTemplate.getForEntity(urlConfigurator.getUrlInformationSmartContract(address),SmartContractInformationsJson.class);
		try {
			ResponseEntity<SmartContractInformationsJson> result = future.get();
			System.out.println(result);
			System.out.println(result.getBody());
			return result.getBody();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	public void betForEthereumGameSmartContract(BetJson betJson, String address){
		URI uri = null;
		switch(betJson.getType()){
			case Number :
				uri = urlConfigurator.getUrlBetNumber(address);
				break;
			case Odd : 
				uri = urlConfigurator.getUrlBetOdd(address);
				break;
			case Even:
				uri = urlConfigurator.getUrlBetEven(address);
				break;
			default:
				uri = urlConfigurator.getUrlBetEven(address);
		}
		System.out.println(uri.toString());
		restTemplate.postForEntity(uri,betJson,BetJson.class);		
	}
	*/
	
	/*
	public void launchEthereumGameSamartContract(String address){
		URI uri = urlConfigurator.getUrlLaunchRoulette(address);
		restTemplate.postForEntity(uri, null, null);
	}*/
}
