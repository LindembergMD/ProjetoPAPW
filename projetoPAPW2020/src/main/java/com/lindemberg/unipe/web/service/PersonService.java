package com.lindemberg.unipe.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lindemberg.unipe.web.domain.Person;
import com.lindemberg.unipe.web.repository.PersonRepository;
import com.lindemberg.unipe.web.service.dto.PersonDTO;


import javassist.NotFoundException;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	//método para salvar
	public Person salvar(Person person) {
		return personRepository.save(person);
	}
	//metodo para deletar por id
	public void deleteById(Long id) {
		personRepository.deleteById(id);
	}
	//metodo para deletar
	public void delete(Person person) {
		personRepository.delete(person);
	}
	
	//metodo para atualizar
	public Person update(Person person) {
		return personRepository.save(person);
	}	
	//metodo para listar
	public List<Person> listar(){
		return personRepository.findAll();
	}
	//metodo para listar por id
	public Person consultarPorId(Long id) {
		return personRepository.findById(id).get();
	}
	
	//metodos do DTO
	
	//metodo do DTO - listar por id
	public PersonDTO getPersonPorId(Long id) throws NotFoundException{
		Optional<Person> person = personRepository.findById(id);
		if(!person.isEmpty())
			throw new NotFoundException("Pessoa não encontrada");
		
		return new PersonDTO(person.get());
	}
}
