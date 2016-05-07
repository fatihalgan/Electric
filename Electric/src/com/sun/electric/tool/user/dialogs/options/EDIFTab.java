/* -*- tab-width: 4 -*-
 *
 * Electric(tm) VLSI Design System
 *
 * File: EDIFTab.java
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

import com.sun.electric.database.text.TextUtils;
import com.sun.electric.tool.io.FileType;
import com.sun.electric.tool.io.IOTool;
import com.sun.electric.tool.user.dialogs.OpenFile;

import javax.swing.JPanel;


/**
 * Class to handle the "EDIF" tab of the Preferences dialog.
 */
public class EDIFTab extends PreferencePanel
{
	/** Creates new form EDIFTab */
	public EDIFTab(java.awt.Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	/** return the panel to use for this preferences tab. */
	public JPanel getPanel() { return edif; }

	/** return the name of this preferences tab. */
	public String getName() { return "EDIF"; }

	/**
	 * Method called at the start of the dialog.
	 * Caches current values and displays them in the EDIF tab.
	 */
	public void init()
	{
		edifUseSchematicView.setSelected(IOTool.isEDIFUseSchematicView());
		edifInputScale.setText(TextUtils.formatDouble(IOTool.getEDIFInputScale()));
		edifCadenceCompatibility.setSelected(IOTool.isEDIFCadenceCompatibility());
		edifConfigFile.setText(IOTool.getEDIFConfigurationFile());
	}

	/**
	 * Method called when the "OK" panel is hit.
	 * Updates any changed fields in the EDIF tab.
	 */
	public void term()
	{
		boolean currentUseSchematicView = edifUseSchematicView.isSelected();
		if (currentUseSchematicView != IOTool.isEDIFUseSchematicView())
			IOTool.setEDIFUseSchematicView(currentUseSchematicView);

		double currentInputScale = TextUtils.atof(edifInputScale.getText());
		if (currentInputScale != IOTool.getEDIFInputScale())
			IOTool.setEDIFInputScale(currentInputScale);

		boolean currentCadenceCompatibility = edifCadenceCompatibility.isSelected();
		if (currentCadenceCompatibility != IOTool.isEDIFCadenceCompatibility())
			IOTool.setEDIFCadenceCompatibility(currentCadenceCompatibility);

		String currentConfigFile = edifConfigFile.getText();
		if (!currentConfigFile.equals(IOTool.getEDIFConfigurationFile()))
			IOTool.setEDIFConfigurationFile(currentConfigFile);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        edif = new javax.swing.JPanel();
        edifUseSchematicView = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        edifInputScale = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        edifConfigFile = new javax.swing.JTextField();
        edifBrowse = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edifCadenceCompatibility = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();

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

        edif.setLayout(new java.awt.GridBagLayout());

        edifUseSchematicView.setText("Use Schematic View when writing");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(edifUseSchematicView, gridBagConstraints);

        jLabel13.setText("Scale by:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(jLabel13, gridBagConstraints);

        edifInputScale.setColumns(6);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(edifInputScale, gridBagConstraints);

        jLabel1.setText("Configuration file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(jLabel1, gridBagConstraints);

        edifConfigFile.setMinimumSize(new java.awt.Dimension(200, 20));
        edifConfigFile.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(edifConfigFile, gridBagConstraints);

        edifBrowse.setText("Browse...");
        edifBrowse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                edifBrowseActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(edifBrowse, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        edif.add(jSeparator1, gridBagConstraints);

        jLabel2.setText("The configuration file provides overrides for controlling");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        edif.add(jLabel2, gridBagConstraints);

        jLabel3.setText("EDIF reading and writing.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        edif.add(jLabel3, gridBagConstraints);

        edifCadenceCompatibility.setText("Cadence compatibility");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(edifCadenceCompatibility, gridBagConstraints);

        jLabel4.setText("when reading");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        edif.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(edif, gridBagConstraints);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

	private void edifBrowseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_edifBrowseActionPerformed
	{//GEN-HEADEREND:event_edifBrowseActionPerformed
		String fileName = OpenFile.chooseInputFile(FileType.ANY, null);
		if (fileName == null) return;
		edifConfigFile.setText(fileName);
	}//GEN-LAST:event_edifBrowseActionPerformed

	/** Closes the dialog */
	private void closeDialog(java.awt.event.WindowEvent evt)//GEN-FIRST:event_closeDialog
	{
		setVisible(false);
		dispose();
	}//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel edif;
    private javax.swing.JButton edifBrowse;
    private javax.swing.JCheckBox edifCadenceCompatibility;
    private javax.swing.JTextField edifConfigFile;
    private javax.swing.JTextField edifInputScale;
    private javax.swing.JCheckBox edifUseSchematicView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
