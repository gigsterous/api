package com.gigsterous.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Venue;

@Repository
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
	
	public Page<Venue> findAll(Pageable pageable);

}
