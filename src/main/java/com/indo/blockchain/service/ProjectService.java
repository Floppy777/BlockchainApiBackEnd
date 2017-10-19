package com.indo.blockchain.service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indo.blockchain.configuration.Context;
import com.indo.blockchain.ethereum.ProjectSmartContract;
import com.indo.blockchain.json.ProjectJson;
import com.indo.blockchain.model.Categorie;
import com.indo.blockchain.model.Country;
import com.indo.blockchain.model.EthereumAccount;
import com.indo.blockchain.model.Project;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.ICategorieDao;
import com.indo.blockchain.repository.ICountryDao;
import com.indo.blockchain.repository.IProjectDao;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class ProjectService {

	@Autowired
	private IProjectDao projectDao;

	@Autowired
	private ICategorieDao categorieDao;

	@Autowired
	private ICountryDao countryDao;

	@Autowired
	private Context context;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private Web3j web3;
	
	public void registerProject(ProjectJson projectJson,User user) throws JsonParseException, JsonMappingException, IOException, CipherException, InterruptedException, ExecutionException{
		
		if(user.getEthereumAccount() == null){
			throw new IllegalStateException();
		}
		
		EthereumAccount ethereumAccount = user.getEthereumAccount();
		Categorie categorie = categorieDao.getOne(projectJson.getCategorie());
		Country country = countryDao.getOne(projectJson.getCountry());
		System.out.println(projectJson);
		System.out.println(categorie);
		System.out.println(country);
		System.out.println(ethereumAccount.getEthereumAddress());
		System.out.println(ethereumAccount.getPassword());
		
		// Va instancier le smart contract
		BigInteger blockchainGasPrice = new BigInteger(context.getBlockchainGasPrice());
		BigInteger blockchainGasLimit = new BigInteger(context.getBlockchainGasLimit());
		Uint256 duration = new Uint256(projectJson.getDuration());
		Uint256 amountWanted = new Uint256(projectJson.getMontant());
        BigInteger eth = new BigInteger("1");
		WalletFile walletFile = mapper.readValue(new File(ethereumAccount.getFile()),WalletFile.class);
		ECKeyPair keyPair= Wallet.decrypt(ethereumAccount.getPassword(), walletFile);
		Credentials credentials = Credentials.create(keyPair);
		Future<ProjectSmartContract> projectSmartContract = ProjectSmartContract.deploy(web3, credentials, blockchainGasPrice, blockchainGasLimit, eth, duration, amountWanted);
		System.out.println("WAITING SMART CONTRACT MINING");
		projectSmartContract.get();
		
		/*
		Project project = new Project();
		project.setAddress(addressInstanciate);
		project.setCreatedBy(user);
		project.setDescription(projectJson.getDescription());
		project.setName(projectJson.getName());
		project.setCategorie(categorie);
		projectDao.save(project);
		*/
	}

	public List<Project> getAllProject() {
		return projectDao.findAll();
	}

	public List<Project> getAllProjectByCategorie(Integer categorie) {
		Categorie cat = categorieDao.findOne(categorie);
		return projectDao.findByCategorie(cat);
	}

	public List<Project> getAllByName(String name) {
		return projectDao.findByNameLike(name);
	}

	public void deleteProject(Integer idProject) {
		projectDao.delete(idProject);
	}

	public Page<Project> getPaginableList(Integer page, Integer nbResultPerPage, Integer categorie, String name,
			String address) {
		Categorie cat = null;
		if (categorie != null) {
			cat = categorieDao.findOne(categorie);
		}
		if (name != null && name.isEmpty()) {
			name = null;
		}
		if (address != null && address.isEmpty()) {
			address.isEmpty();
		}
		PageRequest request = new PageRequest(page - 1, nbResultPerPage);
		Page<Project> project = projectDao.findByAll(name, address, cat, request);
		return project;
	}

}
