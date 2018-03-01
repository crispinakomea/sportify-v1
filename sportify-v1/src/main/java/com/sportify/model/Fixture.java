package com.sportify.model;

public class Fixture {

	private String HomeTeam;
	private String AwayTeam;
	private int FTHG;
	private int FTAG;
	private char FTR;

	public Fixture() {

	}

	public Fixture(String homeTeam, String awayTeam, int fTHG, int fTAG, char fTR) {
		HomeTeam = homeTeam;
		AwayTeam = awayTeam;
		FTHG = fTHG;
		FTAG = fTAG;
		FTR = fTR;
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

}
