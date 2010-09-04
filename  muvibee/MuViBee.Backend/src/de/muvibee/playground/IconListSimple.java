package de.muvibee.playground;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.JList;


public class IconListSimple extends JPanel {

	protected static Entry[] items = {
		new Entry("The Big Lebowsky", "1.jpg"), 
		null, 
		null, null, null, null
	};//new Entry[20];
	
	protected static int itemCounter = 0;
	
	public IconListSimple() {
		
//		setPreferredSize(new Dimension(300, 200));
		setLayout(new BorderLayout());
		JList list = new JList(items);
		IconCellRenderer icr = new IconCellRenderer();
		icr.setPreferredSize(new Dimension(50, 70));
		list.setCellRenderer(icr);		
		list.setVisibleRowCount(6);	
		
		JButton addButton = new JButton("Add Entry");
		addButton.setSize(12, 24);
		addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem("Icon number two", "3.jpg");
            }
        });
		this.add(addButton, BorderLayout.SOUTH);
		
		JScrollPane pane = new JScrollPane(list);
		pane.setPreferredSize(new Dimension(450, 250));
		this.add(pane, BorderLayout.NORTH);		
	}
	
	protected static void addItem(String name, String icon ) {
		for (int i = 0; i < items.length; i++) {
			if (i <= itemCounter)
				continue;
			items[i] = new Entry(name, icon);
			itemCounter++;
			System.out.println("Geaddet.");
			break;
		}
	}	
}

/////////////////////////////////////////////////////////////////////////
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
