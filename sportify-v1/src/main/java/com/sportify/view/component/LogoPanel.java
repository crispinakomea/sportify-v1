package com.sportify.view.component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class LogoPanel extends JPanel {

	public LogoPanel() {
		initialize();
		addTo();
	}

	private void initialize() {
		setPreferredSize(new Dimension(210, 60));
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void addTo() {
		add(new JLabel("SPORTIFY"));
	}

}