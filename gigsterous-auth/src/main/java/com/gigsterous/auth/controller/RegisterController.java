package com.gigsterous.auth.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gigsterous.auth.model.User;
import com.gigsterous.auth.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RegisterController {

	private final RegistrationService registrationService;

	public RegisterController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	// Return registration form template
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		
		return modelAndView;
	}

	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user,
			BindingResult bindingResult, HttpServletRequest request) {
		log.debug("User registration - POST");

		if (registrationService.isUserRegistered(user)) {
			log.warn("This user already exists: {}", user);

			modelAndView.addObject("alreadyRegisteredMessage",
					"Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else { // new user so we create user and send confirmation e-mail
			registrationService.registerUser(user);

			modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
			modelAndView.setViewName("register");
		}

		return modelAndView;
	}

	// Process confirmation link
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {

		User user = registrationService.getUserForToken(token);

		if (user == null) { // No token found in DB
			modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
		} else { // Token found
			modelAndView.addObject("confirmationToken", user.getConfirmationToken());
		}

		modelAndView.setViewName("confirm");
		return modelAndView;
	}

	// Process confirmation link
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult,
			@RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
		log.debug("Confirm endpoint - POST");

		modelAndView.setViewName("confirm");

		registrationService.confirmUser(requestParams.get("token"), requestParams.get("password"));

		modelAndView.addObject("successMessage", "Your password has been set!");
		return modelAndView;
	}

}