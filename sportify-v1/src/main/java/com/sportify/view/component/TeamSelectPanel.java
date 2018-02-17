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

import com.sportify.entity.League;
import com.sportify.entity.Standing;
import com.sportify.entity.Statistic;
import com.sportify.entity.Team;
import com.sportify.model.Fixture;
import com.sportify.utility.CustomGridBag;
import com.sportify.utility.HibernateUtil;

@SuppressWarnings("serial")
public class TeamSelectPanel extends CustomGridBag {

	private JComboBox<String> homeDropdown, awayDropdown;
	private JLabel homeLogo, vsLabel, awayLogo;
	private ImageIcon homeBadge, awayBadge;

	private FixturePanel fixturePanel;
	private StatisticPanel statisticPanel;

	private ItemListener homeTeamItemListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			String team;
			if (e.getStateChange() == 1) {
				team = (String) e.getItem();
				if (team != "") {
					setHomeBadge(team);
					String query = "from Team t where t.name='" + team + "'";
					Team teamObj = (Team) HibernateUtil.executeSingleResultQuery(query);

					Fixture[] fixtures = new Fixture[4];
					team = teamObj.getAlias();
					query = "from Statistic s where s.HomeTeam='" + team + "' or s.AwayTeam='" + team
							+ "' order by s.id desc";
					@SuppressWarnings("unchecked")
					List<Statistic> statistics = (ArrayList<Statistic>) HibernateUtil.executeListQuery(query, 4);
					for (int i = 0; i < statistics.size(); i++)
						fixtures[i] = new Fixture(statistics.get(i).getHomeTeam(), statistics.get(i).getAwayTeam(),
								statistics.get(i).getFTHG(), statistics.get(i).getFTAG(), statistics.get(i).getFTR());
					fixturePanel.setHomeFixtures(fixtures);

					query = "from Standing s where s.name='" + team + "'";
					Standing standing = (Standing) HibernateUtil.executeSingleResultQuery(query);
					statisticPanel.setHomeFixtures(standing);
				}
			} else
				statisticPanel.clearHomeStatistics();
		}
	};

	private ItemListener awayTeamItemListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			String team;
			if (e.getStateChange() == 1) {
				team = (String) e.getItem();
				if (team != "") {
					setAwayBadge(team);
					String query = "from Team t where t.name='" + team + "'";
					Team teamObj = (Team) HibernateUtil.executeSingleResultQuery(query);

					Fixture[] fixtures = new Fixture[4];
					team = teamObj.getAlias();
					query = "from Statistic s where s.HomeTeam='" + team + "' or s.AwayTeam='" + team
							+ "' order by s.id desc";
					@SuppressWarnings("unchecked")
					List<Statistic> statistics = (ArrayList<Statistic>) HibernateUtil.executeListQuery(query, 4);
					for (int i = 0; i < statistics.size(); i++)
						fixtures[i] = new Fixture(statistics.get(i).getHomeTeam(), statistics.get(i).getAwayTeam(),
								statistics.get(i).getFTHG(), statistics.get(i).getFTAG(), statistics.get(i).getFTR());
					fixturePanel.setAwayFixtures(fixtures);

					query = "from Standing s where s.name='" + team + "'";
					Standing standing = (Standing) HibernateUtil.executeSingleResultQuery(query);
					statisticPanel.setAwayFixtures(standing);
				} else
					statisticPanel.clearAwayStatistics();
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

	public void setTeams(String league) {
		String query = "from League l where l.name='" + league + "'";
		League leagueObj = (League) HibernateUtil.executeSingleResultQuery(query);
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

	public void setHomeBadge(String team) {
		String query = "from Team t where t.name='" + team + "'";
		Team teamObj = (Team) HibernateUtil.executeSingleResultQuery(query);
		homeBadge = new ImageIcon("src/main/resources/img/badge/" + teamObj.getAlias() + ".png");
		homeLogo.setIcon(homeBadge);
	}

	public void setAwayBadge(String team) {
		String query = "from Team t where t.name='" + team + "'";
		Team teamObj = (Team) HibernateUtil.executeSingleResultQuery(query);
		awayBadge = new ImageIcon("src/main/resources/img/badge/" + teamObj.getAlias() + ".png");
		awayLogo.setIcon(awayBadge);
	}

	public void clearBadges() {
		homeLogo.setIcon(null);
		awayLogo.setIcon(null);
	}
}
