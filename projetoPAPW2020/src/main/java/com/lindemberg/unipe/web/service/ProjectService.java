package com.lindemberg.unipe.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lindemberg.unipe.web.domain.Project;
import com.lindemberg.unipe.web.repository.ProjectRepository;
import com.lindemberg.unipe.web.service.dto.ProjectDTO;

import javassist.NotFoundException;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	//método para salvar
	public Project salvar(Project project) {
		return projectRepository.save(project);
	}
	//metodo para deletar por id
	public void deleteById(Long id) {
		projectRepository.deleteById(id);
	}
	//metodo para deletar
	public void delete(Project project) {
		projectRepository.delete(project);
	}
	
	//metodo para atualizar
	public Project update(Project project) {
		return projectRepository.save(project);
	}	
	//metodo para listar
	public List<Project> listar(){
		return projectRepository.findAll();
	}
	//metodo para listar por id
	public Project consultarPorId(Long id) {
		return projectRepository.findById(id).get();
	}
	
	//metodos do DTO
	
	//metodo do DTO - listar por id
	public ProjectDTO getProjectPorId(Long id) throws NotFoundException{
		Optional<Project> project = projectRepository.findById(id);
		if(!project.isEmpty())
			throw new NotFoundException("Departamento não encontrado");
		
		return new ProjectDTO(project.get());
	}
}
