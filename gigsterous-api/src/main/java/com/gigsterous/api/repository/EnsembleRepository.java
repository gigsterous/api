package com.gigsterous.api.repository;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gigsterous.api.model.Ensemble;

@Repository
public interface EnsembleRepository extends PagingAndSortingRepository<Ensemble, Long> {
	
	public Collection<Ensemble> findAll();

}
