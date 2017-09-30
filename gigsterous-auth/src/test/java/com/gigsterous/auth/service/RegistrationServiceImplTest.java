package com.gigsterous.auth.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gigsterous.auth.AuthProperties;
import com.gigsterous.auth.model.User;
import com.gigsterous.auth.repository.UserRepository;

public class RegistrationServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private EmailService emailService;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private AuthProperties properties;
	private RegistrationService registrationService;

	private ArgumentCaptor<SimpleMailMessage> mailMessageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
	private ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		properties = new AuthProperties();
		properties.setRedirectionUrl("http://www.example.com");

		registrationService = new RegistrationServiceImpl(userRepository, emailService, bCryptPasswordEncoder,
				properties);

	}

	@Test
	public void givenExistingUserWhenCheckingUserRegisteredThenReturnTrue() {

		User user = new User();
		user.setEmail("user@example.com");

		// given existing user
		given(userRepository.findOneByEmail("user@example.com")).willReturn(user);

		// when checking user registered
		boolean isRegistered = registrationService.isUserRegistered(user);

		// then expect true
		assertThat(isRegistered, is(true));

	}

	@Test
	public void givenNonExistingUserWhenCheckingUserRegisteredThenReturnFalse() {

		// given new user
		User user = new User();
		user.setEmail("user@example.com");

		// when checking user registered
		boolean isRegistered = registrationService.isUserRegistered(user);

		// then expect false
		assertThat(isRegistered, is(false));

	}

	@Test
	public void givenTokenWhenCheckingUserForTokenThenReturnCorrectUser() {

		User user = new User();
		user.setEmail("user@example.com");
		user.setConfirmationToken("1234");

		// given existing user
		given(userRepository.findByConfirmationToken("1234")).willReturn(user);

		// when getting user for token
		User loadedUser = registrationService.getUserForToken("1234");

		// then expect correct user to be loaded
		assertThat(loadedUser.getEmail(), is("user@example.com"));

	}

	@Test
	public void givenNewUserWhenRegisteringUserThenVerifyEmailWasSentWithCorrectFrom() {

		User user = new User();
		user.setEmail("user@example.com");

		// given user
		given(userRepository.findOneByEmail("user@example.com")).willReturn(user);

		// when registering new user
		registrationService.registerUser(user);

		// then email was sent
		verify(emailService).sendEmail(mailMessageCaptor.capture());

		SimpleMailMessage mail = mailMessageCaptor.getValue();
		assertThat(mail.getFrom(), is("noreply@gigsterous.com"));

	}

	@Test
	public void givenTokenAndPasswordWhenConfirmingUserThenVerifyUserWasSavedAndEnabled() {

		User user = new User();
		user.setEmail("user@example.com");
		user.setConfirmationToken("1234");
		user.setEnabled(false);
		user.setPassword(null);

		// given existing user
		given(userRepository.findByConfirmationToken("1234")).willReturn(user);
		given(bCryptPasswordEncoder.encode("password")).willReturn("encoded");

		// when confirming user
		registrationService.confirmUser("1234", "password");

		// then expect user to be updated
		verify(userRepository).save(userCaptor.capture());

		User updatedUser = userCaptor.getValue();
		assertThat(updatedUser.isEnabled(), is(true));
		assertThat(updatedUser.getPassword(), is("encoded"));

	}

}
