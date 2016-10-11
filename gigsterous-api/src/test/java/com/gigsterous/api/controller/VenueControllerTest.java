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

import com.gigsterous.api.model.Venue;
import com.gigsterous.api.repository.VenueRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VenueController.class, secure = false)
public class VenueControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private VenueRepository venueRepo;

	private Venue testVenue;

	@Before
	public void init() {
		testVenue = new Venue();
		testVenue.setId(1l);
		testVenue.setName("Vagon");
		testVenue.setLat(50.0822);
		testVenue.setLon(14.4180);
	}

	@Test
	public void responseOkVenueTest() throws Exception {
		given(this.venueRepo.findOne(1l)).willReturn(testVenue);
		mvc.perform(get("/venues/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Vagon")))
				.andExpect(jsonPath("$.lat", is(50.0822)))
				.andExpect(jsonPath("$.lon", is(14.4180)));
	}
	
	@Test
	public void responseNotFoundVenueTest() throws Exception {
		mvc.perform(get("/venues/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}
	
	@Test
	public void responseOkVenuesTest() throws Exception {
		mvc.perform(get("/venues").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

}
