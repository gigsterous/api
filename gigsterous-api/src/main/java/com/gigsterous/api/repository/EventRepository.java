package com.gigsterous.api.repository;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	public Collection<Event> findAll();

}
