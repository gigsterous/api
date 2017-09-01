package com.gigsterous.auth.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.gigsterous.auth.model.User;
import com.gigsterous.auth.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = true)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserRepository userRepo;

	@Before
	public void setUp() {
		User user = new User();
		user.setId(1l);
		user.setEmail("john@example.com");

		// mock repository
		given(userRepo.findOneByEmail("john@example.com")).willReturn(user);
	}

	@Test
	@WithMockUser(username = "john@example.com", password = "password")
	public void testGivenUserEndpointWhenGettingCurrentUserThenReturnUserWithIdAsUsername() throws Exception {
		// @formatter:off
		this.mvc.perform(get("/user"))
			.andExpect(
					status().isOk())
			.andExpect(jsonPath("$.username", is("1")));
		// @formatter:on
	}

}
