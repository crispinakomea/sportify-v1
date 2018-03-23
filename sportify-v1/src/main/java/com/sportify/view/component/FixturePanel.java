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

import org.hibernate.Session;

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
public class FixturePanel extends JPanel {

	private FixtureBox[] recentFixtures;
	private final int COUNT = 8;

	/**
	 * 
	 * <code>FixturePanel</code> populated with 8 empty FixtureBoxes on
	 * instantiation. 4 for the home team and 4 for the away team.
	 * 
	 */
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

	/**
	 * 
	 * Populates the home/top side of the FixturePanel with the data from the array
	 * of <code>Fixture</code> objects passed as argument.
	 * 
	 * @param fixtures
	 */
	public void setHomeFixtures(Fixture[] fixtures) {
		recentFixtures[0].setFixtureBox(fixtures[0], 0.32);
		for (int i = 1; i < COUNT / 2; i++) {
			recentFixtures[i].setFixtureBox(fixtures[i], 0.2);
		}
	}

	/**
	 * 
	 * Populates the away/bottom side of the FixturePanel with the data from the
	 * array of <code>Fixture</code> objects passed as argument.
	 * 
	 * @param fixtures
	 */
	public void setAwayFixtures(Fixture[] fixtures) {
		recentFixtures[COUNT / 2].setFixtureBox(fixtures[0], 0.32);
		for (int i = 1; i < COUNT / 2; i++) {
			recentFixtures[i + (COUNT / 2)].setFixtureBox(fixtures[i], 0.2);
		}
	}

	/**
	 * 
	 * Empties the home team fixtures. The <code>FixtureBoxes</code> on the top
	 * half.
	 * 
	 */
	public void clearHomeFixtures() {
		for (int i = 0; i < COUNT / 2; i++)
			recentFixtures[i].clearFixtureBox();
	}

	/**
	 * 
	 * Empties the away team fixtures. The <code>FixtureBoxes</code> on the bottom
	 * half.
	 * 
	 */
	public void clearAwayFixtures() {
		for (int i = 0; i < COUNT / 2; i++)
			recentFixtures[i + (COUNT / 2)].clearFixtureBox();
	}

	/**
	 * 
	 * Clears the entire <code>FixturePanel</code>.
	 * 
	 */
	public void clearFixtures() {
		for (int i = 0; i < COUNT; i++)
			recentFixtures[i].clearFixtureBox();
	}

}

@SuppressWarnings("serial")
class FixtureBox extends CustomGridBag {

	private JLabel homeLogo, score, awayLogo;

	/**
	 * <code>FixtureBox</code> instantiated with 3 labels, homeLogo, score and
	 * awayLogo.
	 * 
	 */
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

	/**
	 * 
	 * Sets the text of the score label with the results in the fixture object
	 * passes as an argument. The home and away badges are also set depending on the
	 * teams in the <code>fixture</code> object. The size of the badges is
	 * determined by the <code>size</code> argument.
	 * 
	 * @param fixture
	 * @param size
	 */
	public void setFixtureBox(Fixture fixture, double size) {
		String hql = "from Team t where t.alias = :alias";
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Team teamObj = (Team) session.createQuery(hql).setParameter("alias", fixture.getHomeTeam()).getSingleResult();
		session.getTransaction().commit();
		session.close();
		String path = "src/main/resources/img/badge/" + teamObj.getName() + ".png";
		homeLogo.setIcon(BadgeUtil.getBadge(path, size));
		score.setText(" " + fixture.getFTHG() + " - " + fixture.getFTAG() + " ");
		session = HibernateUtil.openSession();
		session.beginTransaction();
		teamObj = (Team) session.createQuery(hql).setParameter("alias", fixture.getAwayTeam()).getSingleResult();
		session.getTransaction().commit();
		session.close();
		path = "src/main/resources/img/badge/" + teamObj.getName() + ".png";
		awayLogo.setIcon(BadgeUtil.getBadge(path, size));
	}

	/**
	 * 
	 * Clears the badges and score line in the <code>FixtureBox</code>.
	 * 
	 */
	public void clearFixtureBox() {
		homeLogo.setIcon(null);
		score.setText("     -     ");
		awayLogo.setIcon(null);
	}

}