package com.gigsterous.api.model;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private long id;
	
	@Column(name = "venue")
	private String venue;
	
	@Column(name = "event_date")
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	private Timestamp date;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "people_events", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
	private Set<Person> people = new HashSet<Person>();

}
