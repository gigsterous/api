package com.gigsterous.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.Person;
import com.gigsterous.api.repository.PersonRepository;

@RestController
public class UserController {
	
	@Autowired
	private PersonRepository personRepo;
	
	/**
	 * Returns currently logged user as Person object.
	 * 
	 * @param user
	 * @return currently logged user
	 */
	@RequestMapping("/user")
	public Person user(Principal user) {
		// username in auth server is always email
		return personRepo.findByEmail(user.getName());
	}

}
