package de.muvibee.playground.cr;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI_tree extends JFrame{
	public UI_tree() {
		
		super("User Interface");

		// ContentPane setzen:
//		JPanel content = new JPanel(new GridBagLayout());
		TreeView tv = new TreeView();;
		JPanel content = tv;
		this.setContentPane(content);
		
        // Groesse des Fensterbereichs setzen:
        content.setPreferredSize(new Dimension(250, 650));

        // Icon setzen:		// getClass().getResource() sucht die Resource (hier muvibee.gif im Unterverzeichnis icons) relativ zum Pfad der Class
//        this.setIconImage(new ImageIcon(getClass().getResource(".\\icons\\muvibee.gif")).getImage());

        // Programm beenden, wenn das Fenster geschlossen wird:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		UI_tree ui = new UI_tree();
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}
}
