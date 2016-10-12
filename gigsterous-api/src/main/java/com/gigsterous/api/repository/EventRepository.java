package com.gigsterous.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	public Page<Event> findAll(Pageable pageable);

}
