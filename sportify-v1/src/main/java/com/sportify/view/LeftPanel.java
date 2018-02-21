package com.sportify.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sportify.view.component.LeagueSelectPanel;
import com.sportify.view.component.LogoPanel;

@SuppressWarnings("serial")
public class LeftPanel extends JPanel {

	private LeagueSelectPanel leagueSelectPanel;

	public LeftPanel() {
		leagueSelectPanel = new LeagueSelectPanel();

		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(210, 560));
		setBorder(new EmptyBorder(0, 5, 0, 0));
		setLayout(new BorderLayout());
	}

	private void addTo() {
		add(new LogoPanel(), BorderLayout.NORTH);
		add(leagueSelectPanel, BorderLayout.CENTER);
	}

	public void injectRightPanel(RightPanel rightPanel) {
		leagueSelectPanel.injectRightPanel(rightPanel);
	}

	public LeagueSelectPanel getLeagueSelectPanel() {
		return leagueSelectPanel;
	}

}
