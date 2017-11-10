package com.indo.blockchain.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.WalletFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indo.blockchain.json.AddressInfoJson;
import com.indo.blockchain.json.CryptoInfoJson;
import com.indo.blockchain.json.EthereumAccountCreationJson;
import com.indo.blockchain.json.TransactionInfoJson;
import com.indo.blockchain.model.EthereumAccount;
import com.indo.blockchain.model.User;
import com.indo.blockchain.service.AuthenticationService;
import com.indo.blockchain.service.EthereumAccountService;

@RestController
@RequestMapping(value = "/ethereum")
public class EthereumAccountApi {

	@Autowired
	private EthereumAccountService ethereumAccountService;

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public EthereumAccount getEthereumAccount(@PathVariable("id") Integer id) {
		return ethereumAccountService.getEthereumAccountById(id);
	}

	/**
	 * Permet de génerer un wallet eth
	 */
	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createEthereumAccount(
			@RequestBody EthereumAccountCreationJson ethereumAccountCreationJson) {
		User user = authenticationService.currentUserAuthenticated();
		try {
			ethereumAccountService.createEthereumAccount(user, ethereumAccountCreationJson.getPassword(),
					ethereumAccountCreationJson.getPasswordConfirm());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/**
	 * Récupere des informations sur les cryptos
	 */
	@RequestMapping(value="/info", method = RequestMethod.GET)
	public ResponseEntity<CryptoInfoJson> getCryptoInformations(){
		CryptoInfoJson cryptoInfoJson = ethereumAccountService.getCryptoInformations();
		return new ResponseEntity<CryptoInfoJson>(cryptoInfoJson,HttpStatus.OK);
	}
	
	@RequestMapping(value="/info/address/{address}",method = RequestMethod.GET)
	public ResponseEntity<AddressInfoJson> getPublicAdressInformations(@PathVariable("address") String address){
		try {
			AddressInfoJson addressInfoJson = ethereumAccountService.getEthereumAdressInformations(address);
			return new ResponseEntity<AddressInfoJson>(addressInfoJson,HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<AddressInfoJson>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/info/tx/{hash}",method = RequestMethod.GET)
	public ResponseEntity<TransactionInfoJson> getTransactionInformations(@PathVariable("hash") String hash){
		try {
			TransactionInfoJson t = ethereumAccountService.getEthereumTransactionInformations(hash);
			return new ResponseEntity<TransactionInfoJson>(t,HttpStatus.OK);
		} catch (IOException e ){
			e.printStackTrace();
			return new ResponseEntity<TransactionInfoJson>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Permet de télécharger son wallet au format Json
	 */

	@RequestMapping(value = "/wallet/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getWalletJson() throws Exception{
		User user = authenticationService.currentUserAuthenticated();
		ObjectMapper mapper = new ObjectMapper();
		WalletFile wallet = mapper.readValue(new File(user.getEthereumAccount().getFile()), WalletFile.class);

		byte[] output = wallet.toString().getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("charset", "utf-8");
		responseHeaders.setContentType(MediaType.valueOf("text/html"));
		responseHeaders.setContentLength(output.length);
		responseHeaders.set("Content-disposition", "attachment; filename=key.json");
		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);

	}

}
