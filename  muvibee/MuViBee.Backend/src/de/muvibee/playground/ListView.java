package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class ListView extends JFrame{

	public ListView() {
		super("List View");

        // ContentPane setzen:
        JPanel content = new JPanel(new GridBagLayout());
        this.setContentPane(content);
        
        GridBagConstraints c = new GridBagConstraints();

        // Groesse des Fensterbereichs setzen:
        content.setPreferredSize(new Dimension(250, 650));

        // Icon setzen:		// getClass().getResource() sucht die Resource (hier ftp.gif im Unterverzeichnis icons) relativ zum Pfad der Class
//        this.setIconImage(new ImageIcon(getClass().getResource(".\\icons\\muvibee.gif")).getImage());

        // Programm beenden, wenn das Fenster geschlossen wird:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JScrollBar scroller = new JScrollBar();
        scroller.setOrientation(JScrollBar.VERTICAL);
        scroller.setPreferredSize(new Dimension(15,600));

        scroller.add(addItem("Cover1","Author1","Titel1"));
        scroller.add(addItem("Cover2","Author2","Titel2"));
        
        c.fill = GridBagConstraints.NONE;
        c.gridx = 3;
        c.gridy = 0;
        content.add(scroller, c);
        content.add(addItem("Cover3","Author3","Titel3"),c); //nur zum Test hinzugefuegt
	}
	
	private JPanel addItem(String coverStr, String authorStr, String titleStr){
		// -----------------
		// |       | Author |
		// | Cover |________|
		// |       | Titel  |
		// |_______|________|
		
		JPanel panel = new JPanel(new GridLayout(1,2,-45,0));
		JLabel coverLbl = new JLabel(coverStr);
		
		JPanel author_title = new JPanel(new GridLayout(2,1,0,-195));
		JLabel authorLbl = new JLabel(authorStr);
		JLabel titleLbl = new JLabel(titleStr);
		author_title.add(authorLbl);
		author_title.add(titleLbl);

		panel.setPreferredSize(new Dimension(150, 250));
		panel.add(coverLbl);
		panel.add(author_title);
		
		return panel;
	}
	
}
