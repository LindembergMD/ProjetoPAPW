package com.lindemberg.unipe.web.service.dto;

import java.time.Instant;

import com.lindemberg.unipe.web.domain.ProjectHistory;

public class ProjectHistoryDTO {

	
	private int id;
	private Instant startDate;
	private Instant endDate;
	
	public ProjectHistoryDTO(ProjectHistory projectHistory) {
		setId(projectHistory.getId());
		setStartDate(projectHistory.getStartDate());
		setEndDate(projectHistory.getEndDate());
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
