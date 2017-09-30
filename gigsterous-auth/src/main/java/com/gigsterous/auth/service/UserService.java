package com.gigsterous.auth.service;

import com.gigsterous.auth.model.User;
import com.gigsterous.auth.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return userRepository.findOneByEmail(email);
	}
}