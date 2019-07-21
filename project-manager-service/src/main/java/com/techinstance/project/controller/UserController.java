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

import com.techinstance.project.model.User;
import com.techinstance.project.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;
    
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public List<User> getAllUsers() {
    	logger.info("Fetch all the users from  # ");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") String id) {
    	logger.info("Fetch users   # "+id);
        return service.get(Long.valueOf(id));
    }


    @PostMapping
    public void saveUser(@RequestBody User user) {
    	logger.info("Saving user   # "+user.getFirstName() + "Emp ID : "+ user.getEmpId());
    	
        service.saveUpdate(user);
    }


    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody String id) {
    	logger.info("Deleting user   # "+id);
        if (id != null) {
            //service.delete(Long.valueOf(id));
            User user = service.get(Long.valueOf(id));
            //user.setStatus("ENDED");
            service.saveUpdate(user);
        }
        return ResponseEntity.ok().build();

    }



}
