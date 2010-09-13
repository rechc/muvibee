package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ListGUI extends JFrame {
		
	JPanel content = new JPanel(new BorderLayout());
	ListComboBox lcb = new ListComboBox();
	
	public ListGUI() {

		super("Search List");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setIconImage(new ImageIcon("resources/icons/5.jpg").getImage());
				
		lcb.setSelectedIndex(0);
		lcb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	if (e.getStateChange() == ItemEvent.SELECTED) {
            		if (((String) e.getItem()).equals("Simple List")) {
            			SimpleList sl = new SimpleList();
            			content.removeAll();
                        content.add(sl, BorderLayout.NORTH);
                        content.add(lcb, BorderLayout.SOUTH);
                        content.validate();
//                        System.out.println("Simple List");
            		}
            		if (((String) e.getItem()).equals("Simple Icon List")) {
            			IconListSimple ils = new IconListSimple();
            			content.removeAll();
                        content.add(ils, BorderLayout.NORTH);
                        content.add(lcb, BorderLayout.SOUTH);
                        content.validate();
//                        System.out.println("Simple Icon List");
            		}
                } 
            }
        });

		//Add IconList to content (Standard)		
		content.add(new IconListSimple(), BorderLayout.NORTH);
		//Add Combobox to content
		content.add(lcb, BorderLayout.SOUTH);

		this.setContentPane(content);
	}

	public static void main(String[] args) {
		ListGUI sl = new ListGUI();
		sl.pack();
		sl.setLocationRelativeTo(null);
		sl.setVisible(true);
	}

}
