package furlove;

import java.awt.*;
import javax.swing.*;

public class MenuGUI extends javax.swing.JFrame {

    private final Color originalColorBtn;

    public MenuGUI() {
        initComponents();
        originalColorBtn = Color.white;
        GUIHelper.styleComponents(this.getContentPane());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regjistroBtn = new javax.swing.JButton();
        mjekBtn = new javax.swing.JButton();
        adoptimBtn = new javax.swing.JButton();
        rekordetKafsheve = new javax.swing.JButton();
        galeriaBtn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        dmin = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        dil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regjistroBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        regjistroBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/register.png"))); // NOI18N
        regjistroBtn.setText("Regjistro një kafshë ");
        regjistroBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        regjistroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regjistroBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regjistroBtnMouseExited(evt);
            }
        });
        regjistroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regjistroBtnActionPerformed(evt);
            }
        });
        getContentPane().add(regjistroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 290, 50));

        mjekBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        mjekBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vet.png"))); // NOI18N
        mjekBtn.setText("Kujdesi mjekësor");
        mjekBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mjekBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mjekBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mjekBtnMouseExited(evt);
            }
        });
        mjekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mjekBtnActionPerformed(evt);
            }
        });
        getContentPane().add(mjekBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 290, 50));

        adoptimBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        adoptimBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paw.png"))); // NOI18N
        adoptimBtn.setText("Adoptimi");
        adoptimBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        adoptimBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adoptimBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adoptimBtnMouseExited(evt);
            }
        });
        adoptimBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptimBtnActionPerformed(evt);
            }
        });
        getContentPane().add(adoptimBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 290, 50));

        rekordetKafsheve.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        rekordetKafsheve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/records.png"))); // NOI18N
        rekordetKafsheve.setText("Rekordet e kafshëve");
        rekordetKafsheve.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rekordetKafsheve.setMaximumSize(new java.awt.Dimension(200, 27));
        rekordetKafsheve.setMinimumSize(new java.awt.Dimension(200, 27));
        rekordetKafsheve.setPreferredSize(new java.awt.Dimension(200, 27));
        rekordetKafsheve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rekordetKafsheveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rekordetKafsheveMouseExited(evt);
            }
        });
        rekordetKafsheve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekordetKafsheveActionPerformed(evt);
            }
        });
        getContentPane().add(rekordetKafsheve, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 290, 50));

        galeriaBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        galeriaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/galeri.png"))); // NOI18N
        galeriaBtn.setText("Galeria");
        galeriaBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        galeriaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                galeriaBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                galeriaBtnMouseExited(evt);
            }
        });
        galeriaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galeriaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(galeriaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 290, 50));

        bg.setBackground(new java.awt.Color(255, 182, 185));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FurLoveLogo.png"))); // NOI18N
        bg.setOpaque(true);
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 780, 820));

        bg2.setBackground(new java.awt.Color(255, 182, 185));
        bg2.setOpaque(true);
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 800, 820));

        jMenuBar.setAlignmentX(1.0F);
        jMenuBar.setAlignmentY(1.0F);
        jMenuBar.setBorderPainted(false);

        dmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, null, java.awt.Color.darkGray, java.awt.Color.gray));
        dmin.setText("Admin");
        dmin.setAlignmentX(5.0F);
        dmin.setAlignmentY(5.0F);
        dmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dmin.setMaximumSize(new java.awt.Dimension(55, 32767));
        dmin.setMinimumSize(new java.awt.Dimension(55, 35));
        dmin.setPreferredSize(new java.awt.Dimension(50, 35));
        dmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dminActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        jMenuItem1.setText("MBYLL PROGRAMIN");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        dmin.add(jMenuItem1);

        dil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        dil.setText("DIL");
        dil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dilActionPerformed(evt);
            }
        });
        dmin.add(dil);

        jMenuBar.add(dmin);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rekordetKafsheveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekordetKafsheveActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetKafshet().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_rekordetKafsheveActionPerformed

    private void dminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dminActionPerformed

        this.dispose();


    }//GEN-LAST:event_dminActionPerformed

    private void adoptimBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoptimBtnActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adoptimGUI().setVisible(true);
                dispose();
            }
        });

    }//GEN-LAST:event_adoptimBtnActionPerformed

    private void regjistroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regjistroBtnActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regjistroKafshGUI().setVisible(true);
                dispose();
            }
        });

    }//GEN-LAST:event_regjistroBtnActionPerformed

    private void mjekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mjekBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetMjeksore().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_mjekBtnActionPerformed

    private void dilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dilActionPerformed
        new LoginGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_dilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void rekordetKafsheveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rekordetKafsheveMouseEntered
        Color hoverColorBtn = new Color(207, 140, 179);
        rekordetKafsheve.setBackground(hoverColorBtn);
    }//GEN-LAST:event_rekordetKafsheveMouseEntered

    private void rekordetKafsheveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rekordetKafsheveMouseExited
        rekordetKafsheve.setBackground(originalColorBtn);
    }//GEN-LAST:event_rekordetKafsheveMouseExited

    private void adoptimBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptimBtnMouseEntered
        Color hoverColorBtn = new Color(219, 169, 198);
        adoptimBtn.setBackground(hoverColorBtn);
    }//GEN-LAST:event_adoptimBtnMouseEntered

    private void adoptimBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptimBtnMouseExited
        adoptimBtn.setBackground(originalColorBtn);
    }//GEN-LAST:event_adoptimBtnMouseExited

    private void regjistroBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regjistroBtnMouseEntered
        Color hoverColorBtn = new Color(231, 197, 217);
        regjistroBtn.setBackground(hoverColorBtn);
    }//GEN-LAST:event_regjistroBtnMouseEntered

    private void regjistroBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regjistroBtnMouseExited
        regjistroBtn.setBackground(originalColorBtn);
    }//GEN-LAST:event_regjistroBtnMouseExited

    private void mjekBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mjekBtnMouseEntered
        Color hoverColorBtn = new Color(243, 226, 236);
        mjekBtn.setBackground(hoverColorBtn);
    }//GEN-LAST:event_mjekBtnMouseEntered

    private void mjekBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mjekBtnMouseExited
        mjekBtn.setBackground(originalColorBtn);
    }//GEN-LAST:event_mjekBtnMouseExited

    private void galeriaBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galeriaBtnMouseEntered
        Color hoverColorBtn = new Color(243, 226, 236);
        galeriaBtn.setBackground(hoverColorBtn);    }//GEN-LAST:event_galeriaBtnMouseEntered

    private void galeriaBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galeriaBtnMouseExited
        galeriaBtn.setBackground(originalColorBtn);
    }//GEN-LAST:event_galeriaBtnMouseExited

    private void galeriaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galeriaBtnActionPerformed
        new galeriaGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_galeriaBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adoptimBtn;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg2;
    private javax.swing.JMenuItem dil;
    private javax.swing.JMenu dmin;
    private javax.swing.JButton galeriaBtn;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton mjekBtn;
    private javax.swing.JButton regjistroBtn;
    private javax.swing.JButton rekordetKafsheve;
    // End of variables declaration//GEN-END:variables
}
