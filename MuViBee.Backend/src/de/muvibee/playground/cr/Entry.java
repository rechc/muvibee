package de.muvibee.playground.cr;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Entry extends JPanel{
	
	public Entry(String cover, String author, String title) {
		// -----------------
		// |       | Author |
		// | Cover |________|
		// |       | Titel  |
		// |_______|________|
		
		setLayout(new GridLayout(1,2,-45,0));
		setPreferredSize(new Dimension(150, 250));
		
		add(new JLabel(cover));
		
		JPanel author_title = new JPanel(new GridLayout(2,1,0,-195));
		JLabel authorLbl = new JLabel(author);
		JLabel titleLbl = new JLabel(title);
		author_title.add(authorLbl);
		author_title.add(titleLbl);		
		add(author_title);
	}

}
