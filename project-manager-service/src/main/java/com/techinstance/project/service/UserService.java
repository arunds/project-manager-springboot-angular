package com.techinstance.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techinstance.project.dao.UserRepository;
import com.techinstance.project.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public List<User> getAll() {
		return userRepo.findAll();

	}

	public User get(Long id) {
		return userRepo.getOne(id);
	}

	@Transactional
	public void saveUpdate(User user) {
		userRepo.save(user);
	}

	@Transactional
	public void delete(Long id) {
		userRepo.deleteById(id);

	}

}
