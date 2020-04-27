package com.lindemberg.unipe.web.domain;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProjectHistory {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Instant startDate;
	private Instant endDate;
	
	
	@OneToOne
	@JoinColumn (name="manager")
	private Person manager;
	
	 @OneToOne
	 @JoinColumn (name = "department_id")
	 private Department department;
	
	
	
	
	public Person getManager() {
		return manager;
	}
	public void setManager(Person manager) {
		this.manager = manager;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public Person getManager() {
		return manager;
	}
	public void setManager(Person manager) {
		this.manager = manager;
	}*/
	public Instant getStartDate() {
		return startDate;
	}
	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}
	public Instant getEndDate() {
		return endDate;
	}
	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}
	

}
