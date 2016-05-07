/* -*- tab-width: 4 -*-
 *
 * Electric(tm) VLSI Design System
 *
 * File: DEFTab.java
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

import com.sun.electric.database.text.Pref;
import com.sun.electric.tool.io.IOTool;

import javax.swing.JPanel;


/**
 * Class to handle the "DEF" tab of the Preferences dialog.
 */
public class DEFTab extends PreferencePanel
{
	/** Creates new form DEFTab */
	public DEFTab(java.awt.Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	/** return the panel to use for this preferences tab. */
	public JPanel getPanel() { return def; }

	/** return the name of this preferences tab. */
	public String getName() { return "DEF"; }

	/**
	 * Method called at the start of the dialog.
	 * Caches current values and displays them in the DEF tab.
	 */
	public void init()
	{
		defPlaceLogical.setSelected(IOTool.isDEFLogicalPlacement());
		defPlacePhysical.setSelected(IOTool.isDEFPhysicalPlacement());
	}

	/**
	 * Method called when the "OK" panel is hit.
	 * Updates any changed fields in the DEF tab.
	 */
	public void term()
	{
		boolean currentValue = defPlaceLogical.isSelected();
		if (currentValue != IOTool.isDEFLogicalPlacement())
			IOTool.setDEFLogicalPlacement(currentValue);

		currentValue = defPlacePhysical.isSelected();
		if (currentValue != IOTool.isDEFPhysicalPlacement())
			IOTool.setDEFPhysicalPlacement(currentValue);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    private void initComponents()//GEN-BEGIN:initComponents
    {
        java.awt.GridBagConstraints gridBagConstraints;

        def = new javax.swing.JPanel();
        defPlacePhysical = new javax.swing.JCheckBox();
        defPlaceLogical = new javax.swing.JCheckBox();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("IO Options");
        setName("");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                closeDialog(evt);
            }
        });

        def.setLayout(new java.awt.GridBagLayout());

        defPlacePhysical.setText("Place physical interconnect");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        def.add(defPlacePhysical, gridBagConstraints);

        defPlaceLogical.setText("Place logical interconnect");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        def.add(defPlaceLogical, gridBagConstraints);

        getContentPane().add(def, new java.awt.GridBagConstraints());

        pack();
    }//GEN-END:initComponents

	/** Closes the dialog */
	private void closeDialog(java.awt.event.WindowEvent evt)//GEN-FIRST:event_closeDialog
	{
		setVisible(false);
		dispose();
	}//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel def;
    private javax.swing.JCheckBox defPlaceLogical;
    private javax.swing.JCheckBox defPlacePhysical;
    // End of variables declaration//GEN-END:variables

}
