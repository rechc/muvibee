package de.muvibee.playground;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ListComboBox extends JComboBox implements ItemListener {

	final static String[] combobox = {"Simple Icon List", "Simple List"};
	
	public ListComboBox() {
		super(combobox);		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
	}
}
