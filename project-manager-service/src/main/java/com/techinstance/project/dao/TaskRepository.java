package com.techinstance.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techinstance.project.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	Task findByTitle(String title);
}
