package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class IconInterface extends JFrame{

	public IconInterface() {
		super("List View");

        // ContentPane setzen:
        JPanel content = new JPanel(new GridLayout(1,1));
        this.setContentPane(content);

        // Groesse des Fensterbereichs setzen:
        content.setPreferredSize(new Dimension(250, 650));

        // Icon setzen:		// getClass().getResource() sucht die Resource (hier ftp.gif im Unterverzeichnis icons) relativ zum Pfad der Class
//        this.setIconImage(new ImageIcon(getClass().getResource(".\\icons\\muvibee.gif")).getImage());

        // Programm beenden, wenn das Fenster geschlossen wird:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        JPanel listPanel = new JPanel(new GridLayout(1,1));
        JScrollBar scroller = new JScrollBar();
        scroller.setOrientation(JScrollBar.VERTICAL);
        
        scroller.add(addItem("Cover","Author","Titel"));
        content.add(scroller);
        
	}
	
	private JPanel addItem(String coverStr, String authorStr, String titleStr){
		// -----------------
		// |       | Author |
		// | Cover |________|
		// |       | Titel  |
		// |_______|________|
		
		JPanel panel = new JPanel(new GridLayout(1,2));
		JLabel coverLbl = new JLabel(coverStr);
		
		JPanel author_title = new JPanel(new GridLayout(2,1));
		JLabel authorLbl = new JLabel(authorStr);
		JLabel titleLbl = new JLabel(titleStr);
		author_title.add(authorLbl);
		author_title.add(titleLbl);

//		panel.setPreferredSize(new Dimension(150, 250));
		panel.add(coverLbl);
		panel.add(author_title);
		
		return panel;
	}
	
}
