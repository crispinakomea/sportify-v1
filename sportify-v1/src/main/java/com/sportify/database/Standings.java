package com.sportify.database;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.sportify.entity.League;
import com.sportify.entity.Standing;
import com.sportify.entity.Statistic;
import com.sportify.entity.Team;
import com.sportify.utility.HibernateUtil;

public class Standings {

	private static Standings singleInstance = null;
	private final String table = "Standing";

	private Standings() {

	}

	public static Standings getInstance() {
		if (singleInstance == null) {
			synchronized (Statistics.class) {
				if (singleInstance == null) {
					singleInstance = new Standings();
				}
			}
		}
		return singleInstance;
	}

	@SuppressWarnings("unchecked")
	public void updateAll() throws MalformedURLException, IOException {
		HibernateUtil.executeUpdate("delete from " + table);
		System.out.println("Standings deleted.");
		List<League> leagues = (ArrayList<League>) HibernateUtil.executeListQuery("from League");
		for (League league : leagues) {
			for (Team team : league.getTeams()) {
				update(team);
				System.out.println(team.getAlias() + " is updating.");
			}
		}
	}

	private void update(Object team) throws MalformedURLException, IOException {
		String name = ((Team) team).getAlias();
		String query = "from Team t where t.name='" + name + "'";
		query = "from Statistic s where s.HomeTeam='" + name + "' or s.AwayTeam='" + name + "'";
		@SuppressWarnings("unchecked")
		List<Statistic> statistics = (ArrayList<Statistic>) HibernateUtil.executeListQuery(query);
		int plays, wins, draws, losses, GF, GA;
		plays = wins = draws = losses = GF = GA = 0;
		for (Statistic statistic : statistics) {
			if (statistic.getHomeTeam().equals(name)) {
				if (statistic.getFTR() == 'H') {
					wins++;
				} else if (statistic.getFTR() == 'D') {
					draws++;
				} else
					losses++;
				GF += statistic.getFTHG();
				GA += statistic.getFTAG();
			} else {
				if (statistic.getFTR() == 'A') {
					wins++;
				} else if (statistic.getFTR() == 'D') {
					draws++;
				} else
					losses++;
				GF += statistic.getFTAG();
				GA += statistic.getFTHG();
			}
			plays++;
		}
		HibernateUtil.saveObject(makeStanding(name, plays, wins, draws, losses, GF, GA, (GF - GA)));
	}

	private Standing makeStanding(String name, int plays, int wins, int draws, int losses, int gF, int gA, int gD) {
		Standing standing = new Standing();
		standing.setName(name);
		standing.setW(wins);
		standing.setD(draws);
		standing.setL(losses);
		standing.setGF(gF);
		standing.setGA(gA);
		standing.setGD(gD);
		return standing;
	}
}
