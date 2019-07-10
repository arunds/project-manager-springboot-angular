package com.techinstance.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techinstance.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
