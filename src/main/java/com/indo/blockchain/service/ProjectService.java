package com.indo.blockchain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.indo.blockchain.configuration.UrlConfigurator;
import com.indo.blockchain.json.ProjectJson;
import com.indo.blockchain.model.Categorie;
import com.indo.blockchain.model.EthereumAccount;
import com.indo.blockchain.model.Project;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.ICategorieDao;
import com.indo.blockchain.repository.IProjectDao;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private IProjectDao projectDao;
	
	@Autowired
	private ICategorieDao categorieDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UrlConfigurator urlConfigurator;
	
	public void registerProject(ProjectJson projectJson,User user){
		
		if(user.getEthereumAccount() == null){
			throw new IllegalStateException();
		}
		
		EthereumAccount ethereumAccount = user.getEthereumAccount();
		ethereumAccount.getEthereumAddress();
		ethereumAccount.getPassword();
		Categorie categorie = categorieDao.getOne(projectJson.getCategorie());
		System.out.println(projectJson);
		System.out.println(categorie);
		System.out.println(ethereumAccount.getEthereumAddress());
		System.out.println(ethereumAccount.getPassword());
		
		// Va instancier le smart contract
		String addressInstanciate = restTemplate.postForObject(urlConfigurator.getUrlProjectCreation(),projectJson, String.class);
		
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
	
	public List<Project> getAllProject(){
		return projectDao.findAll();
	}
	
	public List<Project> getAllProjectByCategorie(Integer categorie){
		Categorie cat = categorieDao.findOne(categorie);
		return projectDao.findByCategorie(cat);
	}
	
	public List<Project> getAllByName(String name){
		return projectDao.findByNameLike(name);
	}
	
	public void deleteProject(Integer idProject){
		projectDao.delete(idProject);
	}
	
	public Page<Project> getPaginableList(Integer page, Integer nbResultPerPage,Integer categorie,String name,String address){
		Categorie cat = null;
		if(categorie != null){
			cat = categorieDao.findOne(categorie);
		}
		if(name != null && name.isEmpty()){
			name = null;
		}
		if(address != null && address.isEmpty()){
			address.isEmpty();
		}
		PageRequest request = new PageRequest(page -1, nbResultPerPage);
		Page<Project> project = projectDao.findByAll(name, address,cat,request);
		return project;
	}

}
