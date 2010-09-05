package de.muvibee.playground;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class TreeView extends JFrame{
	
	public TreeView() {
		super("Tree View");

	    // ContentPane setzen:
	    JPanel content = new JPanel(new GridLayout(1,1));
	    this.setContentPane(content);

	    // Groesse des Fensterbereichs setzen:
	    content.setPreferredSize(new Dimension(250, 650));

	    // Icon setzen:		// getClass().getResource() sucht die Resource (hier ftp.gif im Unterverzeichnis icons) relativ zum Pfad der Class
//	    this.setIconImage(new ImageIcon(getClass().getResource(".\\icons\\muvibee.gif")).getImage());

	    // Programm beenden, wenn das Fenster geschlossen wird:
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	    

}
