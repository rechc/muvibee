package de.muvibee.playground.list;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
public class ListView extends JPanel{
	DefaultListModel  listModel;
	CellRenderer lcr;
	JList list;
	
	public ListView() {
			setLayout(new BorderLayout());
		
			listModel = new DefaultListModel();
			lcr = new CellRenderer();
 	        list = new JList(listModel);
 	        list.setCellRenderer(lcr);
 	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 	        list.setLayoutOrientation(JList.VERTICAL);
 	        list.setVisibleRowCount(10);
 	        
	        list.addListSelectionListener(new ListSelectionListener() {
	        	public void valueChanged(ListSelectionEvent evt){
	        		System.out.println("Feld: " + list.getSelectedIndex() + " " + (evt.getValueIsAdjusting()?"PREP":"SEL"));
	        	}
	        });
 	        
	        JScrollPane pane = new JScrollPane(list);
	        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        pane.setPreferredSize(new Dimension(150,600));
	        
	        add(pane, BorderLayout.NORTH);
	}
	
	
	public void listAdd(ListEntry entry){
		listModel.addElement(entry);
		list.validate();
	}
}

