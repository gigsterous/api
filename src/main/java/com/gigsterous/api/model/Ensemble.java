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

import com.gigsterous.api.model.enums.EnsembleType;
import com.gigsterous.api.model.enums.Gender;

@Entity
@Table(name = "ensembles")
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
	@JoinTable(name = "users_ensembles", joinColumns = @JoinColumn(name = "ensemble_id", referencedColumnName = "ensemble_id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<User> users = new HashSet<User>();

	protected Ensemble() {
		// hibernate
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnsembleType getEnsembleType() {
		return ensembleType;
	}

	public void setEnsembleType(EnsembleType type) {
		this.ensembleType = type;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
