package com.gigsterous.api.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import com.gigsterous.api.model.Audition;
import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

public class AuditionTest {

	@Test
	public void auditionIsCreatedCorrectly() {
		Person person = new Person();
		person.setFirstName("John");
		
		Event event = new Event();
		event.setName("Party");
		
		Audition audition = new Audition();
		audition.setId(1l);
		audition.setEvent(event);
		audition.setOwner(person);
		audition.setCandidates(new HashSet<>());
		audition.setSelectedMusician(null);
		audition.setInstrument(Instrument.PIANO);
		audition.setLevel(Level.ADVANCED);
		
		assertEquals(1l, audition.getId());
		assertEquals(event, audition.getEvent());
		assertEquals(person, audition.getOwner());
		assertEquals(0, audition.getCandidates().size());
		assertEquals(null, audition.getSelectedMusician());
		assertEquals(Instrument.PIANO, audition.getInstrument());
		assertEquals(Level.ADVANCED, audition.getLevel());
	}

}