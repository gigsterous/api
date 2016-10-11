package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import com.gigsterous.api.model.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private EventRepository repository;

    @Test
    public void repositorySavesAndRetrievesEvent() {
        Event event = new Event();
        event.setName("Party");
        
        repository.save(event);
    	
        Event result = repository.findOne(1l);
        
        assertEquals(result.getName(), "Party");
    }

}