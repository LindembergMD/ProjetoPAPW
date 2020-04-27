package com.lindemberg.unipe.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lindemberg.unipe.web.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public List<Project> findProjectByMinSalary(Long minSalary);
	
}
