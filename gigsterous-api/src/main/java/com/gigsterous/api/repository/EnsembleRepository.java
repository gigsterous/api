package com.gigsterous.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gigsterous.api.model.Ensemble;

@RepositoryRestResource(collectionResourceRel = "ensembles", path = "ensembles")
public interface EnsembleRepository extends PagingAndSortingRepository<Ensemble, Long> {

}
