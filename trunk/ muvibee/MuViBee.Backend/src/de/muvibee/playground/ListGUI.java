package de.muvibee.playground;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ListGUI extends JFrame {
	
	
	public ListGUI() {

		super("Search List");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setIconImage(new ImageIcon("resources/icons/5.jpg").getImage());

		//Add TreeView
		
		
		//Add IconList	
		this.setContentPane(new IconListSimple());
	}

	public static void main(String[] args) {
		ListGUI sl = new ListGUI();
		sl.pack();
		sl.setLocationRelativeTo(null);
		sl.setVisible(true);
	}

}
