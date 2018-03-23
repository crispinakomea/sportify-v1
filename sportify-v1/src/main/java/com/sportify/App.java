package com.sportify;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import com.sportify.utility.HibernateUtil;
import com.sportify.view.BottomPanel;
import com.sportify.view.LeftPanel;
import com.sportify.view.RightPanel;

/**
 * @author Crispin A.
 *
 */
public class App {

	private JFrame frame;

	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private BottomPanel bottomPanel;

	/**
	 * 
	 * Closes SessionFactory application window closing.
	 * 
	 */
	private WindowAdapter closeWindowEvent = new WindowAdapter() {
		@Override
		public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			HibernateUtil.closeSessionFactory();
			System.exit(0);
		}
	};

	public App() {
		leftPanel = new LeftPanel();
		rightPanel = new RightPanel();
		bottomPanel = new BottomPanel();

		leftPanel.injectRightPanel(rightPanel);

		initialize();
		addTo();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(820, 640));
		frame.setLocationRelativeTo(null);
		frame.setTitle("Sportify");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(closeWindowEvent);
	}

	private void addTo() {
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		frame.getContentPane().add(rightPanel, BorderLayout.CENTER);
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
