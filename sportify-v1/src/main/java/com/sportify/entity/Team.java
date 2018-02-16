package com.sportify.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Crispin A.
 *
 */
@Entity
@Table(name = "TEAMS")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private League league;
	private String name;
	private String alias;
	private String stadium;

	public Team() {

	}

	public Team(League league, String name, String alias, String stadium) {
		this.league = league;
		this.name = name;
		this.alias = alias;
		this.stadium = stadium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", league=" + league + ", name=" + name + ", alias=" + alias + ", stadium=" + stadium
				+ "]";
	}

}