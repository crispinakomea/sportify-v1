package com.sportify.view.component;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.hibernate.Session;

import com.sportify.entity.League;
import com.sportify.entity.Standing;
import com.sportify.entity.Statistic;
import com.sportify.entity.Team;
import com.sportify.model.Fixture;
import com.sportify.utility.BadgeUtil;
import com.sportify.utility.CustomGridBag;
import com.sportify.utility.HibernateUtil;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class TeamSelectPanel extends CustomGridBag {

	private JComboBox<String> homeDropdown, awayDropdown;
	private JLabel homeLogo, vsLabel, awayLogo;
	private ImageIcon homeBadge, awayBadge;

	private FixturePanel fixturePanel;
	private StatisticPanel statisticPanel;
	private final int TEAM_FIXTURE_COUNT = 4;

	/**
	 * 
	 * Sets the home team badge, last 4 <code>FixturePanel</code> for and <code>StatisticPanel</code> for
	 * home team.
	 * 
	 */
	private ItemListener homeTeamItemListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			String name;
			if (e.getStateChange() == 1) {
				name = (String) e.getItem();
				if (name != "") {
					setHomeBadge(name);
					String query = "from Team t where t.name='" + name + "'";
					Team teamObj = (Team) HibernateUtil.getSingleResult(query);
					String alias = teamObj.getAlias();
					setHomeFixtures(alias);
					setHomeStatistics(alias);
				}
			} else {
				statisticPanel.clearHomeStatistics();
				fixturePanel.clearHomeFixtures();
			}
		}
	};

	/**
	 * 
	 * Sets the away team badge, last 4 <code>FixturePanel</code> for and <code>StatisticPanel</code> for
	 * away team.
	 * 
	 */
	private ItemListener awayTeamItemListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			String name;
			if (e.getStateChange() == 1) {
				name = (String) e.getItem();
				if (name != "") {
					setAwayBadge(name);
					String query = "from Team t where t.name='" + name + "'";
					Team teamObj = (Team) HibernateUtil.getSingleResult(query);
					String alias = teamObj.getAlias();
					setAwayFixtures(alias);
					setAwayStatistics(alias);
				} else {
					statisticPanel.clearAwayStatistics();
					fixturePanel.clearAwayFixtures();
				}
			}
		}
	};

	public TeamSelectPanel() {
		homeDropdown = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] { "" }));
		awayDropdown = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] { "" }));

		homeDropdown.addItemListener(homeTeamItemListener);
		awayDropdown.addItemListener(awayTeamItemListener);

		homeLogo = new JLabel(homeBadge, SwingConstants.CENTER);
		vsLabel = new JLabel("V", SwingConstants.CENTER);
		awayLogo = new JLabel(awayBadge, SwingConstants.CENTER);

		homeBadge = new ImageIcon();
		awayBadge = new ImageIcon();

		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(400, 150));
		setBorder(BorderFactory.createTitledBorder("Select Teams"));
		setLayout(new GridBagLayout());
	}

	private void addTo() {
		addComponent(this, homeDropdown, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComponent(this, homeDropdown, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComponent(this, awayDropdown, 2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComponent(this, homeLogo, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponent(this, vsLabel, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponent(this, awayLogo, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	}

	public void injectStatisticPanel(StatisticPanel statisticPanel) {
		this.statisticPanel = statisticPanel;
	}

	public void injectFixturePanel(FixturePanel fixturePanel) {
		this.fixturePanel = fixturePanel;
	}

	/**
	 * 
	 * Method for updating the <code>ComboBox</code> for home and away teams when
	 * the league changes.
	 * 
	 * @param league
	 */
	public void setTeams(String league) {
		String query = "from League l where l.name='" + league + "'";
		League leagueObj = (League) HibernateUtil.getSingleResult(query);
		Set<Team> teamSet = leagueObj.getTeams();
		Team[] teamArray = teamSet.toArray(new Team[teamSet.size()]);
		String[] list = new String[teamArray.length + 1];
		list[0] = "";
		for (int i = 0; i < teamArray.length; i++)
			list[i + 1] = teamArray[i].getName();
		Arrays.sort(list, 1, teamArray.length + 1);
		homeDropdown.setModel(new DefaultComboBoxModel<String>(list));
		awayDropdown.setModel(new DefaultComboBoxModel<String>(list));
	}

	/**
	 * 
	 * Updates the home team badge.
	 * 
	 * @param team
	 */
	private void setHomeBadge(String team) {
		String path = "src/main/resources/img/badge/" + team + ".png";
		homeLogo.setIcon(BadgeUtil.getBadge(path, 0.46));
	}

	/**
	 * 
	 * Updates the away team badge.
	 * 
	 * @param team
	 */
	private void setAwayBadge(String team) {
		String path = "src/main/resources/img/badge/" + team + ".png";
		awayLogo.setIcon(BadgeUtil.getBadge(path, 0.46));
	}

	/**
	 * 
	 * Method to clear both badges when a new league is selected.
	 * 
	 */
	public void clearBadges() {
		homeLogo.setIcon(null);
		awayLogo.setIcon(null);
	}

	/**
	 * 
	 * Populates the home/top side of the <code>FixturePanel</code> with the last 4 fixtures of
	 * the home team.
	 * 
	 * @param alias
	 */
	private void setHomeFixtures(String alias) {
		Fixture[] fixtures = new Fixture[TEAM_FIXTURE_COUNT];
		String hql = "from Statistic s where s.HomeTeam= :alias or s.AwayTeam= :alias order by s.id desc";
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Statistic> statistics = (ArrayList<Statistic>) session.createQuery(hql).setParameter("alias", alias)
				.setMaxResults(TEAM_FIXTURE_COUNT).list();
		session.getTransaction().commit();
		session.close();
		for (int i = 0; i < statistics.size(); i++)
			fixtures[i] = new Fixture(statistics.get(i).getHomeTeam(), statistics.get(i).getAwayTeam(),
					statistics.get(i).getFTHG(), statistics.get(i).getFTAG(), statistics.get(i).getFTR());
		fixturePanel.setHomeFixtures(fixtures);
	}

	/**
	 * 
	 * Populates the home/right side of the <code>StatisticPanel</code> with the statistics of
	 * the home team.
	 * 
	 * @param alias
	 */
	private void setHomeStatistics(String alias) {
		String hql = "from Standing s where s.name= :alias ";
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Standing standing = (Standing) session.createQuery(hql).setParameter("alias", alias).getSingleResult();
		session.getTransaction().commit();
		session.close();
		statisticPanel.setHomeFixtures(standing);
	}

	/**
	 * 
	 * Populates the away/bottom side of the <code>FixturePanel</code> with the last 4 fixtures
	 * of the away team.
	 * 
	 * @param alias
	 */
	private void setAwayFixtures(String alias) {
		Fixture[] fixtures = new Fixture[TEAM_FIXTURE_COUNT];
		String hql = "from Statistic s where s.HomeTeam= :alias or s.AwayTeam= :alias order by s.id desc";
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Statistic> statistics = (ArrayList<Statistic>) session.createQuery(hql).setParameter("alias", alias)
				.setMaxResults(TEAM_FIXTURE_COUNT).list();
		session.getTransaction().commit();
		session.close();
		for (int i = 0; i < statistics.size(); i++)
			fixtures[i] = new Fixture(statistics.get(i).getHomeTeam(), statistics.get(i).getAwayTeam(),
					statistics.get(i).getFTHG(), statistics.get(i).getFTAG(), statistics.get(i).getFTR());
		fixturePanel.setAwayFixtures(fixtures);
	}

	/**
	 * 
	 * Populates the away/right side of the <code>StatisticPanel</code> with the statistics of
	 * the away team.
	 * 
	 * @param alias
	 */
	private void setAwayStatistics(String alias) {
		String hql = "from Standing s where s.name= :alias ";
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Standing standing = (Standing) session.createQuery(hql).setParameter("alias", alias).getSingleResult();
		session.getTransaction().commit();
		session.close();
		statisticPanel.setAwayFixtures(standing);
	}

}
