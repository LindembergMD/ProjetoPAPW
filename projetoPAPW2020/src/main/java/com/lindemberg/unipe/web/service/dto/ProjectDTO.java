package com.lindemberg.unipe.web.service.dto;

import com.lindemberg.unipe.web.domain.Project;

public class ProjectDTO {
	
	private int id;
	private Long minSalary;
	private Long maxSalary;
	
	
	public ProjectDTO(Project project) {
		setId(project.getId());
		setMinSalary(project.getMinSalary());
		setMaxSalary(project.getMaxSalary());
	}
	
	
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
	
	
	
	

}
