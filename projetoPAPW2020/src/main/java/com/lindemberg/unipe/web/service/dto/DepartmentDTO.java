package com.lindemberg.unipe.web.service.dto;

import com.lindemberg.unipe.web.domain.Department;

public class DepartmentDTO {
	
	private int id;
	private String departmentName;
	
	public DepartmentDTO (Department department) {
		setId(department.getId());
		setDepartmentName(department.getDepartmentName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	

}
