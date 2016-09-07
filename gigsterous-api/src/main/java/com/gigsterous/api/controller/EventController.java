package com.gigsterous.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public @ResponseBody Collection<Event> getEvents() {
		log.debug("GET - events");

		return eventRepo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Event getEvent(@PathVariable long id) {
		log.debug("GET - event {}", id);

		return eventRepo.findOne(id);
	}

}
