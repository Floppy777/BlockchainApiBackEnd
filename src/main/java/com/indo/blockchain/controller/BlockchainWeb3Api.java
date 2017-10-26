package com.indo.blockchain.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;

import com.indo.blockchain.json.BlockchainInformationsJson;

@RestController
@RequestMapping("/blockchain")
public class BlockchainWeb3Api {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlockchainWeb3Api.class);
	
	@Autowired
	private Web3j web3;

	@RequestMapping(value="/informations",method=RequestMethod.GET)
	public ResponseEntity<BlockchainInformationsJson> getInformations() throws IOException{
		
		LOGGER.info("Web 3 Informations : " + web3);
		LOGGER.info("Web 3 Client Version : " + web3.web3ClientVersion().send().getWeb3ClientVersion());
		LOGGER.info("Web 3 NET Version : " + web3.netVersion().send().getNetVersion());
		LOGGER.info("Web 3 Nombre d'account : " + web3.ethAccounts().send().getAccounts().size());
		LOGGER.info("Web 3 BlockNumber : " + web3.ethBlockNumber().send().getBlockNumber().intValue());
		LOGGER.info("Web 3 : Listening ?" + web3.netListening().send().isListening());
		LOGGER.info("Web 3 GAS PRICE : " + web3.ethGasPrice().send().getGasPrice());
		LOGGER.info("Web 3 Protocol Version" + web3.ethProtocolVersion().send().getProtocolVersion());
		LOGGER.info("Web 3 " + web3.ethCoinbase().send().getAddress());
		LOGGER.info("Web3 " + web3.netPeerCount().send().getQuantity().intValue());
		LOGGER.info("Is Sync ? " + web3.ethSyncing().send().isSyncing());
		
		BlockchainInformationsJson json = new BlockchainInformationsJson();
		json.setClientVersion(web3.web3ClientVersion().send().getWeb3ClientVersion());
		json.setNetVersion(web3.netVersion().send().getNetVersion());
		json.setProtocolVersion(web3.ethProtocolVersion().send().getProtocolVersion());
		json.setIsListening(web3.netListening().send().isListening());
		json.setNbAccountManaged(web3.ethAccounts().send().getAccounts().size());
		json.setBlockNumber(web3.ethBlockNumber().send().getBlockNumber().intValue());
		json.setIsSync(web3.ethSyncing().send().isSyncing());
		
		return new ResponseEntity<BlockchainInformationsJson>(json,HttpStatus.OK);
	}
}
