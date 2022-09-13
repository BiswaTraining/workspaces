package com.citiustech.HibernateAssignment2OneTone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locker {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOCKERID")
	private Integer lockerId;
	@Column(name="LOCKERTYPE")
	private String lockerType;
	@Column(name="RENT")
	private double rent;
	public Integer getLockerId() {
		return lockerId;
	}
	public void setLockerId(Integer lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}
	
}