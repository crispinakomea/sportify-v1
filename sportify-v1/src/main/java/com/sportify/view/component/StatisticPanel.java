package com.sportify.view.component;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sportify.utility.CustomGridBag;

@SuppressWarnings("serial")
public class StatisticPanel extends JPanel {

	private StatisticBox[] recentStatistics;
	private String[] rows = new String[] { "stat", "win", "draw", "loss", "GF", "GA", "GD" };

	public StatisticPanel() {
		recentStatistics = new StatisticBox[7];
		recentStatistics[0] = new StatisticBox("", rows[0], "");
		for (int i = 1; i < recentStatistics.length; i++)
			recentStatistics[i] = new StatisticBox("0", rows[i], "0");

		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(400, getPreferredSize().height));
		setBorder(BorderFactory.createTitledBorder("Statistics"));
	}

	private void addTo() {
		for (StatisticBox recentStatistic : recentStatistics)
			add(recentStatistic);
		validate();
	}

	public void setHomeFixtures(String[] statistics) {
		for (int i = 1; i < recentStatistics.length; i++)
			recentStatistics[i].setHomeStat(statistics[i]);
		addTo();
	}

	public void setAwayFixtures(String[] statistics) {
		for (int i = 1; i < recentStatistics.length; i++)
			recentStatistics[i].setHomeStat(statistics[i]);
		addTo();
	}

	public void clearFixtures() {
		removeAll();
	}

}

@SuppressWarnings("serial")
class StatisticBox extends CustomGridBag {

	private JLabel homeStat, stat, awayStat;

	public StatisticBox(String homeStat, String statName, String awayStat) {
		this.homeStat = new JLabel(homeStat, SwingConstants.CENTER);
		stat = new JLabel(statName, SwingConstants.CENTER);
		this.awayStat = new JLabel(awayStat, SwingConstants.CENTER);

		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(390, 30));
		setLayout(new GridLayout(1, 3, 0, 0));
	}

	private void addTo() {
		add(homeStat);
		add(stat);
		add(awayStat);
	}

	public void setHomeStat(String homeStat) {
		this.setHomeStat(homeStat);
	}

	public void setAwayStat(String awayStat) {
		this.setAwayStat(awayStat);
	}
}
