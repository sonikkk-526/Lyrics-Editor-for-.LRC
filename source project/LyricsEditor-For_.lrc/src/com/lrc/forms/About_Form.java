package com.lrc.forms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class About_Form extends javax.swing.JPanel {

    public About_Form() {
        initComponents();
        github_label.setForeground(new Color(20, 115, 225));
        github_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        openGitHyperLink();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heading_text = new javax.swing.JLabel();
        intro_text = new javax.swing.JLabel();
        feature_text = new javax.swing.JLabel();
        github_label = new javax.swing.JLabel();
        fullstop_text = new javax.swing.JLabel();
        bulletpoint_text = new javax.swing.JLabel();
        projectName_text = new javax.swing.JLabel();
        languageUsed_text = new javax.swing.JLabel();
        author_text = new javax.swing.JLabel();
        projectStatus_text = new javax.swing.JLabel();
        tkx_text = new javax.swing.JLabel();
        gitLink_text = new javax.swing.JLabel();
        copyright_text = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setOpaque(false);

        heading_text.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        heading_text.setForeground(new java.awt.Color(106, 106, 106));
        heading_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading_text.setText("About This Program");

        intro_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        intro_text.setForeground(new java.awt.Color(106, 106, 106));
        intro_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        intro_text.setText("This simple program allows you to easily modify your .lrc files.");

        feature_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        feature_text.setForeground(new java.awt.Color(106, 106, 106));
        feature_text.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        feature_text.setText("For features and details: (1) you could refer back to the Home page or (2) visit my ");

        github_label.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        github_label.setForeground(new java.awt.Color(106, 106, 106));
        github_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        github_label.setText("GitHub Page");

        fullstop_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fullstop_text.setForeground(new java.awt.Color(106, 106, 106));
        fullstop_text.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fullstop_text.setText(".");

        bulletpoint_text.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        bulletpoint_text.setForeground(new java.awt.Color(106, 106, 106));
        bulletpoint_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bulletpoint_text.setText("•");

        projectName_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        projectName_text.setForeground(new java.awt.Color(106, 106, 106));
        projectName_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectName_text.setText("Project: Lyrics Editor for .LRC files");

        languageUsed_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        languageUsed_text.setForeground(new java.awt.Color(106, 106, 106));
        languageUsed_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        languageUsed_text.setText("Language Used: 100% Java");

        author_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        author_text.setForeground(new java.awt.Color(106, 106, 106));
        author_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        author_text.setText("Created By: sonikk.-");

        projectStatus_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        projectStatus_text.setForeground(new java.awt.Color(106, 106, 106));
        projectStatus_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectStatus_text.setText("Project Status: Active (Open-sourced; BSD-4-Caluse applied)");

        tkx_text.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tkx_text.setForeground(new java.awt.Color(106, 106, 106));
        tkx_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tkx_text.setText("Thank you for using my program and hope you enjoyed it.");

        gitLink_text.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        gitLink_text.setForeground(new java.awt.Color(106, 106, 106));
        gitLink_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gitLink_text.setText("GitHub Link (incase of HyperLink does not work): https://github.com/FlashSonic526/LyricsEditor-for_.lrc");

        copyright_text.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        copyright_text.setForeground(new java.awt.Color(106, 106, 106));
        copyright_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyright_text.setText("BSD-4-Clause (License) • All Rights Reserved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(languageUsed_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heading_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gitLink_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tkx_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(copyright_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(intro_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectName_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bulletpoint_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(author_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feature_text, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(github_label)
                        .addGap(0, 0, 0)
                        .addComponent(fullstop_text)
                        .addGap(0, 224, Short.MAX_VALUE))
                    .addComponent(projectStatus_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(heading_text)
                .addGap(1, 1, 1)
                .addComponent(intro_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feature_text)
                    .addComponent(github_label)
                    .addComponent(fullstop_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bulletpoint_text, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectName_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(languageUsed_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(author_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectStatus_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(tkx_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gitLink_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyright_text)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void openGitHyperLink() {
        github_label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    try {
                        desktop.browse(new URI("https://github.com/sonikkk-526/Lyrics-Editor-for-.LRC"));
                    } catch (IOException | URISyntaxException ex) {
                        JOptionPane.showMessageDialog(null, "Failed to redirect to the link above, please try pasting it into your browser and try again.", "𝗪𝗮𝗿𝗻𝗶𝗻𝗴!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel author_text;
    private javax.swing.JLabel bulletpoint_text;
    private javax.swing.JLabel copyright_text;
    private javax.swing.JLabel feature_text;
    private javax.swing.JLabel fullstop_text;
    private javax.swing.JLabel gitLink_text;
    private javax.swing.JLabel github_label;
    private javax.swing.JLabel heading_text;
    private javax.swing.JLabel intro_text;
    private javax.swing.JLabel languageUsed_text;
    private javax.swing.JLabel projectName_text;
    private javax.swing.JLabel projectStatus_text;
    private javax.swing.JLabel tkx_text;
    // End of variables declaration//GEN-END:variables
}
