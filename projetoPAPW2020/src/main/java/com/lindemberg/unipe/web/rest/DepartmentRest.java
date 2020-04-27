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

import com.lindemberg.unipe.web.domain.Department;
import com.lindemberg.unipe.web.service.DepartmentService;
import com.lindemberg.unipe.web.service.dto.DepartmentDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class DepartmentRest {

	@Autowired
	private DepartmentService departmentService;
	//trocar o department por DTO; criar os DTO
	
	//get e os outros metodos já com o ResponseEntity
	@GetMapping("department")
	public ResponseEntity<List<Department>> listar(){
		return ResponseEntity.ok(departmentService.listar());
	}
	//get por id
	@GetMapping("department/{id}")
	public ResponseEntity<Department> listarPorId(@PathVariable Long id){
		return ResponseEntity.ok(departmentService.consultarPorId(id));
	}
	
	//delete por id
	//o path é para indicar que o valor foi passado na url e será usado
	@DeleteMapping("/department/{id}")
	public ResponseEntity deletePorId(@PathVariable Long id) {
		try {
			departmentService.deleteById(id);
			return ResponseEntity.ok().build();
			}catch (Exception e) {
				return ResponseEntity.badRequest().build();			}
	}
		
	//post - criar requestbody indica que o valor deve ser passado na requisição
	@PostMapping("/department")
	public ResponseEntity<Department> salvar(@RequestBody @Valid Department department){
		return ResponseEntity.ok(departmentService.salvar(department));
	}
	
	//put
	@PutMapping("/department")
	public ResponseEntity<Department> update(@RequestBody @Valid Department department){
	return ResponseEntity.ok(departmentService.update(department));
}
	@GetMapping("/department/departmentName/{id}")
	public ResponseEntity<DepartmentDTO> getDepartmentNameById(@PathVariable Long id){
		try {
			DepartmentDTO departmentDTO = departmentService.getDepartmentPorId(id);
			return ResponseEntity.ok(departmentDTO);
		}
	catch (Exception e){
		return ResponseEntity.notFound().build();
	}
	}

}