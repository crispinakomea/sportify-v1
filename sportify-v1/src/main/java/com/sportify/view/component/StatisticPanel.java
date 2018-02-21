package com.sportify.view.component;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sportify.entity.Standing;
import com.sportify.utility.CustomGridBag;

@SuppressWarnings("serial")
public class StatisticPanel extends JPanel {

	private StatisticBox[] recentStatistics;
	private String[] rows = new String[] { "Stat", "win", "draw", "loss", "GF", "GA", "GD" };
	private final int COUNT = 7;

	public StatisticPanel() {
		recentStatistics = new StatisticBox[COUNT];
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
	}

	public void setHomeFixtures(Standing standing) {
		String[] data = new String[] { standing.getName(), standing.getW() + "", standing.getD() + "",
				standing.getL() + "", standing.getGF() + "", standing.getGA() + "", standing.getGD() + "" };
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].setHomeStat(data[i]);
	}

	public void setAwayFixtures(Standing standing) {
		String[] data = new String[] { standing.getName(), standing.getW() + "", standing.getD() + "",
				standing.getL() + "", standing.getGF() + "", standing.getGA() + "", standing.getGD() + "" };
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].setAwayStat(data[i]);
	}
	
	public void cleaStatistics() {
		for (int i = 0; i < recentStatistics.length; i++) {
			recentStatistics[i].clearHomeStatisticBox();
			recentStatistics[i].clearAwayStatisticBox();
		}
	}

	public void clearHomeStatistics() {
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].clearHomeStatisticBox();
	}

	public void clearAwayStatistics() {
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].clearAwayStatisticBox();
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
		this.homeStat.setText(homeStat);
	}

	public void setAwayStat(String awayStat) {
		this.awayStat.setText(awayStat);
	}

	public void clearStatisticBox() {
		homeStat.setText(null);
		awayStat.setText(null);
	}
	
	public void clearHomeStatisticBox() {
		homeStat.setText(null);
	}

	public void clearAwayStatisticBox() {
		awayStat.setText(null);
	}
}
