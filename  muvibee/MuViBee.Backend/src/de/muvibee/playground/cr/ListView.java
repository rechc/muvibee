package de.muvibee.playground.cr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ListView extends JPanel{
	DefaultListModel  listModel;
	JList list;
	CellRenderer lcr;
	
	public ListView() {
			setLayout(new BorderLayout());
		
			listModel = new DefaultListModel();
 	        list = new JList(listModel);
 	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 	        list.setLayoutOrientation(JList.VERTICAL);
 	        list.setVisibleRowCount(10);
 	        
	        list.addListSelectionListener(new ListSelectionListener() {
	        	public void valueChanged(ListSelectionEvent evt){
	        		System.out.println("Feld: " + list.getSelectedIndex());
	        	}
	        });
 	        
	        JScrollPane pane = new JScrollPane(list);
	        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        pane.setPreferredSize(new Dimension(150,600));
//	        pane.getViewport().setBackground(Color.BLUE);
	        
	        add(pane, BorderLayout.NORTH);
	}
	
	public void listAdd(String cover, String author, String title){
		lcr = new CellRenderer(new Entry_old(cover, author, title));
		listModel.addElement(lcr);
		list.setCellRenderer(lcr);
	}
}

