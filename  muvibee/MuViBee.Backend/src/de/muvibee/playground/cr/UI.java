package de.muvibee.playground.cr;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class UI extends JFrame{
	ListView listView;
	
	public UI() {
		super("User Interface");

		// ContentPane setzen:
//		JPanel content = new JPanel(new GridBagLayout());
		listView = new ListView();;
		JPanel content = listView;
		this.setContentPane(content);
		
		//button
		JButton addButton = new JButton("Add Entry");
		addButton.setSize(12, 24);
		addButton.addActionListener(new ActionListener() {
			int i = 1;
			public void actionPerformed(ActionEvent e) {
				addItem(i  + ".jpg","Author" + i,"Titel" + i);
				i++;
            }
        });
		
		content.add(addButton);

		GridBagConstraints c = new GridBagConstraints();
		
        // Groesse des Fensterbereichs setzen:
        content.setPreferredSize(new Dimension(250, 650));

        // Icon setzen:		// getClass().getResource() sucht die Resource (hier muvibee.gif im Unterverzeichnis icons) relativ zum Pfad der Class
//        this.setIconImage(new ImageIcon(getClass().getResource(".\\icons\\muvibee.gif")).getImage());

        // Programm beenden, wenn das Fenster geschlossen wird:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addItem(String cover, String author, String title) {
		listView.listAdd(cover, author, title);
	}
	
	public static void main(String[] args) {
		UI ui = new UI();
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}

	
}
