package com.gigsterous.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gigsterous.api.model.enums.Gender;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name = "people")
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "date_birth")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateOfBirth;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "people_ensembles", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"), inverseJoinColumns = @JoinColumn(name = "ensemble_id", referencedColumnName = "ensemble_id"))
	private Set<Ensemble> ensembles = new HashSet<Ensemble>();
	
	@OneToMany(mappedBy ="person")
	private Set<Skill> skills = new HashSet<Skill>();


	protected Person() {
		// empty constuctor for Hibernate
	}

}