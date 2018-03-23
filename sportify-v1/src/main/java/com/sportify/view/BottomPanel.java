package com.sportify.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sportify.database.DataUpdateTask;
import com.sportify.view.component.UpdateDialogPanel;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class BottomPanel extends JPanel {

	private JButton updateButton;
	private UpdateDialogPanel updateDialogPanel;
	private DataUpdateTask<Object> dataUpdateTask;

	/**
	 * 
	 * ActionListener that starts the update process.
	 * 
	 */
	private ActionListener updateActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (returnDialogOption() == 0) {
				updateDialogPanel = new UpdateDialogPanel();
				try {
					dataUpdateTask = new DataUpdateTask<Object>(updateDialogPanel, updateDialogPanel.getBottomlabel());
					dataUpdateTask.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent evt) {
							if ("progress".equals(evt.getPropertyName())) {
								updateDialogPanel.getProgressbar().setValue((Integer) evt.getNewValue());
							}
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
				dataUpdateTask.execute();
				updateDialogPanel.setVisible(true);
			}
		}
	};

	public BottomPanel() {
		updateButton = new JButton("Update");
		updateButton.setBounds(15, 7, 74, 26);
		updateButton.addActionListener(updateActionListener);

		initializeJPanel();
		addToJPanel();
	}

	private void initializeJPanel() {
		setPreferredSize(new Dimension(800, 40));
		setLayout(null);
	}

	private void addToJPanel() {
		add(updateButton);
	}

	private int returnDialogOption() {
		Object[] options = { "Update", "Cancel" };
		return JOptionPane.showOptionDialog(new JFrame(), "Please make sure you have an internet connection.", "Update",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	}

}
