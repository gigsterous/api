package com.gigsterous.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gigsterous.api.model.Event;
import com.gigsterous.api.model.Venue;
import com.gigsterous.api.repository.EventRepository;
import com.gigsterous.api.repository.PersonRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EventController.class, secure = true)
public class EventControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EventRepository eventRepo;
	
	@MockBean
	private PersonRepository personRepo;

	private Event testEvent;

	@Before
	public void init() {
		testEvent = new Event();
		testEvent.setId(1l);
		testEvent.setName("Party");
		testEvent.setStartDate(LocalDateTime.of(2016, 12, 12, 20, 30));
		
		Venue venue = new Venue();
		venue.setId(1l);
		venue.setLat(0.0);
		venue.setLat(0.0);
		venue.setName("Club");
		
		testEvent.setVenue(venue);
	}

	@Test
	@WithMockUser(username = "john@email.cz", password = "password")
	public void responseOkEventTest() throws Exception {
		given(eventRepo.findOne(1l)).willReturn(testEvent);
		mvc.perform(get("/events/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Party")))
				.andExpect(jsonPath("$.startDate", is("2016-12-12 20:30")));
	}
	
	@Test
	@WithMockUser(username = "john@email.cz", password = "password")
	public void responseNotFoundEventTest() throws Exception {
		mvc.perform(get("/events/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}
	
	@Test
	@WithMockUser(username = "john@email.cz", password = "password")
	public void responseOkEventsTest() throws Exception {
		mvc.perform(get("/events").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(username = "john@email.cz", password = "password")
	public void createEventTriggersOwnerSearchAndSavesTest() throws Exception {	
		String eventJson = "{ \"name\" : \"test\" }";
		
		mvc.perform(post("/events").content(eventJson).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
		
		// check that we searched for the user creating this event
		Mockito.verify(personRepo, Mockito.times(1)).findByEmail("john@email.cz");
		
		// check that we performed save operation
		Mockito.verify(eventRepo, Mockito.times(1)).save(Mockito.any(Event.class));
		
	}

}