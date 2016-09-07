package com.gigsterous.api.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.Ensemble;
import com.gigsterous.api.model.Event;
import com.gigsterous.api.model.Person;
import com.gigsterous.api.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepo;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Person> getPeople() {
		log.debug("GET - people");

		return personRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable long id, HttpServletResponse response) {
		log.debug("GET - person {}", id);
		
		Person person = personRepo.findOne(id);
		
		if (person != null) {
			return person;
		} else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}/ensembles", method = RequestMethod.GET)
	public Collection<Ensemble> getPersonEnsembles(@PathVariable long id, HttpServletResponse response) {
		log.debug("GET - ensembles for person {}", id);
		
		Person person = personRepo.findOne(id);
		
		if (person != null) {
			return person.getEnsembles();
		} else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}/events", method = RequestMethod.GET)
	public Collection<Event> getPersonEvents(@PathVariable long id, HttpServletResponse response) {
		log.debug("GET - events for person {}", id);

		Person person = personRepo.findOne(id);
		
		if (person != null) {
			return person.getEvents();
		} else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			
			return null;
		}
	}

}
