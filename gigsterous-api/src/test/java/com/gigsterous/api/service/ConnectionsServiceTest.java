package com.gigsterous.api.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.gigsterous.api.model.Ensemble;
import com.gigsterous.api.model.Person;

import static org.junit.Assert.assertEquals;

public class ConnectionsServiceTest {
	
	private ConnectionsService connectionsService;
	
	private Set<Person> group1;
	private Set<Person> group2;
	private Set<Ensemble> ensembles;
	
	private Person p1, p2, p3;
	
	@Before
	public void init() {
		connectionsService = new ConnectionsServiceImpl();
		
		p1 = new Person();
		p1.setId(1);
		p1.setFirstName("Jack");
		
		p2 = new Person();
		p2.setId(2);
		p2.setFirstName("Karen");
		
		p3 = new Person();
		p3.setId(3);
		p3.setFirstName("Hugo");
		
		group1 = new HashSet<>();
		group1.add(p1);
		group1.add(p2);
		
		group2 = new HashSet<>();
		group2.add(p1);
		group2.add(p3);
		
		Ensemble e1 = new Ensemble();
		e1.setId(1);
		e1.setName("Rockers");
		e1.setPeople(group1);
		
		Ensemble e2 = new Ensemble();
		e2.setId(2);
		e2.setName("Classics");
		e2.setPeople(group2);
		
		ensembles = new HashSet<>();
		ensembles.add(e1);
		ensembles.add(e2);
		
		p1.setEnsembles(ensembles);
	}
	
	@Test
	public void getListOfConnectionsTest() {
		Set<Person> result = new HashSet<>();
		result.add(p2);
		result.add(p3);
		
		assertEquals(2, connectionsService.getConnections(p1).size());
		assertEquals(result, connectionsService.getConnections(p1));
	}

}
