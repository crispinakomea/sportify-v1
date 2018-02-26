package com.sportify.view.component;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sportify.utility.CustomJList;
import com.sportify.utility.HibernateUtil;
import com.sportify.view.RightPanel;

@SuppressWarnings("serial")
public class LeagueSelectPanel extends JPanel {

	private JScrollPane scrollPane;
	private CustomJList leageList;

	private RightPanel rightPanel;

	private ListSelectionListener leagueListSelectionListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String league;
			if (!e.getValueIsAdjusting()) {
				league = leageList.getSelectedValue();
				rightPanel.getTeamSelectPanel().setTeams(league);
				rightPanel.getTeamSelectPanel().clearBadges();
				rightPanel.getStatisticPanel().cleaStatistics();
				rightPanel.getFixturePanel().clearFixtures();
			}
		}
	};

	public LeagueSelectPanel() {
		String query = "select league.name from League league";
		@SuppressWarnings("unchecked")
		List<String> leagues = (ArrayList<String>) HibernateUtil.executeListQuery(query);
		String[] list = leagues.toArray(new String[leagues.size()]);
		leageList = new CustomJList(list);
		leageList.addListSelectionListener(leagueListSelectionListener);

		scrollPane = new JScrollPane(leageList);
		scrollPane.setPreferredSize(new Dimension(180, 350));

		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(210, getPreferredSize().height));
		setBorder(BorderFactory.createTitledBorder("Select League"));
	}

	private void addTo() {
		add(scrollPane);
	}

	public void injectRightPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public CustomJList getLeageList() {
		return leageList;
	}

}
