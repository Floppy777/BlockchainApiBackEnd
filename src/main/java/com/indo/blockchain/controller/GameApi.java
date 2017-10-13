package com.indo.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.json.BetJson;
import com.indo.blockchain.json.SmartContractInformationsJson;
import com.indo.blockchain.model.GameSmartContract;
import com.indo.blockchain.model.GameType;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.IGameSmartContractDao;
import com.indo.blockchain.repository.IGameTypeDao;
import com.indo.blockchain.service.AuthenticationService;
import com.indo.blockchain.service.GameSmartContractService;

@RestController
@RequestMapping(value = "/game")
public class GameApi {

	@Autowired private IGameTypeDao gameTypeDao;
	
	@Autowired private IGameSmartContractDao gameSmartContractDao;
	
	@Autowired private GameSmartContractService gameSmartContractService;
	
	@Autowired private AuthenticationService authService;
		
	@RequestMapping(value = "/type/getAll", method = RequestMethod.GET)
	public List<GameType> getAllGameType() {
		return gameTypeDao.findAll();
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<GameSmartContract>> getAllGameSmartContract() {
		List<GameSmartContract> listGameSmartContract = gameSmartContractDao.findAll();
		return new ResponseEntity<List<GameSmartContract>>(listGameSmartContract,HttpStatus.OK);
	}
	
	@RequestMapping(value="/id/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<GameSmartContract>> getAllGameSmartContracByType(@PathVariable("id") Integer idType){
		List<GameSmartContract> listGameSmartContract =  gameSmartContractDao.getGameSmartContractByType(idType);
		return new ResponseEntity<List<GameSmartContract>>(listGameSmartContract,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param address
	 * Cette méthode interragit avec la blockchain : call
	 */
	@RequestMapping(value="/informations/{address}",method = RequestMethod.GET)
	public ResponseEntity<SmartContractInformationsJson> getInformationsFromRouletteGame(@PathVariable("address")String address){
		SmartContractInformationsJson json =  gameSmartContractService.getInformationsFromEthereaumGameSmartContract(address);
		return new ResponseEntity<SmartContractInformationsJson>(json,HttpStatus.OK);
	}
	
	/**
	 * Cette methode interragit avec la blockchain : sendTransaction
	 * @param address
	 */
	@RequestMapping(value="/bet/{address}",method = RequestMethod.POST)
	public ResponseEntity<Void> betOnRouletteGame(@PathVariable("address") String address,@RequestBody BetJson betJson){
		System.out.println(betJson);
		//gameSmartContractService.betForEthereumGameSmartContract(betJson, address);
	    return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param address
	 */
	@RequestMapping(value="launch/{address}",method = RequestMethod.POST)
	public ResponseEntity<Void> launchRouletteGame(@PathVariable("address") String adddress){
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/**
	 * Test
	 */
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseEntity<Void> test(){
		User user = authService.currentUserAuthenticated();
		System.out.println(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
