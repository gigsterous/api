package com.gigsterous.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	public Page<Person> findAll(Pageable pageable);
	public Person findByEmail(String email);

}
