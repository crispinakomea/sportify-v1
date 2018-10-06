package caa.sportify.database;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import caa.sportify.entity.Standing;
import caa.sportify.entity.Statistic;
import caa.sportify.entity.Team;
import caa.sportify.utility.HibernateUtil;

public class Standings {

	private static Standings singleInstance = null;

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

	/**
	 * 
	 * Updates the standing in the database of the team passed as argument.
	 * 
	 * @param team
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void update(Object team) throws MalformedURLException, IOException {
		String alias = ((Team) team).getAlias();
		String hql = "from Statistic s where s.HomeTeam= :alias or s.AwayTeam= :alias";
		Session session = HibernateUtil.openSession();
		@SuppressWarnings("unchecked")
		List<Statistic> statistics = (ArrayList<Statistic>) session.createQuery(hql).setParameter("alias", alias)
				.list();
		session.close();
		int plays, wins, draws, losses, GF, GA;
		plays = wins = draws = losses = GF = GA = 0;
		for (Statistic statistic : statistics) {
			if (statistic.getHomeTeam().equals(alias)) {
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
		HibernateUtil.save(makeStanding(alias, plays, wins, draws, losses, GF, GA, (GF - GA)));
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
