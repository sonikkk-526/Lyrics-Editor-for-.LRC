package com.lrc.forms;

public class Merge_Form extends javax.swing.JPanel {
    
    public Merge_Form() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanel = new javax.swing.JPanel();
        mergeLyricsPane = new com.lrc.componenet.TextAreaScroll();
        mergeLyricsInputs = new com.lrc.componenet.TextArea();

        setOpaque(false);

        subPanel.setOpaque(false);

        mergeLyricsPane.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        mergeLyricsPane.setLabelText("Put your merge lyrics here...");
        mergeLyricsPane.setOpaque(false);

        mergeLyricsInputs.setBackground(new java.awt.Color(43, 43, 43));
        mergeLyricsInputs.setColumns(20);
        mergeLyricsInputs.setForeground(new java.awt.Color(204, 204, 204));
        mergeLyricsInputs.setRows(5);
        mergeLyricsInputs.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        mergeLyricsPane.setViewportView(mergeLyricsInputs);

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(mergeLyricsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mergeLyricsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public com.lrc.componenet.TextArea getMergeLyricsInputs() {
        return mergeLyricsInputs;
    }
    
    /**
     * Return a String array of the inputs
     * @return String Array with the inputs
     */
    public String[] getMergeLyrics() {
        return mergeLyricsInputs.getText().toString().replace(System.getProperty("line.separator"), "\\n").split("\\n");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lrc.componenet.TextArea mergeLyricsInputs;
    private com.lrc.componenet.TextAreaScroll mergeLyricsPane;
    private javax.swing.JPanel subPanel;
    // End of variables declaration//GEN-END:variables
}
