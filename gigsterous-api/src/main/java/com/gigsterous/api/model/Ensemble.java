package com.gigsterous.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gigsterous.api.model.enums.EnsembleType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ensembles")
@Getter
@Setter
public class Ensemble {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ensemble_id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "ensemble_type")
	@Enumerated(EnumType.STRING)
	private EnsembleType ensembleType;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "people_ensembles", joinColumns = @JoinColumn(name = "ensemble_id", referencedColumnName = "ensemble_id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
	private Set<Person> people = new HashSet<Person>();

	protected Ensemble() {
		// hibernate
	}

}
