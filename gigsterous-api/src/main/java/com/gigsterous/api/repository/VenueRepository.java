package com.gigsterous.api.repository;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Venue;

@Repository
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
	
	public Collection<Venue> findAll();

}
