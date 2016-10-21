package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import com.gigsterous.api.model.Venue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VenueRepositoryTest {

	@Autowired
	private VenueRepository repository;

	@Test
	public void retrievesVenueById() {
		Venue result = repository.findOne(1l);

		assertEquals("Vagon Klub", result.getName());
	}

}