package de.muvibee.playground.cr;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import de.muvibee.playground.tree.ExitListener;
import de.muvibee.playground.tree.WindowUtilities;

public class TreeView extends JPanel{
	
	  private Icon customOpenIcon = new ImageIcon("images/Circle_1.gif");
	  private Icon customClosedIcon = new ImageIcon("images/Circle_2.gif");
	  private Icon customLeafIcon = new ImageIcon("images/Circle_3.gif");
	 
	  private LinkedList<String> prioList1 = new LinkedList<String>();
	  private LinkedList<String> prioList2 = new LinkedList<String>();
	  private LinkedList<String> prioList3 = new LinkedList<String>();
	  
	  DefaultMutableTreeNode root;
	  DefaultMutableTreeNode stageOneChild;
	  DefaultMutableTreeNode stageTwoChild;
	  DefaultMutableTreeNode stageThreeChild;

	public TreeView() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(150,600));
		
	}
	
	public void refreshTree(){
//	    DefaultMutableTreeNode root =
		    root =  new DefaultMutableTreeNode("Root");
		    
		
	    for(String s : prioList1) {
	        stageOneChild = new DefaultMutableTreeNode(s);
	        root.add(stageOneChild);
	        for(String s2 : prioList2) {
	          stageTwoChild =
	            new DefaultMutableTreeNode(s2);
	          stageOneChild.add(stageTwoChild);
	          for(String s3 : prioList3) {
		          stageThreeChild =
		            new DefaultMutableTreeNode(s3);
		          stageTwoChild.add(stageThreeChild);
	          }
	        }
	      }
	    
		JTree tree = new JTree(root);
		tree.expandRow(1); // Expand children to illustrate leaf icons
		JScrollPane pane1 = new JScrollPane(tree);
		
		   tree.addTreeSelectionListener(new TreeSelectionListener() {
			      public void valueChanged(TreeSelectionEvent e) {
			        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
			        if (node.isLeaf())
			        	System.out.println("You selected " + node);
			      }
			    });
		
		add(pane1);
		// pane1.setBorder(BorderFactory.createTitledBorder("TreeTitle"));
	}
	
	public void newRoot(DefaultMutableTreeNode child){
		root.add(child);
	}
	
	public void newStageOneChild(DefaultMutableTreeNode child){
		stageOneChild.add(child);
	}
	
	public void newStageTwoChild(DefaultMutableTreeNode child){
		stageTwoChild.add(child);
	}
	
	
	public void newStageThreeChild(DefaultMutableTreeNode child){
		stageThreeChild.add(child);
	}

	public LinkedList<String> getPrioList1() {
		return prioList1;
	}

	public void setPrioList1(LinkedList<String> prioList1) {
		this.prioList1 = prioList1;
	}

	public LinkedList<String> getPrioList2() {
		return prioList2;
	}

	public void setPrioList2(LinkedList<String> prioList2) {
		this.prioList2 = prioList2;
	}

	public LinkedList<String> getPrioList3() {
		return prioList3;
	}

	public void setPrioList3(LinkedList<String> prioList3) {
		this.prioList3 = prioList3;
	}

}
