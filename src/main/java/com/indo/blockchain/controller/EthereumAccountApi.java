package com.indo.blockchain.controller;

import java.io.File;

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
import com.indo.blockchain.json.EthereumAccountCreationJson;
import com.indo.blockchain.model.EthereumAccount;
import com.indo.blockchain.model.User;
import com.indo.blockchain.service.AuthenticationService;
import com.indo.blockchain.service.EthereumAccountService;

@RestController
@RequestMapping(value = "/ethereum/account")
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
	@RequestMapping(value = "/create", method = RequestMethod.POST)
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
