package com.gigsterous.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.auth.model.User;
import com.gigsterous.auth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/user")
	public User user(Principal principal) {
		log.debug("Getting user based on principal: {}", principal.toString());
		
		
		
		return userRepo.findOneByUsername(principal.getName());
	}

}
