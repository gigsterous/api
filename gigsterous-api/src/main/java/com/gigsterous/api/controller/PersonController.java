package com.gigsterous.api.controller;

import java.util.Collection;

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

import com.gigsterous.api.model.Ensemble;
import com.gigsterous.api.model.Event;
import com.gigsterous.api.model.Person;
import com.gigsterous.api.repository.PersonRepository;
import com.gigsterous.api.service.ConnectionsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private ConnectionsService connectionsService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Person>> getPeople(@RequestParam(value = "from", required = false, defaultValue = "0") int from,
			@RequestParam(value = "to", required = false, defaultValue = "20") int to) {
		return new ResponseEntity<>(personRepo.findAll(new PageRequest(from, to)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable long id) {
		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}/ensembles", method = RequestMethod.GET)
	public ResponseEntity<Collection<Ensemble>> getPersonEnsembles(@PathVariable long id) {
		log.debug("GET - ensembles for person {}", id);

		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(person.getEnsembles(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}/events", method = RequestMethod.GET)
	public ResponseEntity<Collection<Event>> getPersonEvents(@PathVariable long id) {
		log.debug("GET - events for person {}", id);

		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(person.getEvents(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}/connections", method = RequestMethod.GET)
	public ResponseEntity<Collection<Person>> getConnections(@PathVariable long id) {
		log.debug("GET -connections for person {}", id);

		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(connectionsService.getConnections(person), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
