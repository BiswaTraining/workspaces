package com.cts.Rest.dto;

import java.time.LocalDate;



import lombok.Getter;
import lombok.NoArgsConstructor;
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
