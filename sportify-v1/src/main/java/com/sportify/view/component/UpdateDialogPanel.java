package com.sportify.view.component;

import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class UpdateDialogPanel extends JDialog {

	private JLabel topLabel;
	private JProgressBar progressbar;
	private JLabel bottomLabel;

	public UpdateDialogPanel() {
		topLabel = new JLabel("Update in progress...");
		progressbar = new JProgressBar();
		bottomLabel = new JLabel();

		topLabel.setBounds(43, 20, 300, 20);
		progressbar.setBounds(40, 50, 360, 10);
		bottomLabel.setBounds(43, 65, 300, 20);

		initialize();
		addTo();
	}

	private void initialize() {
		setSize(new Dimension(440, 140));
		setLocationRelativeTo(null);
		setTitle("Update");
		setResizable(false);
		setLayout(null);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	}

	private void addTo() {
		add(topLabel);
		add(progressbar);
		add(bottomLabel);
	}

	public JProgressBar getProgressbar() {
		return progressbar;
	}

	public JLabel getBottomlabel() {
		return bottomLabel;
	}

}
