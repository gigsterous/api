package com.gigsterous.auth.controller;

import com.gigsterous.auth.model.CustomPrincipal;
import com.gigsterous.auth.model.User;
import com.gigsterous.auth.repository.UserRepository;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/user")
	public CustomPrincipal user(Principal principal) {
		log.debug("Getting user based on principal: {}", principal.getName());

		// return principal with id as username
		User user = userRepo.findOneByEmail(principal.getName());

		CustomPrincipal cust = new CustomPrincipal();
		cust.setUsername(user.getId().toString());

		return cust;
	}

}
