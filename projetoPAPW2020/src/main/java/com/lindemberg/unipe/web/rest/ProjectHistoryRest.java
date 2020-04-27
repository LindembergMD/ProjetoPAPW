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


import com.lindemberg.unipe.web.domain.ProjectHistory;
import com.lindemberg.unipe.web.service.ProjectHistoryService;
import com.lindemberg.unipe.web.service.dto.PersonDTO;
import com.lindemberg.unipe.web.service.dto.ProjectHistoryDTO;

@RestController
@RequestMapping("/api")
public class ProjectHistoryRest {

	@Autowired
	private ProjectHistoryService projectHistoryService;
	
	
	@GetMapping("/projectHistory")
	public ResponseEntity<List<ProjectHistory>> listar(){
		return ResponseEntity.ok(projectHistoryService.listar());
	}
	
	@GetMapping("/projectHistory/{id}")
	public ResponseEntity<ProjectHistory> listarPorId(@PathVariable Long id){
		return ResponseEntity.ok(projectHistoryService.consultarPorId(id));
	}
	@PutMapping("/projectHistory")
	public ResponseEntity<ProjectHistory> update(@RequestBody @Valid ProjectHistory projectHistory){
		return ResponseEntity.ok(projectHistoryService.update(projectHistory));
	}
	@PostMapping("/projectHistory")
	public ResponseEntity<ProjectHistory> salvar(@RequestBody @Valid ProjectHistory projectHistory){
		return ResponseEntity.ok(projectHistoryService.salvar(projectHistory));
	}
	@DeleteMapping("/projectHistory/{id}")
	public ResponseEntity deletePorId(@PathVariable Long id) {
		try {
			projectHistoryService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/projectHistory/name/{id}")
	public ResponseEntity<ProjectHistoryDTO> getProjectHistoryById(@PathVariable Long id){
		try {
			ProjectHistoryDTO projectHistoryDTO = projectHistoryService.getProjectHistoryPorId(id); 
			return ResponseEntity.ok(projectHistoryDTO);
		}
	catch (Exception e){
		return ResponseEntity.notFound().build();
	}
	
}
	
	
	
}
