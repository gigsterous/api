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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "auditions")
@Getter
@Setter
public class Audition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "audition_id")
	private long id;
	
	@Column(name = "instrument")
	@Enumerated(EnumType.STRING)
	private Instrument instrument;
	
	@Column(name = "level")
	@Enumerated(EnumType.STRING)
	private Level level;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "people_auditions", joinColumns = @JoinColumn(name = "audition_id", referencedColumnName = "audition_id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
	private Set<Person> candidates = new HashSet<Person>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name="owner_id")
	private Person owner;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name="selected_musician_id")
	private Person selectedMusician;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name="event_id")
	private Event event;

}
