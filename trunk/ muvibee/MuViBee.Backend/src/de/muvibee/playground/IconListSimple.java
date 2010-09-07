package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class IconListSimple extends JPanel {

	
	static JList list;
	static DefaultListModel dlm;
	int iconCounter = 1;
	
	protected static int itemCounter = 0;
	
	public IconListSimple() {

		setLayout(new BorderLayout());
		dlm = new DefaultListModel();
//	    dlm.clear();
	    
	   	list = new JList();
	   	list.setModel(dlm);
	   	list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	   	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   	
		IconCellRenderer icr = new IconCellRenderer();
		icr.setPreferredSize(new Dimension(100, 120));
		list.setCellRenderer(icr);		
		list.setVisibleRowCount(-1);
		
		
		//button
		JButton addButton = new JButton("Add Entry");		
		addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (iconCounter <= 7) {
            	addItem(iconCounter + ".jpg", dlm);
                iconCounter++;
                }
                else {
                	addItem("1.jpg", dlm);
                }
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
	
	protected static void addItem(String icon, DefaultListModel dlm) {
		
		int index = list.getSelectedIndex(); //get selected index
	    if (index == -1) { //no selection, so insert at beginning
	        index = 0;
	    } else {           //add after the selected item
	        index++;
	    }

	    IconEntry cover = new IconEntry(icon);
	    
		dlm.insertElementAt(cover, index);
		list.ensureIndexIsVisible(index);
		itemCounter++;
		System.out.println("Geaddet." + "\t" + itemCounter);
		
	}	
}

////////-----------------Icon Cell Renderer Class--------------------/////////
@SuppressWarnings("serial")
class IconCellRenderer extends JLabel implements ListCellRenderer {
	
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
    public IconCellRenderer() {
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
    	IconEntry entry = (IconEntry) value;
    	if (!(IconListSimple.itemCounter == 0) && (entry != null)) {
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
