package com.lrc.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Menu_Item extends javax.swing.JPanel {
    
    private boolean selected, hover;
    
    public Menu_Item(Model_Menu data) {
        initComponents();
        setOpaque(false);
        
        if (data.getType() == Model_Menu.MenuType.MENU) {
            icon.setIcon(data.toIcon());
            MenuName.setText(data.getName());
        } else if (data.getType() == Model_Menu.MenuType.TITLE) {
            icon.setText(data.getName());
            icon.setFont(new Font("sansserif", Font.PLAIN, 12));
            MenuName.setVisible(false);
        } else {
            MenuName.setText("  ");
        }
    }
    
    public void setHover(boolean hover) {
        this.hover = hover;
        repaint();
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        MenuName = new javax.swing.JLabel();
        stand = new javax.swing.JLabel();

        icon.setBackground(new java.awt.Color(255, 255, 255));
        icon.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        MenuName.setBackground(new java.awt.Color(255, 255, 255));
        MenuName.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        MenuName.setForeground(new java.awt.Color(204, 204, 204));
        MenuName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stand, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(icon)
                .addGap(18, 18, 18)
                .addComponent(MenuName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(MenuName)))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics grphcs) {
        if (selected || hover) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected) {
                g2.setColor(new Color(255, 255, 255, 80));
            } else {
                g2.setColor(new Color(255, 255, 255, 20));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenuName;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel stand;
    // End of variables declaration//GEN-END:variables
}
