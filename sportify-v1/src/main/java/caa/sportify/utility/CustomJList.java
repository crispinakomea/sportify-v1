package caa.sportify.utility;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 * @author Crispin A.
 *
 */
@SuppressWarnings("serial")
public class CustomJList extends JList<String> {

	public CustomJList(String[] array) {
		super(array);
		setFixedCellWidth(175);
		setFixedCellHeight(22);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setSelectionBackground(Color.darkGray);
	}
	
}
