package com.sportify.view.component;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sportify.entity.Standing;

@SuppressWarnings("serial")
public class StatisticPanel extends JPanel {

	private StatisticBox[] recentStatistics;
	private String[] rows = new String[] { "Stat", "win", "draw", "loss", "GF", "GA", "GD" };
	private final int COUNT = 7;

	/**
	 * 
	 * <code>StatisticPanel</code> populated with 6 empty StatisticBoxes on
	 * instantiation. The first <code>StatisticBox</code> is for the header.
	 * 
	 */
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

	/**
	 * 
	 * Populates the home/right side of the <code>StatisticPanel</code> with the
	 * data from the <code>Standing</code> object passed as argument.
	 * 
	 * @param standing
	 */
	public void setHomeFixtures(Standing standing) {
		String[] data = new String[] { standing.getName(), standing.getW() + "", standing.getD() + "",
				standing.getL() + "", standing.getGF() + "", standing.getGA() + "", standing.getGD() + "" };
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].setHomeStat(data[i]);
	}

	/**
	 * 
	 * Populates the away/right side of the StatisticPanel with the data from the
	 * <code>Standing</code> object passed as argument.
	 * 
	 * @param standing
	 */
	public void setAwayFixtures(Standing standing) {
		String[] data = new String[] { standing.getName(), standing.getW() + "", standing.getD() + "",
				standing.getL() + "", standing.getGF() + "", standing.getGA() + "", standing.getGD() + "" };
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].setAwayStat(data[i]);
	}

	/**
	 * 
	 * Clears the data from all <code>StatisticBoxes</code> from the StatisticPanel.
	 * 
	 */
	public void clearStatistics() {
		for (int i = 0; i < recentStatistics.length; i++) {
			recentStatistics[i].clearHomeStatisticBox();
			recentStatistics[i].clearAwayStatisticBox();
		}
	}

	/**
	 * 
	 * Clears the data from the home all <code>StatisticBoxes</code> from the
	 * StatisticPanel.
	 * 
	 */
	public void clearHomeStatistics() {
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].clearHomeStatisticBox();
	}

	/**
	 * 
	 * Clears the data from the away <code>StatisticBoxes</code> from the
	 * StatisticPanel.
	 * 
	 */
	public void clearAwayStatistics() {
		for (int i = 0; i < recentStatistics.length; i++)
			recentStatistics[i].clearAwayStatisticBox();
	}

}

@SuppressWarnings("serial")
class StatisticBox extends JPanel {

	private JLabel homeStat, stat, awayStat;

	/**
	 * 
	 * <code>StatisticBox</code> populated with 3 labels on instantiation. One for
	 * home team statistic, the statistic being compared and away team statistic.
	 * 
	 * @param homeStat
	 * @param statName
	 * @param awayStat
	 */
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

	/**
	 * 
	 * Sets the home team statistic with the value passed as argument.
	 * 
	 * @param homeStat
	 */
	public void setHomeStat(String homeStat) {
		this.homeStat.setText(homeStat);
	}

	/**
	 * 
	 * Sets the away team statistic with the value passed as argument.
	 * 
	 * @param awayStat
	 */
	public void setAwayStat(String awayStat) {
		this.awayStat.setText(awayStat);
	}

	/**
	 * 
	 * Clears both home and away team statistic labels.
	 * 
	 */
	public void clearStatisticBox() {
		homeStat.setText(null);
		awayStat.setText(null);
	}

	/**
	 * 
	 * Clears home team statistic label.
	 * 
	 */
	public void clearHomeStatisticBox() {
		homeStat.setText(null);
	}

	/**
	 * 
	 * Clears away team statistic label.
	 * 
	 */
	public void clearAwayStatisticBox() {
		awayStat.setText(null);
	}
}
