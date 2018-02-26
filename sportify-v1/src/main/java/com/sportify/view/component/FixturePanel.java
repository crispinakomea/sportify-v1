package com.sportify.view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sportify.model.Fixture;
import com.sportify.utility.BadgeUtil;
import com.sportify.utility.CustomGridBag;

@SuppressWarnings("serial")
public class FixturePanel extends JPanel {

	private FixtureBox[] recentFixtures;
	private final int COUNT = 8;

	public FixturePanel() {
		recentFixtures = new FixtureBox[COUNT];
		for (int i = 0; i < recentFixtures.length; i++)
			recentFixtures[i] = new FixtureBox();

		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(210, getPreferredSize().height));
		Border titledBorder = new TitledBorder(BorderFactory.createTitledBorder("Recent Fixtures"));
		Border paddedBorder = new EmptyBorder(20, 0, 0, 0);
		setBorder(new CompoundBorder(titledBorder, paddedBorder));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void addTo() {
		for (FixtureBox fixture : recentFixtures)
			add(fixture);
		validate();
	}

	public void setHomeFixtures(Fixture[] fixtures) {
		recentFixtures[0].setFixtureBox(fixtures[0], 48);
		for (int i = 1; i < COUNT / 2; i++) {
			recentFixtures[i].setFixtureBox(fixtures[i], 30);
		}
	}

	public void setAwayFixtures(Fixture[] fixtures) {
		recentFixtures[COUNT / 2].setFixtureBox(fixtures[0], 48);
		for (int i = 1; i < COUNT / 2; i++) {
			recentFixtures[i + (COUNT / 2)].setFixtureBox(fixtures[i], 30);
		}
	}

	public void clearHomeFixtures() {
		for (int i = 0; i < COUNT / 2; i++)
			recentFixtures[i].clearFixtureBox();
	}

	public void clearAwayFixtures() {
		for (int i = 0; i < COUNT / 2; i++)
			recentFixtures[i + (COUNT / 2)].clearFixtureBox();
	}
	
	public void clearFixtures() {
		for (int i = 0; i < COUNT; i++)
			recentFixtures[i].clearFixtureBox();
	}

}

@SuppressWarnings("serial")
class FixtureBox extends CustomGridBag {

	private JLabel homeLogo, score, awayLogo;

	public FixtureBox() {
		homeLogo = new JLabel("", SwingConstants.CENTER);
		score = new JLabel("     -     ", SwingConstants.CENTER);
		score.setFont(new Font("Calibri", Font.BOLD, 14));
		score.setBorder(new EmptyBorder(2, 2, 2, 2));
		score.setOpaque(true);
		score.setBackground(Color.darkGray);
		score.setForeground(Color.white);
		awayLogo = new JLabel("", SwingConstants.CENTER);

		addTo();
	}

	private void addTo() {
		addComponent(this, homeLogo, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		addComponent(this, score, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		addComponent(this, awayLogo, 2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
	}

	public void setFixtureBox(Fixture fixture, int size) {
		String path = "src/main/resources/img/badge/" + fixture.getHomeTeam() + ".png";
		homeLogo.setIcon(BadgeUtil.getBadge(path, size));
		score.setText(" " + fixture.getFTHG() + " - " + fixture.getFTAG() + " ");
		path = "src/main/resources/img/badge/" + fixture.getAwayTeam() + ".png";
		awayLogo.setIcon(BadgeUtil.getBadge(path, size));
	}

	public void clearFixtureBox() {
		homeLogo.setIcon(null);
		score.setText("     -     ");
		awayLogo.setIcon(null);
	}

}