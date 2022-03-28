package com.lrc.forms;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComponent;

public class Index_1 extends javax.swing.JPanel {
    private Editor_Form editorPage;
    private Merge_Form mergePage;
    
    public Index_1() {
        initComponents();
        setOpaque(false);
        
        mergePage = new Merge_Form();
        editorPage = new Editor_Form(mergePage);
        
        setForm(editorPage);
        
        pageSelectionBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (pageSelectionBox.getSelectedItem().toString().equals("Merge")) {
                        setForm(mergePage);
                    } else if (pageSelectionBox.getSelectedItem().toString().equals("Editor")) {
                        setForm(editorPage);
                    }
                   
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headings = new javax.swing.JPanel();
        form_title = new javax.swing.JLabel();
        form_logo = new javax.swing.JLabel();
        pageSelectionBox = new com.lrc.componenet.Combobox();
        subPanel = new javax.swing.JPanel();

        setOpaque(false);

        headings.setOpaque(false);

        form_title.setFont(new java.awt.Font("Segoe UI Semilight", 1, 32)); // NOI18N
        form_title.setForeground(new java.awt.Color(163, 163, 163));
        form_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        form_title.setText(" Lyrics Editor");

        form_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lrc/icon/2.png"))); // NOI18N

        pageSelectionBox.setBackground(new java.awt.Color(43, 43, 43));
        pageSelectionBox.setForeground(new java.awt.Color(204, 204, 204));
        pageSelectionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Editor", "Merge" }));
        pageSelectionBox.setSelectedIndex(-1);
        pageSelectionBox.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        pageSelectionBox.setLabeText("Page");
        pageSelectionBox.setOpaque(false);

        javax.swing.GroupLayout headingsLayout = new javax.swing.GroupLayout(headings);
        headings.setLayout(headingsLayout);
        headingsLayout.setHorizontalGroup(
            headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(form_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 857, Short.MAX_VALUE)
                .addComponent(pageSelectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        headingsLayout.setVerticalGroup(
            headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headingsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(form_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(form_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pageSelectionBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        subPanel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        subPanel.setOpaque(false);
        subPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(headings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setForm(JComponent com) {
        subPanel.removeAll();
        subPanel.add(com);
        subPanel.repaint();
        subPanel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel form_logo;
    private javax.swing.JLabel form_title;
    private javax.swing.JPanel headings;
    private com.lrc.componenet.Combobox pageSelectionBox;
    private javax.swing.JPanel subPanel;
    // End of variables declaration//GEN-END:variables
}
