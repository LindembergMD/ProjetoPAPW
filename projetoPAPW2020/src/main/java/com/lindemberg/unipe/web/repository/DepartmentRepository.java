package com.lindemberg.unipe.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lindemberg.unipe.web.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public List<Department> findDepartmentByDepartmentName(String departmentName);
	
}
