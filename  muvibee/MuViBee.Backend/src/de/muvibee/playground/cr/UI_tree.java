package de.muvibee.playground.cr;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

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
		content.setLayout(new FlowLayout());
		
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("1"); l1.add("2"); l1.add("3");
		LinkedList<String> l2 = new LinkedList<String>();
		l2.add("1"); l2.add("2"); l2.add("3");
		LinkedList<String> l3 = new LinkedList<String>();
		l3.add("1"); l3.add("2"); l3.add("3");
		
		tv.setPrioList1(l1);
		tv.setPrioList2(l2);
		tv.setPrioList3(l3);
		
		tv.refreshTree();
		
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
