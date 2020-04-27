package com.lindemberg.unipe.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lindemberg.unipe.web.domain.ProjectHistory;
import com.lindemberg.unipe.web.repository.ProjectHistoryRepository;
import com.lindemberg.unipe.web.service.dto.ProjectHistoryDTO;

import javassist.NotFoundException;

@Service
public class ProjectHistoryService {

	@Autowired
	private ProjectHistoryRepository projectHistoryRepository;
	
	//método para salvar
	public ProjectHistory salvar(ProjectHistory projectHistory) {
		return projectHistoryRepository.save(projectHistory);
	}
	//metodo para deletar por id
	public void deleteById(Long id) {
		projectHistoryRepository.deleteById(id);
	}
	//metodo para deletar
	public void delete(ProjectHistory projectHistory) {
		projectHistoryRepository.delete(projectHistory);
	}
	
	//metodo para atualizar
	public ProjectHistory update(ProjectHistory projectHistory) {
		return projectHistoryRepository.save(projectHistory);
	}	
	//metodo para listar
	public List<ProjectHistory> listar(){
		return projectHistoryRepository.findAll();
	}
	//metodo para listar por id
	public ProjectHistory consultarPorId(Long id) {
		return projectHistoryRepository.findById(id).get();
	}
	
	//metodos do DTO
	
	//metodo do DTO - listar por id
	public ProjectHistoryDTO getProjectHistoryPorId(Long id) throws NotFoundException{
		Optional<ProjectHistory> projectHistory = projectHistoryRepository.findById(id);
		if(!projectHistory.isEmpty())
			throw new NotFoundException("Departamento não encontrado");
		
		return new ProjectHistoryDTO(projectHistory.get());
	}
}
