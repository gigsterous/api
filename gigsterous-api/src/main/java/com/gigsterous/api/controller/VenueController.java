package com.gigsterous.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.Venue;
import com.gigsterous.api.repository.VenueRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/venues")
public class VenueController {

	@Autowired
	private VenueRepository venueRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Venue>> getVenues() {
		log.debug("GET - venues");

		return new ResponseEntity<>(venueRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venue> getEnsemble(@PathVariable long id) {
		log.debug("GET - venue {}", id);

		Venue venue = venueRepo.findOne(id);

		if (venue != null) {
			return new ResponseEntity<>(venue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
