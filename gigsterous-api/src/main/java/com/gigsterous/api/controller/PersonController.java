package com.gigsterous.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.Person;
import com.gigsterous.api.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("people")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepo;
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Person> getPeople() {
		log.debug("GET - people");
		
        return personRepo.findAll();
    }

}
