package com.cts.Project.service;

import java.util.List;

import com.cts.Project.Exceptions.ProjectDetailsNotFoundException;
import com.cts.Project.dto.ProjectDTO;

public interface ProjectDaoService {
	public void addProjectDetails(ProjectDTO project);
	public void updateProjectDetails(int ProjectId) throws ProjectDetailsNotFoundException;
	public void deleteProjectDetails(int projectId) throws ProjectDetailsNotFoundException;
	public List<ProjectDTO> listProjectDetails() throws ProjectDetailsNotFoundException;

}
