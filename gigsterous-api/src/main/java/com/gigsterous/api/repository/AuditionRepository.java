package com.gigsterous.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Audition;

@Repository
public interface AuditionRepository extends PagingAndSortingRepository<Audition, Long> {
	
	public Page<Audition> findAll(Pageable pageable);

}
