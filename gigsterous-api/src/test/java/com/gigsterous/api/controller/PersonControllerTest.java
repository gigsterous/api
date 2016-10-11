package com.gigsterous.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gigsterous.api.model.Person;
import com.gigsterous.api.model.enums.Gender;
import com.gigsterous.api.repository.PersonRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class, secure = false)
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonRepository personRepo;

	private Person testPerson;

	@Before
	public void init() {
		testPerson = new Person();
		testPerson.setFirstName("John");
		testPerson.setLastName("Doe");
		testPerson.setGender(Gender.MALE);
		testPerson.setId(1l);
		testPerson.setEmail("john@doe.com");
		testPerson.setLocation("London");
	}

	@Test
	public void responseOkPersonTest() throws Exception {
		given(this.personRepo.findOne(1l)).willReturn(testPerson);
		mvc.perform(get("/people/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.lastName", is("Doe")))
				.andExpect(jsonPath("$.location", is("London")))
				.andExpect(jsonPath("$.email", is("john@doe.com")))
				.andExpect(jsonPath("$.gender", is("MALE")));
	}

	@Test
	public void responseNotFoundPersonTest() throws Exception {
		mvc.perform(get("/people/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}

	@Test
	public void responseOkPepleTest() throws Exception {
		mvc.perform(get("/people").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void responseOkPersonEnsemblesTest() throws Exception {
		given(this.personRepo.findOne(1l)).willReturn(testPerson);
		mvc.perform(get("/people/1/ensembles").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void responseNotFoundPersonEnsemblesTest() throws Exception {
		mvc.perform(get("/people/1/ensembles").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isNotFound());
	}

	@Test
	public void responseOkPersonEventsTest() throws Exception {
		given(this.personRepo.findOne(1l)).willReturn(testPerson);
		mvc.perform(get("/people/1/events").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void responseNotFoundPersonEventsTest() throws Exception {
		mvc.perform(get("/people/1/events").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}

}