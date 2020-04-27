package com.lindemberg.unipe.web.service.dto;

import java.time.Instant;

import com.lindemberg.unipe.web.domain.Task;

public class TaskDTO {

	
	private int id;
	private String title;
	private String description;
	private Long taskPoints;
	private Instant startDate;
	private Instant endDate;
	
	public TaskDTO (Task task) {
		setId(task.getId());
		setTitle(task.getTitle());
		setDescription(task.getDescription());
		setTaskPoints(task.getTaskPoints());
		setStartDate(task.getStartDate());
		setEndDate(task.getEndDate());
	}
	
	
	
	
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
