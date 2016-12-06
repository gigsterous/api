package com.gigsterous.api.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gigsterous.api.model.Ensemble;
import com.gigsterous.api.model.Person;

@Service
public class ConnectionsServiceImpl implements ConnectionsService {

	@Override
	public Collection<Person> getConnections(Person person) {
		Set<Person> attendeeSuggestions = new HashSet<>();
		
		// add to suggestions all people in this person's ensembles
		for (Ensemble ensemble : person.getEnsembles()) {
			attendeeSuggestions.addAll(ensemble.getPeople());
		}
		
		// do not return the same person that requested connections
		attendeeSuggestions.remove(person);
		
		return attendeeSuggestions;
	}

}
