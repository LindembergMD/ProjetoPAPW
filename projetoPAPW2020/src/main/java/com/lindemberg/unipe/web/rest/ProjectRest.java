package com.lindemberg.unipe.web.rest;

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

import com.lindemberg.unipe.web.domain.Project;
import com.lindemberg.unipe.web.service.ProjectService;
import com.lindemberg.unipe.web.service.dto.ProjectDTO;

@RestController
@RequestMapping("/api")
public class ProjectRest {
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/project")
	public ResponseEntity<List<Project>> listar(){
		return ResponseEntity.ok(projectService.listar());
	}
	
	@GetMapping("/project/{id}")
	public ResponseEntity<Project> listarPorId(@PathVariable Long id){
		return ResponseEntity.ok(projectService.consultarPorId(id));
	}
	@PutMapping("/project")
	public ResponseEntity<Project> update(@RequestBody @Valid Project project){
		return ResponseEntity.ok(projectService.update(project));
	}
	@PostMapping("/project")
	public ResponseEntity<Project> salvar(@RequestBody @Valid Project project){
		return ResponseEntity.ok(projectService.salvar(project));
	}
	@DeleteMapping("/project/{id}")
	public ResponseEntity deletePorId(@PathVariable Long id) {
		try {
			projectService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/project/name/{id}")
	public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id){
		try {
			ProjectDTO projectDTO = projectService.getProjectPorId(id);
			return ResponseEntity.ok(projectDTO);
		}
	catch (Exception e){
		return ResponseEntity.notFound().build();
	}
	
}
	
	
	

}
