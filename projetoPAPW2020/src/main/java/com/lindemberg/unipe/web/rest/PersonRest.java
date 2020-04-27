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

import com.lindemberg.unipe.web.domain.Person;
import com.lindemberg.unipe.web.service.PersonService;
import com.lindemberg.unipe.web.service.dto.DepartmentDTO;
import com.lindemberg.unipe.web.service.dto.PersonDTO;

@RestController
@RequestMapping("/api")
public class PersonRest {
	@Autowired
	private PersonService personService;

	@GetMapping("/person")
	public ResponseEntity<List<Person>> listar(){
		return ResponseEntity.ok(personService.listar());
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> listarPorId(@PathVariable Long id){
		return ResponseEntity.ok(personService.consultarPorId(id));
	}
	@PutMapping("/person")
	public ResponseEntity<Person> update(@RequestBody @Valid Person person){
		return ResponseEntity.ok(personService.update(person));
	}
	@PostMapping("/person")
	public ResponseEntity<Person> salvar(@RequestBody @Valid Person person){
		return ResponseEntity.ok(personService.salvar(person));
	}
	@DeleteMapping("/person/{id}")
	public ResponseEntity deletePorId(@PathVariable Long id) {
		try {
			personService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/person/name/{id}")
	public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id){
		try {
			PersonDTO personDTO = personService.getPersonPorId(id);
			return ResponseEntity.ok(personDTO);
		}
	catch (Exception e){
		return ResponseEntity.notFound().build();
	}
	
}
}
