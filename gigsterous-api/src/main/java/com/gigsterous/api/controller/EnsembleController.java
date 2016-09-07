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
import com.gigsterous.api.repository.EnsembleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ensembles")
public class EnsembleController {

	@Autowired
	private EnsembleRepository ensembleRepo;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Ensemble> getEnsembles() {
		log.debug("GET - ensembles");

		return ensembleRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Ensemble getEnsemble(@PathVariable long id, HttpServletResponse response) {
		log.debug("GET - ensemble {}", id);

		Ensemble ensemble = ensembleRepo.findOne(id);

		if (ensemble != null) {
			return ensemble;
		} else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			
			return null;
		}
	}

}
