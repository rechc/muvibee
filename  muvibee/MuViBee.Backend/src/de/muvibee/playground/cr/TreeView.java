package de.muvibee.playground.cr;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import de.muvibee.playground.tree.ExitListener;
import de.muvibee.playground.tree.WindowUtilities;

public class TreeView extends JPanel{
	
	  private Icon customOpenIcon = new ImageIcon("images/Circle_1.gif");
	  private Icon customClosedIcon = new ImageIcon("images/Circle_2.gif");
	  private Icon customLeafIcon = new ImageIcon("images/Circle_3.gif");
	  private LinkedList<String> list_prio1;
	  private LinkedList<String> list_prio2;
	  private LinkedList<String> list_prio3;

	public TreeView() {
		setLayout(new FlowLayout());
	    DefaultMutableTreeNode root =
	      new DefaultMutableTreeNode("Root");
	    DefaultMutableTreeNode child;
	    DefaultMutableTreeNode grandChild;
	    
	    for(String s : list_prio1) {
	        child = new DefaultMutableTreeNode(s);
	        root.add(child);
	        for(String s2 : list_prio2) {
	          grandChild =
	            new DefaultMutableTreeNode(s2);
	          child.add(grandChild);
	        }
	      }

	      JTree tree1 = new JTree(root);
	      tree1.expandRow(1); // Expand children to illustrate leaf icons
	      JScrollPane pane1 = new JScrollPane(tree1);
//	      pane1.setBorder(BorderFactory.createTitledBorder("TreeTitle"));
	}

}
