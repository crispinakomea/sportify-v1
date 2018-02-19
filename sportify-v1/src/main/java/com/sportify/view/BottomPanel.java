package com.sportify.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sportify.database.Standings;
import com.sportify.database.Statistics;

@SuppressWarnings("serial")
public class BottomPanel extends JPanel {

	private static final Logger logger = LogManager.getLogger();
	private JButton updateButton;
	private JLabel updateLabel;
	private JProgressBar progressBar;

	private ActionListener updateActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (returnDialogOption() == 0) {
				updateLabel.setVisible(false);
				progressBar.setVisible(true);
				new UpdateTask().execute();
			}
		}
	};

	public BottomPanel() {
		updateButton = new JButton("Update");
		updateButton.setBounds(15, 7, 74, 26);
		updateButton.addActionListener(updateActionListener);

		updateLabel = new JLabel("Done");
		updateLabel.setBounds(675, 5, 50, 30);

		progressBar = new JProgressBar(0);
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		progressBar.setBounds(720, 5, 70, 30);

		initializeJPanel();
		addToJPanel();
	}

	private void initializeJPanel() {
		setPreferredSize(new Dimension(800, 40));
		setLayout(null);
	}

	private void addToJPanel() {
		add(updateButton);
		add(updateLabel);
		add(progressBar);
	}

	private int returnDialogOption() {
		Object[] options = { "Update", "Cancel" };
		return JOptionPane.showOptionDialog(new JFrame(), "Please make sure you have an internet connection.", "Update",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	class UpdateTask extends SwingWorker<Void, Void> {
		@Override
		public Void doInBackground() {
			try {
				Statistics.getInstance().updateAll();
			} catch (IOException e) {
				logger.error("Error during statistics update. (" + e + ")");
			}

			try {
				Standings.getInstance().updateAll();
			} catch (IOException e) {
				logger.error("Error during standings update. (" + e + ")");
			}
			return null;
		}

		public void done() {
			updateLabel.setVisible(true);
			updateLabel.setText("Done");
			progressBar.setVisible(false);
			Toolkit.getDefaultToolkit().beep();
		}
	}

}
