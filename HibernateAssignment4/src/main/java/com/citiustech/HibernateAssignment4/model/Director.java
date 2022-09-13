package com.citiustech.HibernateAssignment4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Director {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DIRECTORID")
	private Integer directorId;
	@Column(name="DIRECTORNAME")
	private String directorName;
	@Column(name="BORNIN")
	private Integer bornIn;
	public Integer getDirectorId() {
		return directorId;
	}
	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public Integer getBornIn() {
		return bornIn;
	}
	public void setBornIn(Integer bornIn) {
		this.bornIn = bornIn;
	}
	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", bornIn=" + bornIn + "]";
	}
}