package com.gigsterous.auth.service;

import com.gigsterous.auth.model.User;

public interface RegistrationService {
	
	public void registerUser(User user);
	
	public void confirmUser(String token, String password);
	
	public boolean isUserRegistered(User user);
	
	public User getUserForToken(String token);

}
