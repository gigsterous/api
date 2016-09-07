package com.gigsterous.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.Ensemble;
import com.gigsterous.api.repository.EnsembleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ensembles")
public class EnsembleController {
	
	@Autowired
	private EnsembleRepository ensembleRepo;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Ensemble> getEnsembles() {
		log.debug("GET - ensembles");

		return ensembleRepo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Ensemble getEnsemble(@PathVariable long id) {
		log.debug("GET - ensemble {}", id);

		return ensembleRepo.findOne(id);
	}

}
