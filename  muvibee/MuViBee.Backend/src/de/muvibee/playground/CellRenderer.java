package de.muvibee.playground;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CellRenderer extends JLabel implements ListCellRenderer {

	
	protected static enum rendererType {SIMPLE_LIST, ICON_LIST, DETAIL_ICON_LIST, TREE_VIEW};
	
	
	public CellRenderer(rendererType type) {
		
		switch (type) {
		
		case SIMPLE_LIST :
			setOpaque(true);
	        Border listGap = BorderFactory.createLineBorder(Color.GREEN, 1);
	        this.setBorder(listGap);
			break;
			
		case ICON_LIST :
			setOpaque(true);
	        Border compound = BorderFactory.createCompoundBorder(
	        		BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
	        Border iconGap = BorderFactory.createCompoundBorder(
	        		BorderFactory.createLineBorder(Color.WHITE, 5), compound);
	        this.setBorder(iconGap);
			break;
		
		case DETAIL_ICON_LIST :
			break;
		
		
			
		
		}
		
	}

	@Override
	public Component getListCellRendererComponent(JList list,
	        Object value,
	        int index,
	        boolean isSelected,
	        boolean cellHasFocus) 
	{
		
		if (value instanceof IconEntry) {
			IconEntry entry = (IconEntry) value;
	    	if (!(IconListSimple.itemCounter == 0) && (entry != null)) {
	    		setIcon(entry.getImage());
	    	}
		}
		
		if (value instanceof Entry) {
			Entry entry = (Entry) value;
	    	if (entry != null) {
	    		setText(entry.getTitle() + " | " + entry.getAuthor());
	    		setFont(list.getFont().deriveFont(Font.BOLD, 14));
	    	}
		}
		
        if (isSelected) {
          setBackground(Color.cyan);
          setForeground(Color.white);
        } else {
          setBackground(Color.white);
          setForeground(Color.black);
        }

        return this;		
	}
	
	
}
