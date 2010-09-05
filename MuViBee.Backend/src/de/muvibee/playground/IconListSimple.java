package de.muvibee.playground;

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


@SuppressWarnings("serial")
public class IconListSimple extends JPanel {

	
	static JList list;
	static DefaultListModel dlm;
	
	protected static int itemCounter = 0;
	
	public IconListSimple() {
		
//		setPreferredSize(new Dimension(300, 200));
		setLayout(new BorderLayout());
		dlm = new DefaultListModel();
//	    dlm.clear();
	    
//	    dlm.addElement(new Entry("The Big Lebowsky", "1.jpg"));
	   	list = new JList();
	   	list.setModel(dlm);
	   	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   	
		IconCellRenderer icr = new IconCellRenderer();
		icr.setPreferredSize(new Dimension(50, 70));
		list.setCellRenderer(icr);		
		list.setVisibleRowCount(3);
		
		
		//button
		JButton addButton = new JButton("Add Entry");
		addButton.setSize(12, 24);
		addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem("Icon number two", "3.jpg", dlm);
            }
        });
		this.add(addButton, BorderLayout.SOUTH);
		
		//scroll pane
		JScrollPane pane = new JScrollPane(list);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setPreferredSize(new Dimension(450, 250));
		this.add(pane, BorderLayout.NORTH);
	}
	
	protected static void addItem(String name, String icon, DefaultListModel dlm) {
		
		int index = list.getSelectedIndex(); //get selected index
	    if (index == -1) { //no selection, so insert at beginning
	        index = 0;
	    } else {           //add after the selected item
	        index++;
	    }

		dlm.insertElementAt(new Entry(name, icon), index);
		list.ensureIndexIsVisible(index);
		itemCounter++;
		System.out.println("Geaddet." + "\t" + itemCounter);
		
	}	
}

/////////////////////////////////////////////////////////////////////////
@SuppressWarnings("serial")
class IconCellRenderer extends JLabel implements ListCellRenderer {
	
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
    public IconCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }
    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus)
    {
        	
    	Entry entry = (Entry) value;
    	if (!(IconListSimple.itemCounter == 0) && (entry != null)) {
    		setText(entry.getTitle());
    		setIcon(entry.getImage(list));
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
