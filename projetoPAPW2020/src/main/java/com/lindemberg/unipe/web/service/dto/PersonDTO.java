package com.lindemberg.unipe.web.service.dto;

import java.time.Instant;

import com.lindemberg.unipe.web.domain.Person;

public class PersonDTO {

	
	private int id;	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Instant createDate;
	private Instant updateDate;
	
	public PersonDTO(Person person) {
		setId(person.getId());
		setFirstName(person.getFirstName());
		setLastName(person.getLastName());
		setEmail(person.getEmail());
		setPhoneNumber(person.getPhoneNumber());
		setCreateDate(person.getCreateDate());
		setUpdateDate(person.getUpdateDate());
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
