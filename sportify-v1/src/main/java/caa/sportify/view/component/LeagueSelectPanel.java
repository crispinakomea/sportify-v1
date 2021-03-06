package caa.sportify.view.component;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import caa.sportify.utility.CustomJList;
import caa.sportify.utility.HibernateUtil;
import caa.sportify.view.RightPanel;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class LeagueSelectPanel extends JPanel {

	private JScrollPane scrollPane;
	private CustomJList leageList;

	private RightPanel rightPanel;

	/**
	 * 
	 * Updates the rightPanel when the league selection changes.
	 * 
	 */
	private ListSelectionListener leagueListSelectionListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String league;
			if (!e.getValueIsAdjusting()) {
				league = leageList.getSelectedValue();
				rightPanel.update(league);
			}
		}
	};

	/**
	 * 
	 * On instantiation, leageList populated with names of leagues
	 * 
	 */
	public LeagueSelectPanel() {
		String query = "select league.name from League league";
		@SuppressWarnings("unchecked")
		List<String> leagues = (ArrayList<String>) HibernateUtil.getListResult(query);
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

}
