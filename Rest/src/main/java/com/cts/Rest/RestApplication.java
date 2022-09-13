package com.cts.Rest;


import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cts.Rest.dto.ProjectDTO;

@SpringBootApplication
public class RestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ProjectDTO project = new ProjectDTO();
		//To test the Project application api's through rest template
		addProduct();
		getCustomerDetails();
		updateProduct(2);
		deleteProduct(4);
	}
	
	public void getCustomerDetails() {//4
		String url = "http://localhost:8080/project/product";
		//step1step 
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.
		// getForObject 1-url, 2. return datatype 
//		List<ProjectDTO> projectDTO = restTemplate.getForObject(url, List<ProjectDTO.class>);
//		List<ProjectDTO> projectDTO =(List<ProjectDTO>) restTemplate.getForEntity(url, ProjectDTO.class);
		ResponseEntity<ProjectDTO[]> response = restTemplate.getForEntity(url, ProjectDTO[].class);
		ProjectDTO[] projectDetails= response.getBody();
		if(projectDetails!=null && projectDetails.length>0) {
			for(ProjectDTO project: projectDetails) {
				System.out.println(project);
			}
		}
	}
	
	public void addProduct() {
		String url = "http://localhost:8080/project/product";
		ProjectDTO projectDetails= new ProjectDTO();
		projectDetails.setBudget(20000.0);
		projectDetails.setDuration(25);
		projectDetails.setEndDate(LocalDate.now());
		projectDetails.setManagerName("Virat");
		projectDetails.setTeamSize(5);
		projectDetails.setTitle("Rest Product");
		RestTemplate restTemplate = new RestTemplate();
		//1st parameter is url,2nd parameter is request body, 3rd parameter is return type
		String response = restTemplate.postForObject(url, projectDetails, String.class);
		System.out.println(response);
	}

	public void updateProduct(Integer projectId) {
		String url = "http://localhost:8080/project/product/{projectId}";
		RestTemplate restTemplate = new RestTemplate();
		ProjectDTO project = new ProjectDTO();
//		restTemplate.put(url, customerDTO, customerDTO.getCustomerId());
		//1st parameter is url,2nd parameter is request body, 3rd parameter is uri for path variable
		restTemplate.put(url, project,projectId);
	}

	public void deleteProduct(Integer projectId) {
		String url = "http://localhost:8080/project/product/{projectId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url, projectId);
	}

}
