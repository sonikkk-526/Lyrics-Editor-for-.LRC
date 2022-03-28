package com.lrc.main;

import com.lrc.events.EventMenuSelected;
import com.lrc.forms.*;

import java.awt.Color;
import javax.swing.JComponent;

public class Main extends javax.swing.JFrame {
    // instance variables
    private Home_Form home = new Home_Form();
    private Index_1 editor = new Index_1();
    private About_Form about = new About_Form();
    
    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setForm(new Home_Form()); // set home page/default page.

        menu.initMoving(this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                // System.out.println("Selected Index : " + index);
                switch (index) {
                    case 0:
                        setForm(home);
                        break;
                    case 1:
                        setForm(editor);
                        break;
                    case 2:
                        setForm(about);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    
    private void setForm(JComponent com) {
        main_panel.removeAll();
        main_panel.add(com);
        main_panel.repaint();
        main_panel.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UIPanel = new com.lrc.main.PanelBorder();
        manuPanel = new javax.swing.JPanel();
        menu = new com.lrc.menu.Menu();
        main_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        UIPanel.setBackground(new java.awt.Color(43, 43, 43));

        manuPanel.setOpaque(false);

        javax.swing.GroupLayout manuPanelLayout = new javax.swing.GroupLayout(manuPanel);
        manuPanel.setLayout(manuPanelLayout);
        manuPanelLayout.setHorizontalGroup(
            manuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 384, Short.MAX_VALUE)
        );
        manuPanelLayout.setVerticalGroup(
            manuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );

        main_panel.setOpaque(false);
        main_panel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout UIPanelLayout = new javax.swing.GroupLayout(UIPanel);
        UIPanel.setLayout(UIPanelLayout);
        UIPanelLayout.setHorizontalGroup(
            UIPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UIPanelLayout.createSequentialGroup()
                .addComponent(manuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE))
        );
        UIPanelLayout.setVerticalGroup(
            UIPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UIPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UIPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lrc.main.PanelBorder UIPanel;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel manuPanel;
    private com.lrc.menu.Menu menu;
    // End of variables declaration//GEN-END:variables
}
