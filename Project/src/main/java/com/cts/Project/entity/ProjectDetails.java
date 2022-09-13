package com.cts.Project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//the below annotations are possible because of lombok dependency
@Getter @Setter @NoArgsConstructor @ToString
public class ProjectDetails {
	@Id
	@Column(length=5)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer projectId;
	@Column(length=50)
	private String title;
	private Double budget;
	private Integer teamSize;
	private Integer duration;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	@Column(length=30)
	private String managerName;
}