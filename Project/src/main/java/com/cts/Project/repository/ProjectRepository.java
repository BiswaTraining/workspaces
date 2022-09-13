package com.cts.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.Project.entity.ProjectDetails;

public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer>{

}
