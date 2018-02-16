package com.sportify.view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sportify.model.Fixture;
import com.sportify.utility.CustomGridBag;

@SuppressWarnings("serial")
public class FixturePanel extends JPanel {

	private FixtureBox[] recentFixtures;

	public FixturePanel() {
		recentFixtures = new FixtureBox[8];
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

	public void setHomeFixtures(Fixture[] fixtures, String base) {
		removeAll();
		recentFixtures[0] = new FixtureBox(fixtures[0], base);
		for (int i = 1; i < recentFixtures.length / 2; i++) {
			recentFixtures[i] = new FixtureBox(fixtures[i]);
		}
		addTo();
	}

	public void setAwayFixtures(Fixture[] fixtures, String base) {
		removeAll();
		recentFixtures[recentFixtures.length / 2] = new FixtureBox(fixtures[0], base);
		for (int i = 1; i < recentFixtures.length / 2; i++) {
			recentFixtures[i + (recentFixtures.length / 2)] = new FixtureBox(fixtures[i]);
		}
		addTo();
	}

	public void clearFixtures() {
		removeAll();
	}

}

@SuppressWarnings("serial")
class FixtureBox extends CustomGridBag {

	private JLabel homeLogo, score, awayLogo;

	public FixtureBox() {
		homeLogo = new JLabel("", SwingConstants.CENTER);
		score = new JLabel("     -     ", SwingConstants.CENTER);
		score.setFont(new Font("Calibri", Font.BOLD, 15));
		score.setBorder(new EmptyBorder(2, 4, 2, 4));
		score.setOpaque(true);
		score.setBackground(Color.darkGray);
		score.setForeground(Color.white);
		awayLogo = new JLabel("", SwingConstants.CENTER);

		addTo();
	}

	public FixtureBox(Fixture fixture) {
		String image;
		homeLogo = new JLabel("", SwingConstants.CENTER);
		image = "src/main/resources/img/badge/" + fixture.getHomeTeam() + ".png";
		homeLogo.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		score = new JLabel(" " + fixture.getFTHG() + " - " + fixture.getFTAG() + " ", SwingConstants.CENTER);
		score.setFont(new Font("Calibri", Font.BOLD, 15));
		score.setBorder(new EmptyBorder(2, 4, 2, 4));
		score.setOpaque(true);
		score.setBackground(Color.darkGray);
		score.setForeground(Color.white);
		awayLogo = new JLabel("", SwingConstants.CENTER);
		image = "src/main/resources/img/badge/" + fixture.getAwayTeam() + ".png";
		awayLogo.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

		addTo();
	}

	public FixtureBox(Fixture fixture, String base) {
		String image;
		homeLogo = new JLabel("", SwingConstants.CENTER);
		image = "src/main/resources/img/badge/" + fixture.getHomeTeam() + ".png";
		if (base.equals(fixture.getHomeTeam()))
			homeLogo.setIcon(
					new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		else
			homeLogo.setIcon(
					new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		score = new JLabel(" " + fixture.getFTHG() + " - " + fixture.getFTAG() + " ", SwingConstants.CENTER);
		score.setFont(new Font("Calibri", Font.BOLD, 15));
		score.setBorder(new EmptyBorder(2, 4, 2, 4));
		score.setOpaque(true);
		score.setBackground(Color.darkGray);
		score.setForeground(Color.white);
		awayLogo = new JLabel("", SwingConstants.CENTER);
		image = "src/main/resources/img/badge/" + fixture.getAwayTeam() + ".png";
		if (base.equals(fixture.getAwayTeam()))
			awayLogo.setIcon(
					new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		else
			awayLogo.setIcon(
					new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

		addTo();
	}

	private void addTo() {
		addComponent(this, homeLogo, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		addComponent(this, score, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		addComponent(this, awayLogo, 2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
	}
}