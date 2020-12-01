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
package io.github.hochikong.ktmeta.swingui;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ckhoi
 */
public class LaunchView extends javax.swing.JFrame {

    /**
     * Creates new form LaunchView
     */
    public LaunchView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public LaunchView(Image icon) {
        initComponents();
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

        PanelBackgroundPicture = new javax.swing.JPanel() {
            private final Image img = new ImageIcon(getClass().getResource("/imgs/launchLOGO.png")).getImage();
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        };
        ProgressBarLaunching = new javax.swing.JProgressBar();
        LabelLaunchingStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(606, 376));
        setMinimumSize(new java.awt.Dimension(606, 376));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(606, 376));

        ProgressBarLaunching.setIndeterminate(true);

        LabelLaunchingStatus.setText("Launching ...");

        javax.swing.GroupLayout PanelBackgroundPictureLayout = new javax.swing.GroupLayout(PanelBackgroundPicture);
        PanelBackgroundPicture.setLayout(PanelBackgroundPictureLayout);
        PanelBackgroundPictureLayout.setHorizontalGroup(
            PanelBackgroundPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBackgroundPictureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProgressBarLaunching, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBackgroundPictureLayout.createSequentialGroup()
                .addContainerGap(359, Short.MAX_VALUE)
                .addComponent(LabelLaunchingStatus)
                .addGap(163, 163, 163))
        );
        PanelBackgroundPictureLayout.setVerticalGroup(
            PanelBackgroundPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBackgroundPictureLayout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(LabelLaunchingStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProgressBarLaunching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBackgroundPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBackgroundPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaunchView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel LabelLaunchingStatus;
    protected javax.swing.JPanel PanelBackgroundPicture;
    protected javax.swing.JProgressBar ProgressBarLaunching;
    // End of variables declaration//GEN-END:variables
}