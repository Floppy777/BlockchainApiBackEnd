package com.indo.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indo.blockchain.json.ProjectJson;
import com.indo.blockchain.json.ProjectSendFundJson;
import com.indo.blockchain.model.Project;
import com.indo.blockchain.model.User;
import com.indo.blockchain.repository.IProjectDao;
import com.indo.blockchain.service.AuthenticationService;
import com.indo.blockchain.service.ProjectService;

@RestController
@RequestMapping(value="/project")
public class ProjectApi {

	@Autowired
	private IProjectDao projectDao;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getAllProject(){
		return new ResponseEntity<List<Project>>(projectDao.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> registerProject(@RequestBody ProjectJson projectJson){
		try {
			User user = authenticationService.currentUserAuthenticated();
			projectService.registerProject(projectJson,user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e ){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/depositMoney",method = RequestMethod.POST)
	public ResponseEntity<Void> sendMoneyToProject(@RequestBody ProjectSendFundJson projectSendFundJson){
		try {
			projectService.sendFundToProject(projectSendFundJson);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(value="/all/categorie/{idCategorie}",method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getAllProjectByCategorie(@PathVariable("idCategorie") Integer categorie){
		List<Project> listProject = projectService.getAllProjectByCategorie(categorie);
		return new ResponseEntity<List<Project>>(listProject,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idProject}",method = RequestMethod.GET)
	public ResponseEntity<Project> getOneProjectById(@PathVariable("idProject") Integer idProject){
		Project p = projectDao.findOne(idProject);
		return new ResponseEntity<Project>(p,HttpStatus.OK);
	}
	
	@RequestMapping(value="/all/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getAllProjectByName(@PathVariable("name") String name){
		List<Project> listProject = projectService.getAllByName(name);
		return new ResponseEntity<List<Project>>(listProject,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idProject}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProject(@PathVariable("idProject") Integer idProject){
		projectService.deleteProject(idProject);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/paginable/all", method = RequestMethod.GET)
	public ResponseEntity<Page<Project>> getAllPaginableProject(@RequestParam("page") Integer page, 
																@RequestParam("nbResultPerPage") Integer nbResultPerPage,
																@RequestParam(value="categorie",required = false) Integer categorie,
																@RequestParam(value="country",required = false) Integer country,
																@RequestParam(value="name",required = false) String name,
																@RequestParam(value="address",required = false) String address){
		Page<Project> listPaginableProject = projectService.getPaginableList(page,nbResultPerPage,categorie,country,name,address);
		return new ResponseEntity<Page<Project>>(listPaginableProject,HttpStatus.OK);
	}
}
