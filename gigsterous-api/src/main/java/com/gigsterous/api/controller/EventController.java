package com.gigsterous.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.Event;
import com.gigsterous.api.repository.EventRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventRepository eventRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Event>> getEvents(
			@RequestParam(value = "from", required = false, defaultValue = "0") int from,
			@RequestParam(value = "to", required = false, defaultValue = "20") int to) {
		log.debug("GET - events");

		return new ResponseEntity<>(eventRepo.findAll(new PageRequest(from, to)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable long id, HttpServletResponse response) {
		log.debug("GET - event {}", id);

		Event event = eventRepo.findOne(id);

		if (event != null) {
			return new ResponseEntity<>(event, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
