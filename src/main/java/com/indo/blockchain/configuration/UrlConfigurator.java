package com.indo.blockchain.configuration;

import java.net.URI;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UrlConfigurator {
	
	private String URL_INFORMATIONS_SMART_CONTRACT = "roulette/getInformations";
	private String URL_CREATE_WALLET = "wallet/create";
	private String URL_CREATE_PROJET = "project/deploy";

	
	private UriComponents uri;
	
	/* TODO Modifier le constructeur pour aller récuprer les variables dans le fichier de configuraton */
	public UrlConfigurator(){
		this.uri = UriComponentsBuilder
		.newInstance()
		.scheme("http")
		.host("localhost")
		.path("api")
		.port(9090)
		.build();
	}
	
	public URI getUrlInformationSmartContract(String address){
		return UriComponentsBuilder
				.newInstance()
				.uriComponents(this.uri)
				.pathSegment(URL_INFORMATIONS_SMART_CONTRACT)
				.pathSegment(address)
				.build().toUri();
	}
	
	public URI getUrlWalletCreation(String password){
		return UriComponentsBuilder
				.newInstance()
				.uriComponents(this.uri)
				.pathSegment(URL_CREATE_WALLET)
				.pathSegment(password)
				.build().toUri();
	}
	
	public URI getUrlProjectCreation(){
		return UriComponentsBuilder
				.newInstance()
				.uriComponents(this.uri)
				.pathSegment(URL_CREATE_PROJET)
				.build().toUri();
	}
}
