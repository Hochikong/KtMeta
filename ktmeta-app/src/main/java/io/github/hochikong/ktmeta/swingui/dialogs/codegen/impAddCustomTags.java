/*
 * Copyright 2020 Hochikong
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.hochikong.ktmeta.swingui.dialogs.codegen;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import io.github.hochikong.ktmeta.swingui.essentials.CustomTagsTableModel;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ckhoi
 */
public class impAddCustomTags extends javax.swing.JDialog {

    /**
     * Creates new form AddIndexWizard
     */
    public impAddCustomTags(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        HideHead();
        this.setLocationRelativeTo(null);
    }
    
    public impAddCustomTags(java.awt.Frame parent, boolean modal, Object[][] TagsData, Image icon){
        super(parent, modal);
        this.tagsData = TagsData;
        initComponents();
        HideHead();
        this.setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenuTagsOps = new javax.swing.JPopupMenu();
        MenuItemRemoveTag = new javax.swing.JMenuItem();
        MenuItemRenameTag = new javax.swing.JMenuItem();
        BTNCancelAddTags = new javax.swing.JButton();
        BTNOKAddTags = new javax.swing.JButton();
        LabelCurrentTags = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUserCustomTags = new javax.swing.JTable();
        LabelAddTag = new javax.swing.JLabel();
        TextFieldAddTag = new javax.swing.JTextField();
        BTNAddTag = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("i18n/Dialogs/AddCustomTags_trans"); // NOI18N
        MenuItemRemoveTag.setText(bundle.getString("REMOVE")); // NOI18N
        MenuItemRemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRemoveTagActionPerformed(evt);
            }
        });
        PopupMenuTagsOps.add(MenuItemRemoveTag);

        MenuItemRenameTag.setText(bundle.getString("RENAME")); // NOI18N
        MenuItemRenameTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRenameTagActionPerformed(evt);
            }
        });
        PopupMenuTagsOps.add(MenuItemRenameTag);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("ADD CUSTOM TAGS")); // NOI18N
        setUndecorated(true);

        BTNCancelAddTags.setText(bundle.getString("CANCEL")); // NOI18N
        BTNCancelAddTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCancelAddTagsActionPerformed(evt);
            }
        });

        BTNOKAddTags.setText(bundle.getString("OK")); // NOI18N
        BTNOKAddTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNOKAddTagsActionPerformed(evt);
            }
        });

        LabelCurrentTags.setText(bundle.getString("CURRENT USER CUSTOM TAGS : ")); // NOI18N

        TableUserCustomTags.setAutoCreateRowSorter(true);
        TableUserCustomTags.setModel(new CustomTagsTableModel());
        TableUserCustomTags.setCellSelectionEnabled(true);
        TableUserCustomTags.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableUserCustomTags.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUserCustomTagsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableUserCustomTags);

        LabelAddTag.setText(bundle.getString("ADD TAG : ")); // NOI18N

        BTNAddTag.setText(bundle.getString("ADD")); // NOI18N
        BTNAddTag.setToolTipText(bundle.getString("ADD NEW TAG")); // NOI18N
        BTNAddTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAddTagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNOKAddTags)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNCancelAddTags))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LabelAddTag)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldAddTag, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNAddTag))
                        .addComponent(LabelCurrentTags)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LabelCurrentTags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldAddTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelAddTag)
                    .addComponent(BTNAddTag))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNOKAddTags)
                    .addComponent(BTNCancelAddTags))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<Auto-Generate>
    private void TableUserCustomTagsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUserCustomTagsMouseClicked
        impTableUserCustomTagsMouseClicked(evt);
    }//GEN-LAST:event_TableUserCustomTagsMouseClicked

    private void BTNAddTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAddTagActionPerformed
        impBTNAddTagActionPerformed(evt);
    }//GEN-LAST:event_BTNAddTagActionPerformed

    private void BTNOKAddTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNOKAddTagsActionPerformed
        impBTNOKAddTagsActionPerformed(evt);
    }//GEN-LAST:event_BTNOKAddTagsActionPerformed

    private void BTNCancelAddTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCancelAddTagsActionPerformed
        impBTNCancelAddTagsActionPerformed(evt);
    }//GEN-LAST:event_BTNCancelAddTagsActionPerformed

    private void MenuItemRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRemoveTagActionPerformed
        impMenuItemRemoveTagActionPerformed(evt);
    }//GEN-LAST:event_MenuItemRemoveTagActionPerformed

    private void MenuItemRenameTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRenameTagActionPerformed
        impMenuItemRenameTagActionPerformed(evt);
    }//GEN-LAST:event_MenuItemRenameTagActionPerformed
    //</Auto-Generate>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.install();

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                impAddCustomTags dialog = new impAddCustomTags(new javax.swing.JFrame(), true);
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
    
    //<My-Custom>
    protected Object[][] tagsData;
    
    protected void HideHead(){
        // Like IDEA style
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    }
    //</My-Custom>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAddTag;
    protected javax.swing.JButton BTNCancelAddTags;
    protected javax.swing.JButton BTNOKAddTags;
    private javax.swing.JLabel LabelAddTag;
    private javax.swing.JLabel LabelCurrentTags;
    protected javax.swing.JMenuItem MenuItemRemoveTag;
    protected javax.swing.JMenuItem MenuItemRenameTag;
    protected javax.swing.JPopupMenu PopupMenuTagsOps;
    protected javax.swing.JTable TableUserCustomTags;
    protected javax.swing.JTextField TextFieldAddTag;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    //<Auto-Generate-Result>
    protected void impTableUserCustomTagsMouseClicked(java.awt.event.MouseEvent evt){}
    protected void impBTNAddTagActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impBTNOKAddTagsActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impBTNCancelAddTagsActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impMenuItemRemoveTagActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impMenuItemRenameTagActionPerformed(java.awt.event.ActionEvent evt){}
    //</Auto-Generate-Result>
}
