package com.lindemberg.unipe.web.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lindemberg.unipe.web.domain.ProjectHistory;

@Repository
public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Long> {

	public List<ProjectHistory> findProjectHistoryByStartDate(Instant startDate);
	
	public List<ProjectHistory> findProjectHistoryByEndDate(Instant endDate);
}
