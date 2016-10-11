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

import com.gigsterous.api.model.Event;
import com.gigsterous.api.model.Venue;
import com.gigsterous.api.repository.EventRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EventController.class, secure = false)
public class EventControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EventRepository eventRepo;

	private Event testEvent;

	@Before
	public void init() {
		testEvent = new Event();
		testEvent.setId(1l);
		testEvent.setName("Party");
		testEvent.setDate(new Timestamp(0));
		
		Venue venue = new Venue();
		venue.setId(1l);
		venue.setLat(0.0);
		venue.setLat(0.0);
		venue.setName("Club");
		
		testEvent.setVenue(venue);
	}

	@Test
	public void responseOkPersonTest() throws Exception {
		given(this.eventRepo.findOne(1l)).willReturn(testEvent);
		mvc.perform(get("/events/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Party")))
				.andExpect(jsonPath("$.lastName", is("Doe")))
				.andExpect(jsonPath("$.location", is("London")))
				.andExpect(jsonPath("$.email", is("john@doe.com")))
				.andExpect(jsonPath("$.gender", is("MALE")));
	}

}