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
package io.github.hochikong.ktmeta.swingui.codegen;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import io.github.hochikong.ktmeta.swingui.essentials.AggregateSearchTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author ckhoi
 */
public class impMetaAggregateSearch extends javax.swing.JFrame {

    /**
     * Creates new form HeuristicSearch
     */
    public impMetaAggregateSearch() {
        initComponents();
        HideHead();
        setLocationRelativeTo(null);
    }
    
    public impMetaAggregateSearch(String[] MetaLibs, Image icon) {
        this.metaLibs = MetaLibs;
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

        PopupMenuSearch = new javax.swing.JPopupMenu();
        PMSearch = new javax.swing.JMenuItem();
        buttonGroupOnWhere = new javax.swing.ButtonGroup();
        LabelTarget = new javax.swing.JLabel();
        ComboBoxTargetMetaLib = new javax.swing.JComboBox<>();
        BTNGatherAttrs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAttrs = new javax.swing.JTable();
        CheckBoxCreateNewTab = new javax.swing.JCheckBox();
        CheckBoxSearchOnDB = new javax.swing.JCheckBox();
        CheckBoxSearchOnES = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("i18n/Frames/MetaAggregateSearch_trans"); // NOI18N
        PMSearch.setText(bundle.getString("SEARCH")); // NOI18N
        PMSearch.setToolTipText("");
        PMSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMSearchActionPerformed(evt);
            }
        });
        PopupMenuSearch.add(PMSearch);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("AGGREGATE SEARCH")); // NOI18N
        setUndecorated(true);

        LabelTarget.setText(bundle.getString("TARGET METADATA LIBRARY : ")); // NOI18N

        ComboBoxTargetMetaLib.setModel(new javax.swing.DefaultComboBoxModel<>(this.metaLibs));
        ComboBoxTargetMetaLib.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxTargetMetaLibItemStateChanged(evt);
            }
        });

        BTNGatherAttrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ico/20pix/groupby search.png"))); // NOI18N
        BTNGatherAttrs.setText(bundle.getString("GATHER ATTRIBUTES")); // NOI18N
        BTNGatherAttrs.setFocusable(false);
        BTNGatherAttrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGatherAttrsActionPerformed(evt);
            }
        });

        TableAttrs.setAutoCreateRowSorter(true);
        TableAttrs.setModel(new AggregateSearchTableModel());
        TableAttrs.setCellSelectionEnabled(true);
        TableAttrs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableAttrs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAttrsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAttrs);
        TableAttrs.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TableAttrs.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK), "tableQuickSearch");
        TableAttrs.getActionMap().put("tableQuickSearch", quickSearch);

        CheckBoxCreateNewTab.setText(bundle.getString("CREATE NEW TAB")); // NOI18N

        CheckBoxSearchOnDB.setText(bundle.getString("ON DATABASE")); // NOI18N

        CheckBoxSearchOnES.setText(bundle.getString("ON ELASTICSEARCH")); // NOI18N

        jLabel1.setForeground(new java.awt.Color(74, 136, 199));
        jLabel1.setText(bundle.getString("SELECT A CELL TO SEARCH (RIGHT CLICK OR CTRL+ENTER)")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheckBoxSearchOnES)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelTarget)
                                .addComponent(CheckBoxSearchOnDB))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CheckBoxCreateNewTab)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ComboBoxTargetMetaLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BTNGatherAttrs))))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTarget)
                    .addComponent(ComboBoxTargetMetaLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNGatherAttrs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxSearchOnDB)
                    .addComponent(CheckBoxCreateNewTab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxSearchOnES)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<Auto-Generate>
    private void TableAttrsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAttrsMouseClicked
        impTableAttrsMouseClicked(evt);
//        if (SwingUtilities.isRightMouseButton(evt)) {
//            PopupMenuSearch.show(TableAttrs, evt.getX(), evt.getY());
//        }
    }//GEN-LAST:event_TableAttrsMouseClicked

    private void PMSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMSearchActionPerformed
        impPMSearchActionPerformed(evt);
    }//GEN-LAST:event_PMSearchActionPerformed

    private void ComboBoxTargetMetaLibItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxTargetMetaLibItemStateChanged
        impComboBoxTargetMetaLibItemStateChanged(evt);
    }//GEN-LAST:event_ComboBoxTargetMetaLibItemStateChanged

    private void BTNGatherAttrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGatherAttrsActionPerformed
        impBTNGatherAttrsActionPerformed(evt);
    }//GEN-LAST:event_BTNGatherAttrsActionPerformed
    //</Auto-Generate>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new impMetaAggregateSearch().setVisible(true);
            }
        });
    }
    
    //<My-Custom>
    protected String[] metaLibs = new String[] {"Lib 1", "Lib 2"};
    
    // Called by CTRL+ENTER
    protected Action quickSearch = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hit me");
        }
    };
    
    protected void HideHead(){
        // Like IDEA style
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    }
    //</My-Custom>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton BTNGatherAttrs;
    protected javax.swing.JCheckBox CheckBoxCreateNewTab;
    protected javax.swing.JCheckBox CheckBoxSearchOnDB;
    protected javax.swing.JCheckBox CheckBoxSearchOnES;
    protected javax.swing.JComboBox<String> ComboBoxTargetMetaLib;
    private javax.swing.JLabel LabelTarget;
    protected javax.swing.JMenuItem PMSearch;
    private javax.swing.JPopupMenu PopupMenuSearch;
    protected javax.swing.JTable TableAttrs;
    protected javax.swing.ButtonGroup buttonGroupOnWhere;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    //<Auto-Generate-Result>
    protected void impTableAttrsMouseClicked(java.awt.event.MouseEvent evt){}
    protected void impPMSearchActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impComboBoxTargetMetaLibItemStateChanged(java.awt.event.ItemEvent evt){}
    protected void impBTNGatherAttrsActionPerformed(java.awt.event.ActionEvent evt){}
    //</Auto-Generate-Result>
}
