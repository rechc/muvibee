package de.muvibee.playground.tree;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/** JTree with missing or custom icons at the tree nodes.
 *  1999 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class CustomIcons extends JFrame {
  public static void main(String[] args) {
    new CustomIcons();
  }

  private Icon customOpenIcon = new ImageIcon("images/Circle_1.gif");
  private Icon customClosedIcon = new ImageIcon("images/Circle_2.gif");
  private Icon customLeafIcon = new ImageIcon("images/Circle_3.gif");
  
  public CustomIcons() {
    super("JTree Selections");
    WindowUtilities.setNativeLookAndFeel();
    addWindowListener(new ExitListener());
    Container content = getContentPane();
    content.setLayout(new FlowLayout());
    DefaultMutableTreeNode root =
      new DefaultMutableTreeNode("Root");
    DefaultMutableTreeNode child;
    DefaultMutableTreeNode grandChild;
    for(int childIndex=1; childIndex<4; childIndex++) {
      child = new DefaultMutableTreeNode("Child " + childIndex);
      root.add(child);
      for(int grandChildIndex=1; grandChildIndex<4; grandChildIndex++) {
        grandChild =
          new DefaultMutableTreeNode("Grandchild " + childIndex +
                                     "." + grandChildIndex);
        child.add(grandChild);
      }
    }

    JTree tree1 = new JTree(root);
    tree1.expandRow(1); // Expand children to illustrate leaf icons
    JScrollPane pane1 = new JScrollPane(tree1);
    pane1.setBorder(BorderFactory.createTitledBorder("Standard Icons"));
    content.add(pane1);

    JTree tree2 = new JTree(root);
    tree2.expandRow(2); // Expand children to illustrate leaf icons
    DefaultTreeCellRenderer renderer2 = new DefaultTreeCellRenderer();
    renderer2.setOpenIcon(null);
    renderer2.setClosedIcon(null);
    renderer2.setLeafIcon(null);
    tree2.setCellRenderer(renderer2);
    JScrollPane pane2 = new JScrollPane(tree2);
    pane2.setBorder(BorderFactory.createTitledBorder("No Icons"));
    content.add(pane2);

    JTree tree3 = new JTree(root);
    tree3.expandRow(3); // Expand children to illustrate leaf icons
    DefaultTreeCellRenderer renderer3 = new DefaultTreeCellRenderer();
    renderer3.setOpenIcon(customOpenIcon);
    renderer3.setClosedIcon(customClosedIcon);
    renderer3.setLeafIcon(customLeafIcon);
    tree3.setCellRenderer(renderer3);
    JScrollPane pane3 = new JScrollPane(tree3);
    pane3.setBorder(BorderFactory.createTitledBorder("Custom Icons"));
    content.add(pane3);

    pack();
    setVisible(true);
  }
}
