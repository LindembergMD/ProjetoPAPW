package com.lindemberg.unipe.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lindemberg.unipe.web.domain.Department;
import com.lindemberg.unipe.web.repository.DepartmentRepository;
import com.lindemberg.unipe.web.service.dto.DepartmentDTO;

import javassist.NotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//método para salvar
	public Department salvar(Department department) {
		return departmentRepository.save(department);
	}
	//metodo para deletar por id
	public void deleteById(Long id) {
		departmentRepository.deleteById(id);
	}

	
	//metodo para deletar, apaga tudo enviado
	public void delete(Department department) {
		departmentRepository.delete(department);
	}
	
	//metodo para atualizar
	public Department update(Department department) {
		return departmentRepository.save(department);
	}	
	//metodo para listar
	public List<Department> listar(){
		return departmentRepository.findAll();
	}
	//metodo para listar por id
	public Department consultarPorId(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	//metodo do DTO - listar por id
	public DepartmentDTO getDepartmentPorId(Long id) throws NotFoundException{
		Optional<Department> department = departmentRepository.findById(id);
		if(!department.isEmpty())
			throw new NotFoundException("Departamento não encontrado");
		
		return new DepartmentDTO(department.get());
	}
}
