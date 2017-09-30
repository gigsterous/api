package com.gigsterous.auth.service;

import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gigsterous.auth.AuthProperties;
import com.gigsterous.auth.model.User;
import com.gigsterous.auth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

	private final UserRepository userRepository;
	private final EmailService emailService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final AuthProperties properties;

	public RegistrationServiceImpl(UserRepository userRepository, EmailService emailService,
			BCryptPasswordEncoder bCryptPasswordEncoder, AuthProperties properties) {
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.properties = properties;
	}

	@Override
	public void registerUser(User user) {
		log.debug("Registering new user...");

		// Disable user until they click on confirmation link in email
		user.setEnabled(false);

		// Generate random 36-character string token for confirmation link
		user.setConfirmationToken(UUID.randomUUID().toString());

		userRepository.save(user);

		log.debug("Sending confirmation token to the selected email: {}", user.getEmail());

		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(user.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
				+ properties.getRedirectionUrl() + "/confirm?token=" + user.getConfirmationToken());
		registrationEmail.setFrom("noreply@gigsterous.com");

		emailService.sendEmail(registrationEmail);
	}

	@Override
	public void confirmUser(String token, String password) {
		log.debug("Confirming user with token {}", token);

		// Find the user associated with the reset token
		User user = userRepository.findByConfirmationToken(token);

		// Set new password
		user.setPassword(bCryptPasswordEncoder.encode((CharSequence) password));

		// Set user to enabled
		user.setEnabled(true);

		// Save user
		userRepository.save(user);
	}

	@Override
	public boolean isUserRegistered(User user) {
		User userExists = userRepository.findOneByEmail(user.getUsername());

		if (userExists != null) {
			// user is already in the system
			return true;
		}

		return false;
	}

	@Override
	public User getUserForToken(String token) {
		return userRepository.findByConfirmationToken(token);
	}

}
