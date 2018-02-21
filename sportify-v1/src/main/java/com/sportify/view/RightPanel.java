package com.sportify.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sportify.view.component.FixturePanel;
import com.sportify.view.component.StatisticPanel;
import com.sportify.view.component.TeamSelectPanel;

@SuppressWarnings("serial")
public class RightPanel extends JPanel {

	private JPanel centerPanel;
	private JPanel rightPanel;
	private TeamSelectPanel teamSelectPanel;
	private StatisticPanel statisticPanel;
	private FixturePanel fixturePanel;
	private JTextArea textArea;

	public RightPanel() {
		initialzeRightPanel();
		initialzeCenterPanel();

		centerPanel.add(teamSelectPanel, BorderLayout.NORTH);

		textArea = new JTextArea(7, 1);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		initialize();
		addTo();
	}

	private void initialzeRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(210, getPreferredSize().height));
		rightPanel.setBorder(new EmptyBorder(0, 2, 2, 0));
		rightPanel.setLayout(new BorderLayout());
		fixturePanel = new FixturePanel();
		rightPanel.add(fixturePanel, BorderLayout.CENTER);
	}
	
	private void initialzeCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(400, getPreferredSize().height));
		centerPanel.setBorder(new EmptyBorder(0, 0, 2, 0));
		centerPanel.setLayout(new BorderLayout());
		statisticPanel = new StatisticPanel();
		teamSelectPanel = new TeamSelectPanel();
		teamSelectPanel.injectStatisticPanel(statisticPanel);
		teamSelectPanel.injectFixturePanel(fixturePanel);
		centerPanel.add(statisticPanel, BorderLayout.CENTER);
	}

	private void initialize() {
		setPreferredSize(new Dimension(610, 560));
		setBorder(new EmptyBorder(0, 2, 0, 5));
		setLayout(new BorderLayout());
	}

	private void addTo() {
		add(centerPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.CENTER);
		add(new JScrollPane(textArea), BorderLayout.SOUTH);
	}

	public TeamSelectPanel getTeamSelectPanel() {
		return teamSelectPanel;
	}

	public StatisticPanel getStatisticPanel() {
		return statisticPanel;
	}

	public FixturePanel getFixturePanel() {
		return fixturePanel;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
}
