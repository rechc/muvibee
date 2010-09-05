package de.muvibee.playground.cr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;


public class ListView extends JPanel{
	DefaultListModel  listModel;
	
	public ListView() {
			setLayout(new BorderLayout());
		
			listModel = new DefaultListModel();
 	        JList list = new JList(listModel);
 	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 	        list.setLayoutOrientation(JList.VERTICAL);
 	        list.setVisibleRowCount(10);
 	        
	        JScrollPane pane = new JScrollPane(list);
	        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        pane.setPreferredSize(new Dimension(150,600));
	        pane.getViewport().setBackground(Color.BLUE);
//			IconCellRenderer icr = new IconCellRenderer();
//			icr.setPreferredSize(new Dimension(50, 70));
//			list.setCellRenderer(icr);		
	        add(pane, BorderLayout.NORTH);
	}
	
	public void listAdd(String cover, String author, String title){
		listModel.addElement(new Entry(cover,author,title));
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