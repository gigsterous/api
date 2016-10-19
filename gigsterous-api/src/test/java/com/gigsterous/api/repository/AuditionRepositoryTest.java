package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import com.gigsterous.api.model.Audition;
import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuditionRepositoryTest {

	@Autowired
	private AuditionRepository repository;

	private Audition audition; // test audition

	@Before
	public void prepare() {
		audition = new Audition();
		audition.setId(1l);
		audition.setInstrument(Instrument.BASS);
		audition.setLevel(Level.ADVANCED);
		audition.setEvent(null);
		audition.setOwner(null);
		
		repository.save(audition);
	}

	@Test
	public void repositoryRetrievesAudition() {
		Audition result = repository.findOne(1l);

		assertEquals(result.getInstrument(), Instrument.BASS);
		assertEquals(result.getLevel(), Level.ADVANCED);
	}

}