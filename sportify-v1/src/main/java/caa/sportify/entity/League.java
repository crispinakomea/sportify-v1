package caa.sportify.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Crispin A.
 *
 */
@Entity
@Table(name = "LEAGUES")
public class League {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String division;
	private String name;
	private Date season_start;
	private Date season_end;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "league")
	private Set<Team> teams;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "league")
	private Set<Statistic> statistics;

	public League() {

	}

	public League(String division, String name, Date season_start, Date season_end, Set<Team> teams,
			Set<Statistic> statistics) {
		this.division = division;
		this.name = name;
		this.season_start = season_start;
		this.season_end = season_end;
		this.teams = teams;
		this.statistics = statistics;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSeason_start() {
		return season_start;
	}

	public void setSeason_start(Date season_start) {
		this.season_start = season_start;
	}

	public Date getSeason_end() {
		return season_end;
	}

	public void setSeason_end(Date season_end) {
		this.season_end = season_end;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Statistic> getStatistics() {
		return statistics;
	}

	public void setStatistics(Set<Statistic> statistics) {
		this.statistics = statistics;
	}

}
