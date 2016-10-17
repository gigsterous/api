package com.gigsterous.api.controller;

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
import com.gigsterous.api.repository.EnsembleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ensembles")
public class EnsembleController {

	@Autowired
	private EnsembleRepository ensembleRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Ensemble>> getEnsembles(
			@RequestParam(value = "from", required = false, defaultValue = "0") int from,
			@RequestParam(value = "to", required = false, defaultValue = "20") int to) {
		log.debug("GET - ensembles");

		return new ResponseEntity<>(ensembleRepo.findAll(new PageRequest(from, to)), HttpStatus.OK);
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
