package com.gigsterous.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gigsterous.api.repository.PersonRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = true)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PersonRepository personRepo;
	
	@Test
	@WithMockUser(username = "john@email.cz", password = "password")
	public void authorizedUserTest() throws Exception {
	    this.mvc.perform(get("/user")).andExpect(status().isOk());
	}
	
	@Test
	public void unauthorizedUserTest() throws Exception {
	    this.mvc.perform(get("/user")).andExpect(status().isUnauthorized());
	}

}