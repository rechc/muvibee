package de.muvibee.playground.cr;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;


public class ListView extends JPanel{
	JList  list;
	
	public ListView() {
 	        list = new JList();
 	        list.setVisibleRowCount(10);
 	        
	        JScrollPane scroller = new JScrollPane(list);
	        scroller.setPreferredSize(new Dimension(150,600));
//			IconCellRenderer icr = new IconCellRenderer();
//			icr.setPreferredSize(new Dimension(50, 70));
//			list.setCellRenderer(icr);		
	        
	        add(scroller);
	}
	
	public void listAdd(String cover, String author, String title){
		list.add(new Entry(cover,author,title));
	}
}

/////////////////////////////////////////////////////////////////////////
//class IconCellRenderer extends JLabel implements ListCellRenderer {
//	
//	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
//	
//    public IconCellRenderer() {
//        setOpaque(true);
//        setIconTextGap(12);
//    }
//    public Component getListCellRendererComponent(
//        JList list,
//        Object value,
//        int index,
//        boolean isSelected,
//        boolean cellHasFocus)
//    {
//        	
//    	Entry entry = (Entry) value;
//    	if (!(IconListSimple.itemCounter == 0) && (entry != null)) {
//    		setText(entry.getTitle());
//    		setIcon(entry.getImage(list));
//    	}
//        if (isSelected) {
//          setBackground(HIGHLIGHT_COLOR);
//          setForeground(Color.white);
//        } else {
//          setBackground(Color.white);
//          setForeground(Color.black);
//        }
//    	
//        return this;
//    }
//}