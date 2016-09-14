package com.gigsterous.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<Collection<Ensemble>> getEnsembles() {
		log.debug("GET - ensembles");

		return new ResponseEntity<>(ensembleRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ensemble> getEnsemble(@PathVariable long id) {
		log.debug("GET - ensemble {}", id);

		Ensemble ensemble = ensembleRepo.findOne(id);

		if (ensemble != null) {
			return new ResponseEntity<>(ensemble, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
