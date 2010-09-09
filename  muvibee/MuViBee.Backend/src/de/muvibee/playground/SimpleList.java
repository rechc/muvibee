package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

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
		CellRenderer cr = new CellRenderer();
		cr.setPreferredSize(new Dimension(40, 60));
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
		int index = list.getSelectedIndex(); //get selected index
	    if (index == -1) { //no selection, so insert at beginning
	        index = 0;
	    } else {           //add after the selected item
	        index++;
	    }
	    Entry book = new Entry(title, author);	    
		dlm.insertElementAt(book, index);
		list.ensureIndexIsVisible(index);
	}	
}

////////-----------------Cell Renderer Class--------------------/////////
@SuppressWarnings("serial")
class CellRenderer extends JLabel implements ListCellRenderer {
	
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
    public CellRenderer() {
        setOpaque(true);
        Border compound = BorderFactory.createCompoundBorder(
        		BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
        Border gap = BorderFactory.createCompoundBorder(
        		BorderFactory.createLineBorder(Color.WHITE, 5), compound);
        this.setBorder(gap);
    }
    
    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus)
    {        	
    	Entry entry = (Entry) value;
    	if (entry != null) {
    		setText(entry.getTitle() + " | " + entry.getAuthor());
    		setFont(list.getFont().deriveFont(Font.BOLD, 20));
    	}
        if (isSelected) {
          setBackground(HIGHLIGHT_COLOR);
          setForeground(Color.white);
        } else {
          setBackground(Color.white);
          setForeground(Color.black);
        }

        return this;
    }
}
