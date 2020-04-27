package com.lindemberg.unipe.web.rest;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lindemberg.unipe.web.domain.Task;
import com.lindemberg.unipe.web.service.TaskService;
import com.lindemberg.unipe.web.service.dto.ProjectDTO;
import com.lindemberg.unipe.web.service.dto.TaskDTO;

@RestController
@RequestMapping("/api")
public class TaskRest {

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> listar(){
		return ResponseEntity.ok(taskService.listar());
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> listarPorId(@PathVariable Long id){
		return ResponseEntity.ok(taskService.consultarPorId(id));
	}
	@PutMapping("/task")
	public ResponseEntity<Task> update(@RequestBody @Valid Task task){
		return ResponseEntity.ok(taskService.update(task));
	}
	@PostMapping("/task")
	public ResponseEntity<Task> salvar(@RequestBody @Valid Task task){
		return ResponseEntity.ok(taskService.salvar(task));
	}
	@DeleteMapping("/task/{id}")
	public ResponseEntity deletePorId(@PathVariable Long id) {
		try {
			taskService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/task/title/{id}")
	public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
		try {
			TaskDTO taskDTO = taskService.getTaskPorId(id);
			return ResponseEntity.ok(taskDTO);
		}
	catch (Exception e){
		return ResponseEntity.notFound().build();
	}
	
}
	@GetMapping("/task/data/{dt}")
	public ResponseEntity<List<Task>> listarPorData(@PathVariable Instant dt){
		return ResponseEntity.ok(taskService.consultarAposData(dt));
	}
	
	@GetMapping("/task/pontuacao/{pt}")
	public ResponseEntity<List<Task>> listarPorPont(@PathVariable Long pt, Long pt1){
		return ResponseEntity.ok(taskService.consultarEntrePontuacao(pt, pt1));
	}


	/*

	@GetMapping("/task/status2/{st}")
	public ResponseEntity<List<Task>> listarPorStatus(@PathVariable Instant st, Long status){
		return ResponseEntity.ok(taskService.consultarComStatus2(st, status));
	}
		
	@GetMapping("/task/status1/{st}")
	public ResponseEntity<List<Task>> listarPorStatus1(@PathVariable Instant st, Long status){
		return ResponseEntity.ok(taskService.consultarComStatus1(st, status));
	}
		*/	
	
	
}
