package com.lindemberg.unipe.web.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lindemberg.unipe.web.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	
	public List<Task> findTaskByTitleAndDescription(String title, String description);
	
	public List<Task> findTaskByTitleAndStartDate(String title, Instant startDate);
	
	//mostra task apos uma data (final)
	public List<Task> findTaskByEndDateAfter(Instant endDate);
	
	//mostrar task entre um periodo de pontuacao
		public List<Task> findTaskByTaskPointsBetween(Long taskPoint, Long taskPoint2);
		
	/*	
	//todas as tasks desenvolvidas em um período de datas e que estão com status 2
	public List<Task> findTaskByEndDateAndStatusEquals(Instant endDate, Long status);
	
	//todas as tasks desenvolvidas em um período de datas e que estão com status 1
	public List<Task> findTaskByStartDateAndStatusEquals(Instant startDate, Long status);
	*/
}

