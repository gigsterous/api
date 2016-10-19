package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import com.gigsterous.api.model.Audition;
import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuditionRepositoryTest {

    @Autowired
    private AuditionRepository repository;

    @Test
    public void repositorySavesAndRetrievesAudition() {
        Audition audition = new Audition();
        audition.setInstrument(Instrument.BASS);
        audition.setLevel(Level.ADVANCED);
        
        repository.save(audition);
    	
        Audition result = repository.findOne(1l);
        
        assertEquals(result.getInstrument(), Instrument.BASS);
        assertEquals(result.getLevel(), Level.ADVANCED);
    }

}