package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CompleteList extends JFrame {
	
	
	public CompleteList() {

		super("Search List");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setIconImage(new ImageIcon("resources/icons/5.jpg").getImage());

		//Add IconList	
//		content.add(list.initialize(), BorderLayout.WEST);		
		this.setContentPane(new IconListSimple());
		
		
	}

	public static void main(String[] args) {
		CompleteList sl = new CompleteList();
		sl.pack();
		sl.setLocationRelativeTo(null);
		sl.setVisible(true);
	}

}
