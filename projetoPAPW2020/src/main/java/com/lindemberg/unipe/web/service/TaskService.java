package com.lindemberg.unipe.web.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lindemberg.unipe.web.domain.Task;
import com.lindemberg.unipe.web.repository.TaskRepository;
import com.lindemberg.unipe.web.service.dto.TaskDTO;

import javassist.NotFoundException;
@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	//método para salvar
	public Task salvar(Task task) {
		return taskRepository.save(task);
	}
	//metodo para deletar por id
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}
	//metodo para deletar
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	
	//metodo para atualizar
	public Task update(Task task) {
		return taskRepository.save(task);
	}	
	//metodo para listar
	public List<Task> listar(){
		return taskRepository.findAll();
	}
	//metodo para listar por id
	public Task consultarPorId(Long id) {
		return taskRepository.findById(id).get();
	}
	
	//metodos do DTO
	
	//metodo do DTO - listar por id
	public TaskDTO getTaskPorId(Long id) throws NotFoundException{
		Optional<Task> task = taskRepository.findById(id);
		if(!task.isEmpty())
			throw new NotFoundException("Departamento não encontrado");
		
		return new TaskDTO(task.get());
	} 
	//mostrar apos uma data
		public List<Task> consultarAposData(Instant endDate){
			return taskRepository.findTaskByEndDateAfter(endDate);
		}
		
		//mostrar entre pontuacao
		public List<Task> consultarEntrePontuacao(Long taskPoint, Long taskPoint2) {
			return taskRepository.findTaskByTaskPointsBetween(taskPoint, taskPoint2);
		}
	

		/*
	//mostrar com status 2
	public List<Task> consultarComStatus2(Instant endDate, Long status){
		return taskRepository.findTaskByEndDateAndStatusEquals(endDate, status);
	}
	//mostrar com status 1
	public List<Task> consultarComStatus1(Instant startDate, Long status){
		return taskRepository.findTaskByStartDateAndStatusEquals(startDate, status);
	}
	*/
	
}
