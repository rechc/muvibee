package de.muvibee.playground.cr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.text.html.HTML;

public class CellRenderer extends JPanel implements ListCellRenderer {
		private static final Color HIGHLIGHT_COLOR = new Color(200, 0, 225);
		private Hashtable iconTable = new Hashtable();

		Border selectedBorder = BorderFactory.createLineBorder(Color.red,2);
		Border normalBorder = BorderFactory.createEmptyBorder();
		
	    public CellRenderer() {
			super();
			setLayout(new GridLayout());
			setOpaque(true);
			setPreferredSize(new Dimension(150,70));
	    }
	    
	    public CellRenderer(JPanel entry) {
			super();
			setLayout(new GridLayout());
			add(entry);
			setOpaque(true);
			setPreferredSize(new Dimension(150,70));
	    }
	    
	    
	    public Component getListCellRendererComponent(
	    										JList list,
	    										Object value,
	    										int index,
	    										boolean isSelected,
	    										boolean hasFocus)
	    {

//		    if (value instanceof Entry) {
//		      Entry entry = (Entry)value;
//		      ImageIcon icon = (ImageIcon)iconTable.get(value);
//		      if (icon == null) {
////		        icon = new ImageIcon(entry.getImage());
//		        icon = (entry.getImage(list));
//		        add(new JLabel(entry.getTitle()));
//		        iconTable.put(value, icon);
//		      }
//		      
//		    } else {
//		      label.setIcon(null); 
//		    }
		    
//		    panel.setBackground((Color)value);
		    
		    if(isSelected) this.setBorder(selectedBorder);
			else this.setBorder(normalBorder);

		    
		    return(this);
	    }
}


