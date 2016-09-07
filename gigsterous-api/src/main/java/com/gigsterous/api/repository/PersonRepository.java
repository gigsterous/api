package com.gigsterous.api.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	public List<Person> findAll();

}
