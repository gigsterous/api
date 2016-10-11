package com.gigsterous.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "venues")
@Getter
@Setter
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "venue_id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lon")
	private double lon;
	
}
