package de.muvibee.playground;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CompleteList extends JFrame {
	
	
	public CompleteList() {

		super("Search List");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setIconImage(new ImageIcon("resources/icons/5.jpg").getImage());

		//Add IconList	
		this.setContentPane(new IconListSimple());
	}

	public static void main(String[] args) {
		CompleteList sl = new CompleteList();
		sl.pack();
		sl.setLocationRelativeTo(null);
		sl.setVisible(true);
	}

}
