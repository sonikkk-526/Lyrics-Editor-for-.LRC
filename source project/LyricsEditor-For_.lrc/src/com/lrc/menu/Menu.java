package com.lrc.menu;

import com.lrc.events.EventMenuSelected;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        list_menu.addEventMenuSelected(event);
    }
    
    public Menu() {
        initComponents();
        list_menu.setOpaque(false);
        init();
    }
    
    private void init() {
        list_menu.addItem(new Model_Menu("1", "Home", Model_Menu.MenuType.MENU));
        list_menu.addItem(new Model_Menu("2", "Lyrics Editor", Model_Menu.MenuType.MENU));
        list_menu.addItem(new Model_Menu("3", "Lyrics Trimming", Model_Menu.MenuType.MENU));
        //list_menu.addItem(new Model_Menu("4", "Lyrics Download", Model_Menu.MenuType.MENU));
        //list_menu.addItem(new Model_Menu("5", "Settings", Model_Menu.MenuType.MENU));
        list_menu.addItem(new Model_Menu("6", "About", Model_Menu.MenuType.MENU));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlebar = new javax.swing.JPanel();
        title_text = new javax.swing.JLabel();
        titlebar_action = new com.lrc.titlebar.TitleBar();
        icon = new javax.swing.JLabel();
        list_menu = new com.lrc.menu.List_Menu<>();

        setBackground(new java.awt.Color(60, 60, 60));
        setPreferredSize(new java.awt.Dimension(330, 925));

        titlebar.setOpaque(false);

        title_text.setForeground(new java.awt.Color(204, 204, 204));
        title_text.setText("Version: v1.2.0 - Author: sonikk.-");

        icon.setBackground(new java.awt.Color(60, 60, 60));
        icon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        icon.setForeground(new java.awt.Color(183, 183, 183));
        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lrc/icon/editor_50.png"))); // NOI18N
        icon.setText("Lyrics Editor");
        icon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout titlebarLayout = new javax.swing.GroupLayout(titlebar);
        titlebar.setLayout(titlebarLayout);
        titlebarLayout.setHorizontalGroup(
            titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(titlebarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(titlebarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(titlebar_action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title_text, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        titlebarLayout.setVerticalGroup(
            titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlebarLayout.createSequentialGroup()
                .addGroup(titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlebar_action, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlebar, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(list_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(list_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    /* A method that allows the undecorated window to move */
    private int coordX, coordY;
    public void initMoving(JFrame fram) {
        titlebar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent client) {
               coordX = client.getX();
               coordY = client.getY();
            }

        });
        titlebar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent client) {
                fram.setLocation(client.getXOnScreen() - coordX, client.getYOnScreen() - coordY);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private com.lrc.menu.List_Menu<String> list_menu;
    private javax.swing.JLabel title_text;
    private javax.swing.JPanel titlebar;
    private com.lrc.titlebar.TitleBar titlebar_action;
    // End of variables declaration//GEN-END:variables
}