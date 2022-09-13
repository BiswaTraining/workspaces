package com.cts.Project.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Project.Exceptions.ProjectDetailsNotFoundException;
import com.cts.Project.dto.ProjectDTO;
import com.cts.Project.entity.ProjectDetails;
import com.cts.Project.repository.ProjectRepository;
import com.cts.Project.service.ProjectDaoService;

@Service
public class ProjectDaoServiceImpl implements ProjectDaoService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	@Override
	public void addProjectDetails(ProjectDTO project) {
		ProjectDetails projectDetail = new ProjectDetails();
		projectDetail.setBudget(project.getBudget());
		projectDetail.setDuration(project.getDuration());
		projectDetail.setEndDate(project.getEndDate());
		projectDetail.setManagerName(project.getManagerName());
		projectDetail.setTeamSize(project.getTeamSize());
		projectDetail.setTitle(project.getTitle());
		projectRepository.save(projectDetail);
		
	}
	
	@Transactional
	@Override
	public void updateProjectDetails(int projectId) throws ProjectDetailsNotFoundException {
		Optional<ProjectDetails> optional = projectRepository.findById(projectId);
		ProjectDetails projectDetail = optional.orElseThrow(()-> new ProjectDetailsNotFoundException("Project Details not found"));
		projectDetail.setTitle("Project details updated");
		projectRepository.save(projectDetail);
	}
	
	@Transactional
	@Override
	public void deleteProjectDetails(int projectId) throws ProjectDetailsNotFoundException {
				
		Optional<ProjectDetails> project = projectRepository.findById(projectId);
		project.orElseThrow(() -> new ProjectDetailsNotFoundException("Project not found.Hence cannot be deleted"));
		projectRepository.deleteById(projectId);

		
	}

	@Override
	public List<ProjectDTO> listProjectDetails() throws ProjectDetailsNotFoundException {
		Iterable<ProjectDetails> projectDetails = projectRepository.findAll();
		List<ProjectDTO> listProjectDTO = new ArrayList<>();
		projectDetails.forEach(proj -> {
			ProjectDTO project = new ProjectDTO();
			project.setProjectId(proj.getProjectId());
			project.setBudget(proj.getBudget());
			project.setDuration(proj.getDuration());
			project.setEndDate(proj.getEndDate());
			project.setManagerName(proj.getManagerName());
			project.setTeamSize(proj.getTeamSize());
			project.setTitle(proj.getTitle());
			
			listProjectDTO.add(project);
		});
		if (listProjectDTO.isEmpty())
			throw new ProjectDetailsNotFoundException("No Project Details found");
		return listProjectDTO;

	}

}
