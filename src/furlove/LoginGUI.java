package furlove;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class LoginGUI extends JFrame {

    public LoginGUI() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GUIHelper.styleComponents(this.getContentPane());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background3 = new javax.swing.JLabel();
        aLabel = new javax.swing.JLabel();
        eLabel = new javax.swing.JLabel();
        fjalekalimLabel = new javax.swing.JLabel();
        eTextField = new javax.swing.JTextField();
        labelH1 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        loginButon = new javax.swing.JButton();
        background2 = new javax.swing.JLabel();
        background4 = new javax.swing.JLabel();
        background5 = new javax.swing.JLabel();

        background3.setBackground(new java.awt.Color(204, 255, 255));
        background3.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Identifikohu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aLabel.setFont(new java.awt.Font("Swis721 Ex BT", 0, 12)); // NOI18N
        aLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aLabel.setText("Admin");
        getContentPane().add(aLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, 20));

        eLabel.setFont(new java.awt.Font("Swis721 Lt BT", 0, 16)); // NOI18N
        eLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        eLabel.setText("Email");
        getContentPane().add(eLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, 30));

        fjalekalimLabel.setFont(new java.awt.Font("Swis721 Lt BT", 0, 16)); // NOI18N
        fjalekalimLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fjalekalimLabel.setText("Fjalëkalimi");
        getContentPane().add(fjalekalimLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, 30));

        eTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(eTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 281, 30));

        labelH1.setFont(new java.awt.Font("Swis721 Lt BT", 0, 36)); // NOI18N
        labelH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelH1.setText("Identifikohu");
        getContentPane().add(labelH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, 50));

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 281, 30));

        loginButon.setFont(new java.awt.Font("Swis721 Lt BT", 0, 12)); // NOI18N
        loginButon.setText("LOGIN");
        loginButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, 30));

        background2.setBackground(new java.awt.Color(204, 255, 255));
        background2.setOpaque(true);
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 580));

        background4.setBackground(new java.awt.Color(204, 255, 255));
        background4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FurLoveLogin.png"))); // NOI18N
        background4.setOpaque(true);
        getContentPane().add(background4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 750, 840));

        background5.setBackground(new java.awt.Color(204, 255, 255));
        background5.setOpaque(true);
        getContentPane().add(background5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 810, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
    }//GEN-LAST:event_passFieldActionPerformed

    private void eTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eTextFieldActionPerformed
    }//GEN-LAST:event_eTextFieldActionPerformed

    private void loginButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButonActionPerformed
        String email = eTextField.getText();
        String fjalekalim = new String(passField.getPassword());

        try {
            Connection con = connect.ConnectProvider.getCon();
            String hashed = SecurityUtil.hashPassword(fjalekalim);

            String queryHashed = "SELECT * FROM admin WHERE email = ? AND password = ?";
            PreparedStatement stm = con.prepareStatement(queryHashed);
            stm.setString(1, email);
            stm.setString(2, hashed);
            ResultSet res = stm.executeQuery();

            if (res.next()) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new MenuGUI().setVisible(true);
                        dispose();
                    }
                });
            } else {
                String queryPlain = "SELECT * FROM admin WHERE email = ? AND password = ?";
                try (PreparedStatement stm2 = con.prepareStatement(queryPlain)) {
                    stm2.setString(1, email);
                    stm2.setString(2, fjalekalim);
                    try (ResultSet res2 = stm2.executeQuery()) {
                        if (res2.next()) {

                            try (PreparedStatement up = con.prepareStatement("UPDATE admin SET password = ? WHERE email = ?")) {
                                up.setString(1, hashed);
                                up.setString(2, email);
                                up.executeUpdate();
                            } catch (SQLException ignore) {
                            }
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    new MenuGUI().setVisible(true);
                                    dispose();
                                }
                            });
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Logim i pasuksesshem! Kontrollo email/password!");
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginButonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel background3;
    private javax.swing.JLabel background4;
    private javax.swing.JLabel background5;
    private javax.swing.JLabel eLabel;
    private javax.swing.JTextField eTextField;
    private javax.swing.JLabel fjalekalimLabel;
    private javax.swing.JLabel labelH1;
    private javax.swing.JButton loginButon;
    private javax.swing.JPasswordField passField;
    // End of variables declaration//GEN-END:variables
}
