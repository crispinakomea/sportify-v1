package caa.sportify.utility;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class CustomGridBag extends JPanel {

	public CustomGridBag() {

	}

	public void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth,
			int gridheight, int anchor, int fill) {
		Insets insets = new Insets(0, 0, 0, 0);
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0, anchor, fill,
				insets, 0, 0);
		container.add(component, gbc);
	}
}
