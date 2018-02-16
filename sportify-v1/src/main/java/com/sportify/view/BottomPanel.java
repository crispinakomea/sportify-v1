package com.sportify.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BottomPanel extends JPanel {

	private JButton updateButton;
	private JButton clearButton;

	public BottomPanel() {
		updateButton = new JButton("Update");
		clearButton = new JButton("Clear");

		updateButton.setBounds(25, 7, 74, 26);
		clearButton.setBounds(710, 7, 74, 26);

		initializeJPanel();
		addToJPanel();
	}

	private void initializeJPanel() {
		setPreferredSize(new Dimension(800, 40));
		setLayout(null);
	}

	private void addToJPanel() {
		add(updateButton);
		add(clearButton);
	}

}
