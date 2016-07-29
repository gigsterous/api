package com.gigsterous.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gigsterous.api.model.enums.Instrument;
import com.gigsterous.api.model.enums.Level;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skill_id")
	private long id;

	@Column(name = "instrument")
	@Enumerated(EnumType.STRING)
	private Instrument instrument;
	
	@Column(name = "level")
	@Enumerated(EnumType.STRING)
	private Level level;
	
	@ManyToOne
	@JoinColumn (name="user_id")
	private User user;
	
	protected Skill() {
		// hibernate
	}
}
