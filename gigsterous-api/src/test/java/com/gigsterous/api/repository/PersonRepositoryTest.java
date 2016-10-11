package com.gigsterous.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import com.gigsterous.api.model.Person;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void repositorySavesAndRetrievesPerson() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        
        repository.save(person);
    	
        Person result = repository.findOne(1l);
        
        assertEquals(result.getFirstName(), "John");
        assertEquals(result.getLastName(), "Doe");
    }

}