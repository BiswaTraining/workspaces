package com.cts.Project.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @NoArgsConstructor @ToString
public class ProjectDTO {
	
	private Integer projectId;
	private String title;
	private Double budget;
	private Integer teamSize;
	private Integer duration;	
	private LocalDate endDate;
	private String managerName;
}
