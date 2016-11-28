package com.gigsterous.api.service;

import java.util.Collection;

import com.gigsterous.api.model.Person;

public interface ConnectionsService {
	
	/**
	 * This method returns list of connections of the specified person. 
	 * Currently, these connections are simply the people playing in this person's ensembles.
	 * 
	 * @param person
	 * @return list of connections of the person
	 */
	public Collection<Person> getConnections(Person person);

}
