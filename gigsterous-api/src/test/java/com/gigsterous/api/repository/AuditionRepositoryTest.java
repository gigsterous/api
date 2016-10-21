package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import com.gigsterous.api.model.Audition;
import com.gigsterous.api.model.Event;
import com.gigsterous.api.model.Person;
import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@ActiveProfiles("development")
public class AuditionRepositoryTest {

	@Autowired
	private AuditionRepository auditionRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private PersonRepository personRepository;

	@Test
	public void retrievesAllAuditions() {
		Page<Audition> auditions = auditionRepository.findAll(new PageRequest(0, 10));

		assertEquals(2, auditions.getTotalElements());
	}

	@Test
	public void retrievesAuditionById() {
		Audition result = auditionRepository.findOne(1l);

		assertEquals(result.getInstrument(), Instrument.GUITAR);
		assertEquals(result.getLevel(), Level.ADVANCED);
	}
	
	@Test
	public void savesAuditionWithOwnerAndEventAndRetrievesItBack() {
		Event event = eventRepository.findOne(1l);
		Person person = personRepository.findOne(1l);
		
		Audition audition = new Audition();
		audition.setInstrument(Instrument.DRUMS);
		audition.setLevel(Level.BEGINNER);
		audition.setEvent(event);
		audition.setOwner(person);
		
		auditionRepository.save(audition);
		
		Audition result = auditionRepository.findOne(3l);

		assertEquals(Instrument.DRUMS, result.getInstrument());
		assertEquals(Level.BEGINNER, result.getLevel());
		assertEquals(person.getId(), result.getOwner().getId());
		assertEquals(event.getId(), result.getEvent().getId());
	}

}