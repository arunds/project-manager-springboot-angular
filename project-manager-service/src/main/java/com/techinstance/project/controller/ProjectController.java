package com.techinstance.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techinstance.project.model.Project;
import com.techinstance.project.service.ProjectService;


@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService service;
    
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
    	logger.info("Fetch all the projects from  # ");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable(value = "id") String id) {
    	logger.info("Fetch projects   # "+id);
        return service.get(Long.valueOf(id));
    }


    @PostMapping
    public void saveProject(@RequestBody Project project) {
    	logger.info("Saving project   # "+project.getTitle());
        service.saveUpdate(project);
    }


    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody String id) {
    	logger.info("Deleting project   # "+id);
        if (id != null) {
            //service.delete(Long.valueOf(id));
            Project project = service.get(Long.valueOf(id));
            //project.setStatus("ENDED");
            service.saveUpdate(project);
        }
        return ResponseEntity.ok().build();

    }



}
