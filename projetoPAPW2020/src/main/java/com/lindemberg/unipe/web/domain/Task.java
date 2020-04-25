package com.lindemberg.unipe.web.domain;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	private int id;
	private String title;
	private String description;
	private Long taskPoints;
	private Instant startDate;
	private Instant endDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getTaskPoints() {
		return taskPoints;
	}
	public void setTaskPoints(Long taskPoints) {
		this.taskPoints = taskPoints;
	}
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
