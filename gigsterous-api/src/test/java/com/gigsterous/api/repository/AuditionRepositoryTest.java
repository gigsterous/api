package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import com.gigsterous.api.model.Audition;
import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuditionRepositoryTest {

	@Autowired
	private AuditionRepository auditionRepository;

	@Test
	public void retrievesAllAuditions() {
		Page<Audition> auditions = auditionRepository.findAll(new PageRequest(0, 10));

		assertEquals(2, auditions.getTotalElements());
	}

	@Test
	public void retrievesAuditionById() {
		Audition result = auditionRepository.findOne(1l);

		assertEquals(Instrument.GUITAR, result.getInstrument());
		assertEquals(Level.ADVANCED, result.getLevel());
		assertEquals(1l, result.getEvent().getId());
		assertEquals(1l, result.getOwner().getId());
	}

}