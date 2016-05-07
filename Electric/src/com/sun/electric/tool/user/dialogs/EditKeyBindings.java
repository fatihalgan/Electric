/* -*- tab-width: 4 -*-
 *
 * Electric(tm) VLSI Design System
 *
 * File: EditKeyBindings.java
 *
 * Copyright (c) 2003 Sun Microsystems and Static Free Software
 *
 * Electric(tm) is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Electric(tm) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Electric(tm); see the file COPYING.  If not, write to
 * the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, Mass 02111-1307, USA.
 */

package com.sun.electric.tool.user.dialogs;

import com.sun.electric.tool.user.dialogs.options.PreferencePanel;
import com.sun.electric.tool.user.menus.EMenu;
import com.sun.electric.tool.user.menus.EMenuBar;
import com.sun.electric.tool.user.menus.EMenuItem;
import com.sun.electric.tool.user.ui.KeyBindings;
import com.sun.electric.tool.user.ui.KeyStrokePair;
import com.sun.electric.tool.user.ui.TopLevel;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


/**
 * Class to manage bindings of keystrokes to pulldown menus.
 */
public class EditKeyBindings extends PreferencePanel implements TreeSelectionListener {
    
    /** MenuBarGroup for building dialog tree */            EMenuBar menuBar;
    
    /** class to encapsulate a tree node for displaying key bindings.
     * The toString() method is overridden to show the key binding next to the
     * command name.  This class encapsulates both JMenuItem and Menu, note
     * that both extend JMenuItem.
     */
    private class KeyBoundTreeNode
    {
        private EMenuItem menuItem;

        KeyBoundTreeNode(EMenuItem menuItem) {
            this.menuItem = menuItem;
        }
        
        public EMenuItem getMenuItem() { return menuItem; }
        
        /** 
         * Convert to String to show on dialog tree
         */
        public String toString() {
            if (menuItem != EMenuItem.SEPARATOR) {
                StringBuffer buf = new StringBuffer(menuItem.getDescription());
                KeyBindings bindings = menuBar.getKeyBindings(menuItem);
                if (bindings == null) return buf.toString();
                Iterator it = bindings.getKeyStrokePairs();
                if (!it.hasNext()) return buf.toString();
                buf.append("   [ "+bindings.bindingsToString()+" ]");
                return buf.toString();
            }
            return "---------------";               // separator
        }
    }

    /** Creates new form EditKeyBindings */
    public EditKeyBindings(EMenuBar menuBar, java.awt.Frame parent, boolean modal) {
		super(parent, modal);
        this.menuBar = menuBar;

        initComponents();
        buildCommandsTree();
    }

    //protected void escapePressed() { doneActionPerformed(null); }

    // -------------------------- Preference Panel Stuff -----------------------

    public JPanel getPanel() {
        return editKeyBindingsPanel;
    }

    public String getName() { return "Key Bindings"; }

    // -------------------------------------------------------------------------

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        editKeyBindingsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandsTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        resetitem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bindingsJList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        reset = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Edit Key Bindings");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        editKeyBindingsPanel.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setPreferredSize(new java.awt.Dimension(350, 363));
        jScrollPane1.setViewportView(commandsTree);

        jPanel1.add(jScrollPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        editKeyBindingsPanel.add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        add.setText("Add");
        add.setToolTipText("add a shortcut");
        add.setPreferredSize(new java.awt.Dimension(68, 28));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel2.add(add, gridBagConstraints);

        remove.setText("Remove");
        remove.setToolTipText("remove a shortcut");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel2.add(remove, gridBagConstraints);

        resetitem.setText("Reset");
        resetitem.setToolTipText("reset to default setting");
        resetitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetitemActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel2.add(resetitem, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Shortcuts:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel1, gridBagConstraints);

        bindingsJList.setBorder(new javax.swing.border.EtchedBorder());
        bindingsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel4.add(bindingsJList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        editKeyBindingsPanel.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        reset.setText("Reset All to Defaults");
        reset.setToolTipText("reset all to default settings");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        jPanel3.add(reset, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        editKeyBindingsPanel.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(editKeyBindingsPanel, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    // -------------------------------- Actions ----------------------------------

    /**
     * Resets a menu item back to its default key bindings
     * @param evt the event
     */
    private void resetitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetitemActionPerformed
        // get currently selected node
        EMenuItem item = getSelectedMenuItem();
        if (item == null || item == EMenuItem.SEPARATOR || item instanceof EMenu) return;

        // reset item to default bindings
        menuBar.resetKeyBindings(item);

        // update tree view and list box
        DefaultTreeModel model = (DefaultTreeModel)commandsTree.getModel();
        model.reload(getSelectedTreeNode());
        updateListBox(item);
    }//GEN-LAST:event_resetitemActionPerformed

    /**
     * Remove a key binding from the menu item
     * @param evt the event
     */
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // get currently selected node
        EMenuItem item = getSelectedMenuItem();
        if (item == null || item == EMenuItem.SEPARATOR || item instanceof EMenu) {
            JOptionPane.showMessageDialog(this, "Please select a menu item first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // get selected key binding
        KeyStrokePair pair = getListBoxSelected();
        if (pair == null) {
            JOptionPane.showMessageDialog(this, "Please select the shortcut from the list to remove", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // remove it and update view
        menuBar.removeKeyBinding(item.getDescription(), pair);
        DefaultTreeModel model = (DefaultTreeModel)commandsTree.getModel();
        model.reload(getSelectedTreeNode());
        updateListBox(item);
    }//GEN-LAST:event_removeActionPerformed

    /**
     * Reset *All* menu items to their default Key Bindings
     * @param evt the event
     */
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // confirm that the user really wants to reset all key bindings
        if (!confirmResetAll()) return;
        menuBar.resetAllKeyBindings();

        // update tree view
        DefaultTreeModel model = (DefaultTreeModel)commandsTree.getModel();
        model.reload();
        EMenuItem item = getSelectedMenuItem();
        updateListBox(item);
    }//GEN-LAST:event_resetActionPerformed

    /**
     * Open dialog to add a key binding to the selected menu item
     * @param evt the event
     */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        EMenuItem item = getSelectedMenuItem();
        if (item == null || item == EMenuItem.SEPARATOR || item instanceof EMenu) return;
        EditKeyBinding dialog = new EditKeyBinding(item, menuBar, TopLevel.getCurrentJFrame(), true);
		dialog.setVisible(true);

        // update tree view
        DefaultTreeModel model = (DefaultTreeModel)commandsTree.getModel();
        model.reload(getSelectedTreeNode());
        updateListBox(item);
    }//GEN-LAST:event_addActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm

    }//GEN-LAST:event_exitForm


    // -------------------------------- Tree View Population -------------------------------

    /** Build tree of menu commands */
    private void buildCommandsTree() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();

        // convert menuBar to tree
        for (EMenuItem menu: menuBar.getItems()) {
            DefaultMutableTreeNode menuNode = new DefaultMutableTreeNode(new KeyBoundTreeNode(menu));
            rootNode.add(menuNode);
            addMenu(menuNode, (EMenu)menu);
        }
        EMenu hiddenMenu = menuBar.getHiddenMenu();
        if(hiddenMenu != null) {
            DefaultMutableTreeNode menuNode = new DefaultMutableTreeNode(new KeyBoundTreeNode(hiddenMenu));
            rootNode.add(menuNode);
            addMenu(menuNode, hiddenMenu);
        }
        
        commandsTree.setModel(new DefaultTreeModel(rootNode));
        // single selection as default
		commandsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// do not show top-level
		commandsTree.setRootVisible(false);
		commandsTree.setShowsRootHandles(true);
		commandsTree.setToggleClickCount(3);
        commandsTree.addTreeSelectionListener(this);
    }
    
    /** Adds menu items to parentNode, which represents Menu menu. */
    private void addMenu(DefaultMutableTreeNode parentNode, EMenu menu) {
        for (EMenuItem menuItem: menu.getItems()) {
            DefaultMutableTreeNode menuItemNode = new DefaultMutableTreeNode(new KeyBoundTreeNode(menuItem));
            parentNode.add(menuItemNode);
            if (menuItem instanceof EMenu)
                addMenu(menuItemNode, (EMenu)menuItem);              // recurse
        }
    }


    // ---------------------------- Tree Selection Listener -----------------------

    /**
     * Called when selection of Node in tree changes.
     * It updates the list box to reflect the current tree selection.
     */
    public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
        TreePath path = e.getPath();
        if (path == null) return;
        Object obj = path.getLastPathComponent();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)obj;
        Object n = node.getUserObject();
        if (!(n instanceof KeyBoundTreeNode)) return;
        KeyBoundTreeNode treeNode = (KeyBoundTreeNode)n;
        updateListBox(treeNode.getMenuItem());
    }

    // ------------------------------- List Box stuff -----------------------------

    /**
     * Update list box with item's key bindings
     * @param item display key bindings for this item
     */
    private void updateListBox(EMenuItem item) {
        if (item == null) {
            bindingsJList.setListData(new Object [] {});
            return;
        }
        KeyBindings bindings = menuBar.getKeyBindings(item);
        if (bindings == null) {
            bindingsJList.setListData(new Object [] {});
            return;
        }
        ArrayList<KeyStrokePair> list = new ArrayList<KeyStrokePair>();
        for (Iterator<KeyStrokePair> it = bindings.getKeyStrokePairs(); it.hasNext(); ) {
            KeyStrokePair pair = (KeyStrokePair)it.next();
            list.add(pair);
        }
        bindingsJList.setListData(list.toArray());
    }

    private KeyStrokePair getListBoxSelected() {
        Object value = bindingsJList.getSelectedValue();
        if (value == null) return null;
        return (KeyStrokePair)value;
    }

    // ------------------------------ Confirm Dialogs ------------------------------

    /**
     * Pops up a JOptionPain dialog box to confirm the reset of all
     * Key Bindings
     * @return true on confirmation by user to reset all bindings, false otherwise.
     */
    private boolean confirmResetAll() {
        Object [] options = {"Reset All", "Do Nothing"};
        int n = JOptionPane.showOptionDialog(this,
                "This will delete ***ALL*** your user key bindings.\n  Are you really sure you want to do that??",
                "You sure about that?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[1]);
        if (n == 0) return true;
        return false;
    }

    //-------------------------- Private Utility Methods ----------------------------

    /**
     * Get selected menu item in tree view
     * @return the selected menu item, or null if none.
     */
    private EMenuItem getSelectedMenuItem() {
        DefaultMutableTreeNode node = getSelectedTreeNode();
        if (node == null) return null;
        Object obj = node.getUserObject();
        if (!(obj instanceof KeyBoundTreeNode)) return null;
        KeyBoundTreeNode treeNode = (KeyBoundTreeNode)obj;
        EMenuItem item = treeNode.getMenuItem();
        return item;
    }

    /** get selected DefaultMutableTreeNode.
     * Returns null if no valid DefaultMutableTree node selected in tree.
     */
    private DefaultMutableTreeNode getSelectedTreeNode() {
        TreePath path = commandsTree.getSelectionPath();
        if (path == null) return null;
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
        return node;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JList bindingsJList;
    private javax.swing.JTree commandsTree;
    private javax.swing.JPanel editKeyBindingsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    private javax.swing.JButton reset;
    private javax.swing.JButton resetitem;
    // End of variables declaration//GEN-END:variables
    
}