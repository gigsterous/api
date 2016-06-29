package com.gigsterous.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gigsterous.api.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findAll();

}
