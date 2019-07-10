package com.techinstance.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techinstance.project.dao.ProjectRepository;
import com.techinstance.project.model.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;

	public List<Project> getAll() {
		return projectRepo.findAll();

	}

	public Project get(Long id) {
		return projectRepo.getOne(id);
	}

	@Transactional
	public void saveUpdate(Project project) {
		projectRepo.save(project);
	}

	@Transactional
	public void delete(Long id) {
		projectRepo.deleteById(id);

	}

}
