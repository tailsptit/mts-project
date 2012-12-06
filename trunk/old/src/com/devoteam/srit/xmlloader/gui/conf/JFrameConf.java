/*
* Copyright 2012 Devoteam http://www.devoteam.com
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
*
* This file is part of Multi-Protocol Test Suite (MTS).
*
* Multi-Protocol Test Suite (MTS) is free software: you can redistribute
* it and/or modify it under the terms of the GNU General Public License 
* as published by the Free Software Foundation, either version 3 of the 
* License.
* 
* Multi-Protocol Test Suite (MTS) is distributed in the hope that it will
* be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
* of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with Multi-Protocol Test Suite (MTS).  
* If not, see <http://www.gnu.org/licenses/>. 
*
*//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameConf.java
 *
 * Created on 28 juin 2010, 14:24:59
 */

package com.devoteam.srit.xmlloader.gui.conf;

import com.devoteam.srit.xmlloader.core.utils.Config;
import javax.swing.JFrame;
import javax.swing.JList;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.devoteam.srit.xmlloader.core.log.GlobalLogger;
import com.devoteam.srit.xmlloader.core.log.TextEvent;
import com.devoteam.srit.xmlloader.core.utils.URIRegistry;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author jbor
 */
public class JFrameConf extends javax.swing.JDialog {

    private JPanelContainer jPanelContainer = new JPanelContainer();
    private String currentFile;
    
    /** Creates new form JFrameConf */
    public JFrameConf(JFrame jFrame, boolean modal) {
        super(jFrame, modal);
        initComponents();
        this.jList.setCellRenderer(new JListRenderer());
        try{
            initJList();
        }
        catch(Exception e){
            GlobalLogger.instance().getApplicationLogger().error(TextEvent.Topic.CORE, e, "Cannot build the list");
        }
        this.jScrollPaneContainer.setViewportView(jPanelContainer);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneJList = new javax.swing.JScrollPane();
        jList = new javax.swing.JList();
        jScrollPaneContainer = new javax.swing.JScrollPane();
        jButtonClose = new javax.swing.JButton();
        jButtonApply = new javax.swing.JButton();
        jButtonUndoAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edit configuration");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jList.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 5));
        jList.setFont(new java.awt.Font("Tahoma", 0, 14));
        jList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListValueChanged(evt);
            }
        });
        jScrollPaneJList.setViewportView(jList);

        jScrollPaneContainer.getVerticalScrollBar().setUnitIncrement(10);
        jScrollPaneContainer.setAlignmentX(0.0F);
        jScrollPaneContainer.setAlignmentY(0.0F);
        jScrollPaneContainer.setAutoscrolls(true);
        jScrollPaneContainer.setMaximumSize(new java.awt.Dimension(600, 32767));
        jScrollPaneContainer.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jScrollPaneContainerComponentResized(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonApply.setText("Apply");
        jButtonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApplyActionPerformed(evt);
            }
        });

        jButtonUndoAll.setText("Undo All");
        jButtonUndoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneJList, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonUndoAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonApply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneJList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonClose)
                            .addComponent(jButtonApply)
                            .addComponent(jButtonUndoAll))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        boolean close = true;
        for(JPanelGeneric panel:this.jPanelContainer.getListOfGeneric()){
            if(panel.isModified()){
                this.showMessagesForClosing();
                close = false;
                break;
            }
        }
        if (close){
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonUndoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoAllActionPerformed
        if (this.jPanelContainer.getComponentCount() > 1){
            this.reset();
        }
    }//GEN-LAST:event_jButtonUndoAllActionPerformed

    private void jButtonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApplyActionPerformed
        if (this.jPanelContainer.getComponentCount() > 1){
            //le container n'est pas vide ie il y a des donnees, on sauvegarde
            Config.getConfigByName(currentFile).save(this.jPanelContainer, this.currentFile);
            if (this.jPanelContainer.restartNeeded()){
                JOptionPane.showMessageDialog( this,"By changing a particular parameter," + "\n" + " you will need to restart IMSLoader in order to the parameter to be effective.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonApplyActionPerformed

    private void jListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListValueChanged
        this.showMessagesForChanges();
        JList jList = (JList) evt.getSource();
        String selectedValue = (String) jList.getSelectedValue();
//        selectedValue = selectedValue + ".properties";
        this.currentFile = selectedValue;
        try{
            Config.getConfigByName(selectedValue).build(this.currentFile, false);
        }
        catch(Exception e){
            GlobalLogger.instance().getApplicationLogger().error(TextEvent.Topic.CORE, e, "Cannot build in list");
        }
        this.build(Config.getConfigByName(this.currentFile));
    }//GEN-LAST:event_jListValueChanged

    private void jScrollPaneContainerComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPaneContainerComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPaneContainerComponentResized

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean close = true;
        for(JPanelGeneric panel:this.jPanelContainer.getListOfGeneric()){
            if(panel.isModified()){
                this.showMessagesForClosing();
                close = false;
                break;
            }
        }
        if (close){
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameConf dialog = new JFrameConf(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApply;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonUndoAll;
    private javax.swing.JList jList;
    private javax.swing.JScrollPane jScrollPaneContainer;
    private javax.swing.JScrollPane jScrollPaneJList;
    // End of variables declaration//GEN-END:variables


    public Object getJListElementAt(int i){
        return this.jList.getModel().getElementAt(i);
    }

    public void setJList (String[] fileList){
        this.jList.removeAll();
        this.jList.setListData(fileList);        
    }

    public void addJPanelContainer(JPanelContainer jPanelContainer){
        this.jScrollPaneContainer.setViewportView(jPanelContainer);
    }

    public void build(Config conf){
        this.jPanelContainer.resetListOfPanelGeneric();
        Vector<String> listOfName = conf.getPropertiesEnhanced().getNameOfAllParameters();
        this.jPanelContainer.clean();
        String type;
        JPanelGeneric panel;
        for (int i = 0; i < listOfName.size(); i++){
            type = Config.getConfigByName(this.currentFile).getPropertiesEnhanced().getType(listOfName.get(i));
            if (type.equals("integer")){
                DocumentFilter filter = new IntegerDocumentFilter();
                panel = new JPanelNumber(conf.getPropertiesEnhanced(), listOfName.get(i), filter);
            }
            else if (type.equals("float")){
                DocumentFilter filter = new FloatDocumentFilter();
                panel = new JPanelNumber(conf.getPropertiesEnhanced(), listOfName.get(i), filter);
            }
            else if (type.equals("boolean")){
                panel = new JPanelBoolean(conf.getPropertiesEnhanced(), listOfName.get(i));
            }
            else if (type.equals("enumeration")){
                panel = new JPanelEnumeration(conf.getPropertiesEnhanced(), listOfName.get(i));
            }
            else{
                panel = new JPanelString(conf.getPropertiesEnhanced(), listOfName.get(i));
            }
            if (i%2 == 0){
                panel.setBackground(panel.getBackground().brighter());
            }
            this.jPanelContainer.addJPanelGeneric(panel);
        }
        this.jPanelContainer.addJPanelGeneric(null);
        this.addJPanelContainer(this.jPanelContainer);
        this.setVisible(true);
    }

    public void showMessagesForClosing(){
        if (this.jPanelContainer.getComponentCount() > 1 && this.jPanelContainer.isModified()){
            int choix = JOptionPane.showConfirmDialog(this, "Something has changed, do you want to save?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choix == JOptionPane.OK_OPTION){
                Config.getConfigByName(currentFile).save(this.jPanelContainer, this.currentFile);
                if (this.jPanelContainer.restartNeeded()){
                    JOptionPane.showMessageDialog(this, "By changing a particular parameter," + "\n" + " you will need to restart IMSLoader in order to the parameter to be effective.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                this.dispose();
            }
            else if (choix == JOptionPane.NO_OPTION){
                this.dispose();
            }
        }
    }

    public void showMessagesForChanges(){
        if (this.jPanelContainer.getComponentCount() > 1 && this.jPanelContainer.isModified()){
            int choix = JOptionPane.showConfirmDialog(this, "Something has changed, do you want to save?", "Warning", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.OK_OPTION){
                Config.getConfigByName(currentFile).save(this.jPanelContainer, this.currentFile);
                if (this.jPanelContainer.restartNeeded()){
                    JOptionPane.showMessageDialog(this, "By changing a particular parameter," + "\n" + " you will need to restart IMSLoader in order to the parameter to be effective.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    public void reset(){
        for(JPanelGeneric panel:this.jPanelContainer.getListOfGeneric()){
            panel.resetSpecific();
        }
    }

    public void setUndoAllEnable(boolean enable){
        this.jButtonUndoAll.setEnabled(enable);
    }

    public void setApplyEnable (boolean enable){
        this.jButtonApply.setEnabled(enable);
    }

    public JPanelContainer getJPanelContainer(){
        return this.jPanelContainer;
    }

    public void initJList() throws Exception{
        HashSet<String> merge = new HashSet();
        URI filePathInputConf = URIRegistry.IMSLOADER_BIN.resolve("../conf/");
        merge.addAll(addInJListFromDirectory(filePathInputConf));
        merge.addAll(addInJListFromConfig());
        String[] list = merge.toArray(new String[0]);
//        for (int i = 0; i < list.length; i++){
//            if (list[i].endsWith(".properties")){
//                list[i] = list[i].substring(0, list[i].lastIndexOf("."));
//            }
//        }
        Arrays.sort(list, null);
        this.setJList(list);
    }


    public HashSet addInJListFromConfig(){
        HashSet<String> set = new HashSet<String>();
        set.addAll(Config.getListOfPorpertiesFile());
        return set;
    }
    public HashSet addInJListFromDirectory(URI filePathURI){
        //creation d'un filtre pour ne recuperer que les fichiers *.properties
        FilenameFilter propertiesFilter = new FilenameFilter() {
            public boolean accept(File arg0, String arg1) {
                return arg1.endsWith(".properties");
            }
        };
        File filePath = new File (filePathURI);
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < filePath.list(propertiesFilter).length; i++){
            set.add(filePath.list(propertiesFilter)[i]);
        }        
        return set;
    }
}