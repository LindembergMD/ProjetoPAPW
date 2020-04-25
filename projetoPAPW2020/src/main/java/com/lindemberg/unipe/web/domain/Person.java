package com.lindemberg.unipe.web.domain;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Instant createDate;
	private Instant updateDate;
	
		
	@OneToOne (mappedBy = "manager")
	private ProjectHistory projectHistory;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	//sem a volta de @OneToMany
	
	public ProjectHistory getProjectHistory() {
		return projectHistory;
	}
	public void setProjectHistory(ProjectHistory projectHistory) {
		this.projectHistory = projectHistory;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Instant getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}
	public Instant getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}

