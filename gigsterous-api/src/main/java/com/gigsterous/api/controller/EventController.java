package com.gigsterous.api.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public Collection<Event> getEvents() {
		log.debug("GET - events");

		return eventRepo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Event getEvent(@PathVariable long id, HttpServletResponse response) {
		log.debug("GET - event {}", id);
		
		Event event = eventRepo.findOne(id);
		
		if (event != null) {
			return event;
		} else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			
			return null;
		}
	}

}
