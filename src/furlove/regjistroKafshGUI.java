package furlove;

import java.awt.Frame;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class regjistroKafshGUI extends javax.swing.JFrame {

    public regjistroKafshGUI() {
        initComponents();
        Connect();
        Load();
        initCustomHandlers();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GUIHelper.styleComponents(this.getContentPane());

    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furlove", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Load() {

        k_status.removeAllItems();
        k_status.addItem("--");
        String[] statuset = {"Shëndetshëm", "I sëmurë", "Në trajtim", "Në rikuperim"};
        for (String s : statuset) {
            k_status.addItem(s);
        }

        try {
            speciaText.removeAllItems();
            speciaText.addItem("--");

            pst = con.prepareStatement("SELECT specia FROM specia");
            rs = pst.executeQuery();

            while (rs.next()) {
                speciaText.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initCustomHandlers() {
        regjistroButon.addActionListener(evt -> handleRegister());
    }

    private void handleRegister() {
        String specia = capitalizeFirstLetter(speciaText.getSelectedItem().toString().trim());
        String emri = capitalizeFirstLetter(emriTxt.getText().trim());
        String gjinia = gjiniaS.getSelectedItem().toString().trim();
        String vendndodhjaFundit = vfTxt.getText().trim();
        String statusi = (String) k_status.getSelectedItem();
        String gjendjaShendetsore = gjendjaShText.getText().trim();
        String komente = komenteTxt.getText().trim();

        if (emri.isEmpty() || specia.isEmpty() || gjinia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Te lutem ploteso te dhenat kryesore: Emri, Specia, Gjinia.", "Verejtje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ("--".equals(statusi)) {
            JOptionPane.showMessageDialog(this, "Te lutem zgjidh statusin shendetesor.", "Verejtje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            con.setAutoCommit(false);

            String insertAnimalSql = "INSERT INTO kafshet (emri, specia, gjinia, statusiShendetesor, gjendjaShendetesore, vendndodhjaFundit, komente) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertAnimalSql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, emri);
                ps.setString(2, specia);
                ps.setString(3, gjinia);
                ps.setString(4, statusi);
                ps.setString(5, gjendjaShendetsore);
                ps.setString(6, vendndodhjaFundit);
                ps.setString(7, komente);
                ps.executeUpdate();

                int generatedId = -1;
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        generatedId = keys.getInt(1);
                    }
                }

                if (generatedId == -1) {
                    con.rollback();
                    JOptionPane.showMessageDialog(this, "Deshtoi marrja e ID-se se kafshes.", "Gabim", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }

            con.commit();
            String successMsg = "Regjistrimi u krye me sukses!";
            JOptionPane.showMessageDialog(this, successMsg, "Sukses", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ignore) {
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problem ne regjistrim: " + ex.getMessage(), "Gabim", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    private void clearForm() {
        emriTxt.setText("");
        speciaText.setSelectedIndex(0);
        gjiniaS.setSelectedIndex(0);
        vfTxt.setText("");
        komenteTxt.setText("");
        gjendjaShText.setText("");
        if (k_status.getItemCount() > 0) {
            k_status.setSelectedIndex(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelH1 = new javax.swing.JLabel();
        regjistroButon = new javax.swing.JButton();
        komentLabel = new javax.swing.JLabel();
        emriTxt = new javax.swing.JTextField();
        emriLabel = new javax.swing.JLabel();
        vfTxt = new javax.swing.JTextField();
        speciaLabel = new javax.swing.JLabel();
        gjiniaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        komenteTxt = new javax.swing.JTextArea();
        vfLabel = new javax.swing.JLabel();
        gjiniaS = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        gjendjaShText = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        k_status = new javax.swing.JComboBox<>();
        gjendjaLabel = new javax.swing.JLabel();
        speciaText = new javax.swing.JComboBox<>();
        Pastro = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        rekordetKthim = new javax.swing.JMenuItem();
        galeriMenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        specieMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regjistro këtu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelH1.setFont(new java.awt.Font("Swis721 Lt BT", 0, 36)); // NOI18N
        labelH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelH1.setText("Regjistro mikun me putra");
        getContentPane().add(labelH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 422, 53));

        regjistroButon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        regjistroButon.setText("Regjistro");
        getContentPane().add(regjistroButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, 161, 47));

        komentLabel.setText("Komente");
        getContentPane().add(komentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 350, 60, -1));

        emriTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emriTxtActionPerformed(evt);
            }
        });
        getContentPane().add(emriTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 90, -1));

        emriLabel.setText("Emri");
        getContentPane().add(emriLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, -1));

        vfTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vfTxtActionPerformed(evt);
            }
        });
        getContentPane().add(vfTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 310, 230, -1));

        speciaLabel.setText("Specia");
        getContentPane().add(speciaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        gjiniaLabel.setText("Gjinia");
        getContentPane().add(gjiniaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        komenteTxt.setColumns(20);
        komenteTxt.setRows(5);
        komenteTxt.setMaximumSize(new java.awt.Dimension(100, 65));
        komenteTxt.setMinimumSize(new java.awt.Dimension(10, 15));
        komenteTxt.setPreferredSize(new java.awt.Dimension(100, 60));
        jScrollPane2.setViewportView(komenteTxt);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 350, 230, 70));

        vfLabel.setText("Vendodhja");
        getContentPane().add(vfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 300, 60, 30));

        gjiniaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        getContentPane().add(gjiniaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 90, -1));

        gjendjaShText.setColumns(20);
        gjendjaShText.setRows(5);
        gjendjaShText.setMaximumSize(new java.awt.Dimension(100, 65));
        gjendjaShText.setPreferredSize(new java.awt.Dimension(100, 50));
        jScrollPane3.setViewportView(gjendjaShText);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 460, 230, 80));

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusLabel.setText("Statusi shendetesor");
        getContentPane().add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

        k_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(k_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 450, -1, -1));

        gjendjaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gjendjaLabel.setText("Gjendja shendetsore");
        getContentPane().add(gjendjaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 460, -1, -1));

        speciaText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(speciaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, 90, -1));

        Pastro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Pastro.setText("Pastro");
        getContentPane().add(Pastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 580, 161, 47));

        URL imgUrl = getClass().getResource("/icons/Fur-LoveTransparent-Reg.png");

        try{

            if (imgUrl == null) {
                File devPath = new File("src/icons/Fur-LoveTransparent-Reg.png");
                if (devPath.exists()) {
                    imgUrl = devPath.toURI().toURL();
                }
            }

            if (imgUrl != null) {
                ImageIcon iconOriginal = new ImageIcon(imgUrl);
                Image iconScaled = iconOriginal.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                foto.setIcon(new javax.swing.ImageIcon(iconScaled));
            } else {
                System.out.println("Image not found!");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Path to image is invalid: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage());
        }
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 500, 390));

        menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        menu.setText("Ktheu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        menuKthehu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        menuKthehu.setText("Menu kryesore");
        menuKthehu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKthehuActionPerformed(evt);
            }
        });
        menu.add(menuKthehu);

        rekordetKthim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/records.png"))); // NOI18N
        rekordetKthim.setText("Rekordet e kafsheve");
        rekordetKthim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekordetKthimActionPerformed(evt);
            }
        });
        menu.add(rekordetKthim);

        galeriMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/galeri.png"))); // NOI18N
        galeriMenu.setText("Galeria");
        galeriMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galeriMenuActionPerformed(evt);
            }
        });
        menu.add(galeriMenu);

        jMenuBar.add(menu);

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        jMenu1.setText("Shto...");

        specieMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paws.png"))); // NOI18N
        specieMenu.setText("specie");
        specieMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specieMenuActionPerformed(evt);
            }
        });
        jMenu1.add(specieMenu);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuKthehuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKthehuActionPerformed

        new MenuGUI().setVisible(true);
        dispose();

    }//GEN-LAST:event_menuKthehuActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
                dispose();
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_menuActionPerformed

    private void rekordetKthimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekordetKthimActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetKafshet().setVisible(true);
                dispose();
            }
        });

    }//GEN-LAST:event_rekordetKthimActionPerformed

    private void galeriMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galeriMenuActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new galeriaGUI().setVisible(true);
            }
        });

    }//GEN-LAST:event_galeriMenuActionPerformed

    private void emriTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emriTxtActionPerformed
    }//GEN-LAST:event_emriTxtActionPerformed

    private void vfTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vfTxtActionPerformed

    }//GEN-LAST:event_vfTxtActionPerformed

    private void specieMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specieMenuActionPerformed
        JDialog dialog = new JDialog((Frame) null, "Shto Specie", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);
        JPanel panelSpecia = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel emriJLabel = new JLabel("Specia:");
        JTextField speciaField = new JTextField(15);
        JButton shtoBtn = new JButton("Shto");
        shtoBtn.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelSpecia.add(emriJLabel, gbc);
        gbc.gridx = 1;
        panelSpecia.add(speciaField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelSpecia.add(shtoBtn, gbc);
        shtoBtn.addActionListener(e -> {
            try {
                pst = con.prepareStatement("INSERT INTO specia(specia) VALUES(?)");
                pst.setString(1, speciaField.getText());
                int rows = pst.executeUpdate();
                if (rows > 0) {
                    System.out.println("Specia u shtuar!");
                }
                dialog.dispose();
                Load();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        dialog.add(panelSpecia);
        dialog.setVisible(true);


    }//GEN-LAST:event_specieMenuActionPerformed
/*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regjistroKafshGUI().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pastro;
    private javax.swing.JLabel emriLabel;
    private javax.swing.JTextField emriTxt;
    private javax.swing.JLabel foto;
    private javax.swing.JMenuItem galeriMenu;
    private javax.swing.JLabel gjendjaLabel;
    private javax.swing.JTextArea gjendjaShText;
    private javax.swing.JLabel gjiniaLabel;
    private javax.swing.JComboBox<String> gjiniaS;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> k_status;
    private javax.swing.JLabel komentLabel;
    private javax.swing.JTextArea komenteTxt;
    private javax.swing.JLabel labelH1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuKthehu;
    private javax.swing.JButton regjistroButon;
    private javax.swing.JMenuItem rekordetKthim;
    private javax.swing.JLabel speciaLabel;
    private javax.swing.JComboBox<String> speciaText;
    private javax.swing.JMenuItem specieMenu;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel vfLabel;
    private javax.swing.JTextField vfTxt;
    // End of variables declaration//GEN-END:variables

    public static String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

}
