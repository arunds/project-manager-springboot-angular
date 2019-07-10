package com.techinstance.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techinstance.project.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
