package com.sportify;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.sportify.view.BottomPanel;
import com.sportify.view.LeftPanel;
import com.sportify.view.RightPanel;

/**
 * @author Crispin A.
 *
 */
public class App {

	private JFrame frame;

	private final LeftPanel leftPanel;
	private final RightPanel rightPanel;
	private final BottomPanel bottomPanel;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addTo() {
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		frame.getContentPane().add(rightPanel, BorderLayout.CENTER);
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}

}
