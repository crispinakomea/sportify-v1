package com.sportify.database;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

import com.sportify.entity.League;
import com.sportify.entity.Team;
import com.sportify.utility.HibernateUtil;
import com.sportify.view.component.UpdateDialogPanel;

public class DataUpdateTask<V> extends SwingWorker<List<Integer>, Integer> {

	private int toBeUpdated;
	private UpdateDialogPanel updateDialogPanel;
	private JLabel updateLabel;

	public DataUpdateTask(UpdateDialogPanel updateDialogPanel, JLabel updateLabel)
			throws MalformedURLException, IOException {
		this.updateDialogPanel = updateDialogPanel;
		this.updateLabel = updateLabel;
	}

	@Override
	protected List<Integer> doInBackground() throws Exception {
		HibernateUtil.executeUpdate("delete from Statistic");
		HibernateUtil.executeUpdate("delete from Standing");
		@SuppressWarnings("unchecked")
		List<League> leagues = (ArrayList<League>) HibernateUtil.executeListQuery("from League");
		@SuppressWarnings("unchecked")
		List<Team> teams = (ArrayList<Team>) HibernateUtil.executeListQuery("from Team");
		int progress = 0;
		toBeUpdated = leagues.size() + teams.size();
		for (League league : leagues) {
			Statistics.getInstance().update(league);
			publish(progress++);
			setProgress((int) (progress * 1.0 / toBeUpdated * 100));
			for (Team team : league.getTeams()) {
				Standings.getInstance().update(team);
				publish(progress++);
				setProgress((int) (progress * 1.0 / toBeUpdated * 100));
			}
		}
		return null;
	}

	@Override
	protected void process(List<Integer> chunks) {
		for (int number : chunks)
			updateLabel.setText("Completed " + number + " of " + toBeUpdated);
	}

	@Override
	public void done() {
		updateDialogPanel.setVisible(false);
		updateDialogPanel.dispose();
		Toolkit.getDefaultToolkit().beep();
	}

}
