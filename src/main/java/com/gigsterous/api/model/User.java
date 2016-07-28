package com.gigsterous.api.model;

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
import javax.persistence.Table;

import com.gigsterous.api.model.enums.Gender;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_ensembles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "ensemble_id", referencedColumnName = "ensemble_id"))
	private Set<Ensemble> ensembles = new HashSet<Ensemble>();

	protected User() {
		// empty constuctor for Hibernate
	}

}
