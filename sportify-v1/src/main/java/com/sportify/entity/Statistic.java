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
@Table(name = "STATISTICS")
public class Statistic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private League league;
	
	private String Date;
	private String HomeTeam;
	private String AwayTeam;
	private int FTHG;
	private int FTAG;
	private char FTR;
	private int HTHG;
	private int HTAG;
	private char HTR;
	private String Referee;

	public Statistic() {

	}

	public Statistic(int id, League league, String date, String homeTeam, String awayTeam, int fTHG, int fTAG, char fTR,
			int hTHG, int hTAG, char hTR, String referee) {
		this.id = id;
		this.league = league;
		Date = date;
		HomeTeam = homeTeam;
		AwayTeam = awayTeam;
		FTHG = fTHG;
		FTAG = fTAG;
		FTR = fTR;
		HTHG = hTHG;
		HTAG = hTAG;
		HTR = hTR;
		Referee = referee;
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

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getHomeTeam() {
		return HomeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		HomeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return AwayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		AwayTeam = awayTeam;
	}

	public int getFTHG() {
		return FTHG;
	}

	public void setFTHG(int fTHG) {
		FTHG = fTHG;
	}

	public int getFTAG() {
		return FTAG;
	}

	public void setFTAG(int fTAG) {
		FTAG = fTAG;
	}

	public char getFTR() {
		return FTR;
	}

	public void setFTR(char fTR) {
		FTR = fTR;
	}

	public int getHTHG() {
		return HTHG;
	}

	public void setHTHG(int hTHG) {
		HTHG = hTHG;
	}

	public int getHTAG() {
		return HTAG;
	}

	public void setHTAG(int hTAG) {
		HTAG = hTAG;
	}

	public char getHTR() {
		return HTR;
	}

	public void setHTR(char hTR) {
		HTR = hTR;
	}

	public String getReferee() {
		return Referee;
	}

	public void setReferee(String referee) {
		Referee = referee;
	}

	@Override
	public String toString() {
		return "Statistic [id=" + id + ", League=" + league + ", Date=" + Date + ", HomeTeam=" + HomeTeam
				+ ", AwayTeam=" + AwayTeam + ", FTHG=" + FTHG + ", FTAG=" + FTAG + ", FTR=" + FTR + ", HTHG=" + HTHG
				+ ", HTAG=" + HTAG + ", HTR=" + HTR + ", Referee=" + Referee + "]";
	}

}
