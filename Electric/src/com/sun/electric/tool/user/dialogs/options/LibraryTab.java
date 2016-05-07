/* -*- tab-width: 4 -*-
 *
 * Electric(tm) VLSI Design System
 *
 * File: LibraryTab.java
 *
 * Copyright (c) 2004 Sun Microsystems and Static Free Software
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
package com.sun.electric.tool.user.dialogs.options;

import com.sun.electric.tool.io.IOTool;

import javax.swing.JPanel;

/**
 * Class to handle the "Library" tab of the Preferences dialog.
 */
public class LibraryTab extends PreferencePanel
{
	/** Creates new form LibraryTab */
	public LibraryTab(java.awt.Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	/** return the panel to use for this preferences tab. */
	public JPanel getPanel() { return library; }

	/** return the name of this preferences tab. */
	public String getName() { return "Library"; }

	/**
	 * Method called at the start of the dialog.
	 * Caches current values and displays them in the Library tab.
	 */
	public void init()
	{
		switch (IOTool.getBackupRedundancy())
		{
			case 0: noBackup.setSelected(true);        break;
			case 1: backupOneLevel.setSelected(true);  break;
			case 2: backupAll.setSelected(true);       break;
		}
	}

	/**
	 * Method called when the "OK" panel is hit.
	 * Updates any changed fields in the Library tab.
	 */
	public void term()
	{
		int currentBackupState = 0;
		if (noBackup.isSelected()) currentBackupState = 0; else
			if (backupOneLevel.isSelected()) currentBackupState = 1; else
				if (backupAll.isSelected()) currentBackupState = 2;
		if (currentBackupState != IOTool.getBackupRedundancy())
			IOTool.setBackupRedundancy(currentBackupState);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    private void initComponents()//GEN-BEGIN:initComponents
    {
        java.awt.GridBagConstraints gridBagConstraints;

        backupGroup = new javax.swing.ButtonGroup();
        library = new javax.swing.JPanel();
        noBackup = new javax.swing.JRadioButton();
        backupOneLevel = new javax.swing.JRadioButton();
        backupAll = new javax.swing.JRadioButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Edit Options");
        setName("");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                closeDialog(evt);
            }
        });

        library.setLayout(new java.awt.GridBagLayout());

        noBackup.setText("No backup of library files");
        backupGroup.add(noBackup);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        library.add(noBackup, gridBagConstraints);

        backupOneLevel.setText("Backup of last library file");
        backupGroup.add(backupOneLevel);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        library.add(backupOneLevel, gridBagConstraints);

        backupAll.setText("Backup history of library files");
        backupGroup.add(backupAll);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        library.add(backupAll, gridBagConstraints);

        getContentPane().add(library, new java.awt.GridBagConstraints());

        pack();
    }//GEN-END:initComponents

	/** Closes the dialog */
	private void closeDialog(java.awt.event.WindowEvent evt)//GEN-FIRST:event_closeDialog
	{
		setVisible(false);
		dispose();
	}//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton backupAll;
    private javax.swing.ButtonGroup backupGroup;
    private javax.swing.JRadioButton backupOneLevel;
    private javax.swing.JPanel library;
    private javax.swing.JRadioButton noBackup;
    // End of variables declaration//GEN-END:variables

}
