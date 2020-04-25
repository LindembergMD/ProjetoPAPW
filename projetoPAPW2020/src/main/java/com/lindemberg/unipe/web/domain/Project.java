package com.lindemberg.unipe.web.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {
	
	@Id
	private int id;
	private Long minSalary;
	private Long maxSalary;
		
	//person sem o relacionamento, aqui seria @ManyToOne e JoinColumn	
	@ManyToOne
	@JoinColumn(name="manager")
	private Person manager;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Long getMinSalary() {
		return minSalary;
	}


	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}


	public Long getMaxSalary() {
		return maxSalary;
	}


	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}


	public Person getManager() {
		return manager;
	}


	public void setManager(Person manager) {
		this.manager = manager;
	}
	
	
	

}
