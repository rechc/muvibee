package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import de.muvibee.media.*;


@SuppressWarnings("serial")
public class SimpleList extends JPanel {

	static JList list;
	static DefaultListModel dlm;
	
	
	
	public SimpleList() {
		super();
		
		setLayout(new BorderLayout());
		dlm = new DefaultListModel();
				
		list = new JList();
		list.setModel(dlm);
		CellRenderer cr = new CellRenderer(CellRenderer.rendererType.SIMPLE_LIST);
		cr.setPreferredSize(new Dimension(20, 30));
		list.setCellRenderer(cr);
		list.setVisibleRowCount(3);
				
		JButton addButton = new JButton("Add");		
		addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 	addItem("Sugi", "Pula");
                }            
        });
		this.add(addButton, BorderLayout.SOUTH);		
		
		//scroll pane
		JScrollPane pane = new JScrollPane(list);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setPreferredSize(new Dimension(350, 550));
		this.add(pane, BorderLayout.NORTH);
	}
	
	public void addItem(String title, String author) {
//		int index = list.getSelectedIndex(); //get selected index
//	    if (index == -1) { //no selection, so insert at beginning
//	        index = 0;
//	    } else {           //add after the selected item
//	        index++;
//	    }
	    Entry book = new Entry(title, author);	    
//		dlm.insertElementAt(book, index);
		dlm.addElement(book);
		list.ensureIndexIsVisible(dlm.indexOf(this));
	}
	
	public void addList(LinkedList lList) {
		
	}
	
	public void addMedia(Media med) {
		if (med instanceof Book)
			addBook((Book) med);
		if (med instanceof Video)
			addVideo((Video) med);
		if (med instanceof Music)
			addMusic((Music) med);
	}
	
	private void addBook(Book b) {
	}
	
	private void addVideo(Video v) {
	}
	
	private void addMusic(Music m) {
	}
}
