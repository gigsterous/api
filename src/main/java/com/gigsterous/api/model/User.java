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

import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name = "users")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<Ensemble> getEnsembles() {
		return ensembles;
	}

	public void setEnsembles(Set<Ensemble> ensembles) {
		this.ensembles = ensembles;
	}

}
