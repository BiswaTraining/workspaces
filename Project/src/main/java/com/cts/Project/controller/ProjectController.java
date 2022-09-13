package com.cts.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Project.Exceptions.ProjectDetailsNotFoundException;
import com.cts.Project.dto.ProjectDTO;
import com.cts.Project.service.ProjectDaoService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectDaoService projectDaoService;
	
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody ProjectDTO projectDetails){
		projectDaoService.addProjectDetails(projectDetails);
		return new ResponseEntity<String>("Product successfully added",HttpStatus.CREATED);
		
	}
	
	@PutMapping("/product/{projectId}")
	public ResponseEntity<String> updateProduct(@PathVariable Integer projectId  ) throws ProjectDetailsNotFoundException{
		projectDaoService.updateProjectDetails(projectId);
		return new ResponseEntity<String>("Product successfully updated",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/product/{projectId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer projectId  ) throws ProjectDetailsNotFoundException{
		projectDaoService.deleteProjectDetails(projectId);
		return new ResponseEntity<String>("Product successfully deleted",HttpStatus.OK);
		
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<ProjectDTO>> getProducts() throws ProjectDetailsNotFoundException{
		List<ProjectDTO> response = projectDaoService.listProjectDetails();
		return new ResponseEntity<List<ProjectDTO>>(response,HttpStatus.OK);
		
	}
}
