package furlove;

import java.awt.*;
import java.io.File;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;

public class rekordetKafshet extends javax.swing.JFrame {

    public rekordetKafshet() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Connect();
        LoadTableAndNo();
        GUIHelper.styleComponents(this.getContentPane());

    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furlove", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadTableAndNo() {

        k_status.removeAllItems();
        k_status.addItem("--");
        String[] statuset = {"Shëndetshëm", "I sëmurë", "Në trajtim", "Në rikuperim"};

        for (String s : statuset) {
            k_status.addItem(s);
        }

        try {
            pst = con.prepareStatement("SELECT specia FROM specia");
            rs = pst.executeQuery();
            speciaTxt.removeAllItems();
            speciaTxt.addItem("--");

            while (rs.next()) {
                speciaTxt.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst = con.prepareStatement("SELECT kafsha_ID FROM kafshet");
            rs = pst.executeQuery();
            k_ID.removeAllItems();
            k_ID.addItem("--");
            while (rs.next()) {
                k_ID.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        kerkimDytesor.removeAllItems();

        PastroTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        komentLabel = new javax.swing.JLabel();
        labelH1 = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kafshetTable = new javax.swing.JTable();
        emriTxt = new javax.swing.JTextField();
        ngarkoButon = new javax.swing.JButton();
        emriLabel = new javax.swing.JLabel();
        vfTxt = new javax.swing.JTextField();
        speciaLabel = new javax.swing.JLabel();
        k_ID = new javax.swing.JComboBox<>();
        gjiniaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        komenteTxt = new javax.swing.JTextArea();
        vfLabel = new javax.swing.JLabel();
        perditesoButon = new javax.swing.JButton();
        fshiButon = new javax.swing.JButton();
        IDLabel1 = new javax.swing.JLabel();
        kategoria = new javax.swing.JComboBox<>();
        kerkoTblBtn = new javax.swing.JButton();
        kerkimDytesor = new javax.swing.JComboBox<>();
        gjiniaS = new javax.swing.JComboBox<>();
        img = new javax.swing.JLabel();
        fotoBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        gjendjaShText = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        k_status = new javax.swing.JComboBox<>();
        gjendjaLabel = new javax.swing.JLabel();
        pastroButon = new javax.swing.JButton();
        speciaTxt = new javax.swing.JComboBox<>();
        pastroTblBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        galeriMenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        shtoKafshe = new javax.swing.JMenuItem();
        specieMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        komentLabel.setText("Komente");
        getContentPane().add(komentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 60, -1));

        labelH1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        labelH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelH1.setText("Rekordet e kafsheve");
        getContentPane().add(labelH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 430, 87));

        IDLabel.setFont(new java.awt.Font("Malgun Gothic", 0, 15)); // NOI18N
        IDLabel.setText("ID e kafshes:");
        getContentPane().add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, 130, 40));

        kafshetTable.setAutoCreateRowSorter(true);
        kafshetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Emri", "Specia", "Gjinia", "Statusi shendetsor", "Vendodhja e fundit", "Komente"
            }
        ));
        kafshetTable.setShowGrid(false);
        jScrollPane1.setViewportView(kafshetTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, 1380, 162));

        emriTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emriTxtActionPerformed(evt);
            }
        });
        getContentPane().add(emriTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 90, -1));

        ngarkoButon.setText("Ngarko");
        ngarkoButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ngarkoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngarkoButonActionPerformed(evt);
            }
        });
        getContentPane().add(ngarkoButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 230, 80, 30));

        emriLabel.setText("Emri");
        getContentPane().add(emriLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        vfTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vfTxtActionPerformed(evt);
            }
        });
        getContentPane().add(vfTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 230, -1));

        speciaLabel.setText("Specia");
        getContentPane().add(speciaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));

        k_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        k_ID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        k_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k_IDActionPerformed(evt);
            }
        });
        getContentPane().add(k_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 180, 110, -1));

        gjiniaLabel.setText("Gjinia");
        getContentPane().add(gjiniaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, -1, -1));

        komenteTxt.setColumns(20);
        komenteTxt.setRows(5);
        komenteTxt.setMaximumSize(new java.awt.Dimension(100, 65));
        komenteTxt.setMinimumSize(new java.awt.Dimension(10, 15));
        komenteTxt.setPreferredSize(new java.awt.Dimension(100, 60));
        jScrollPane2.setViewportView(komenteTxt);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 230, 70));

        vfLabel.setText("Vendodhja");
        getContentPane().add(vfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 60, 30));

        perditesoButon.setText("Perditeso");
        perditesoButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        perditesoButon.setMaximumSize(new java.awt.Dimension(100, 23));
        perditesoButon.setMinimumSize(new java.awt.Dimension(100, 23));
        perditesoButon.setPreferredSize(new java.awt.Dimension(100, 23));
        perditesoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perditesoButonActionPerformed(evt);
            }
        });
        getContentPane().add(perditesoButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 290, 130, 30));

        fshiButon.setText("Fshi");
        fshiButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fshiButon.setMaximumSize(new java.awt.Dimension(100, 23));
        fshiButon.setPreferredSize(new java.awt.Dimension(100, 23));
        fshiButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshiButonActionPerformed(evt);
            }
        });
        getContentPane().add(fshiButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 340, 130, 30));

        IDLabel1.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        IDLabel1.setText("Kategoria e kerkimit:");
        getContentPane().add(IDLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 180, -1));

        kategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Zgjidh--", "emri", "specia", "gjinia", "statusiShendetesor", "vendndodhjaFundit" }));
        kategoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kategoriaItemStateChanged(evt);
            }
        });
        kategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(kategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 140, -1));

        kerkoTblBtn.setText("Kerko");
        kerkoTblBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kerkoTblBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kerkoTblBtnActionPerformed(evt);
            }
        });
        getContentPane().add(kerkoTblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 85, 36));

        kerkimDytesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kerkimDytesor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kerkimDytesor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kerkimDytesorItemStateChanged(evt);
            }
        });
        getContentPane().add(kerkimDytesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 140, -1));

        gjiniaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        getContentPane().add(gjiniaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 90, -1));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/furLoveTransparent.png"))); // NOI18N
        getContentPane().add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 520, 380));

        fotoBtn.setText("Shto foto");
        fotoBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fotoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(fotoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 390, 130, 30));

        gjendjaShText.setColumns(20);
        gjendjaShText.setRows(5);
        gjendjaShText.setMaximumSize(new java.awt.Dimension(100, 65));
        gjendjaShText.setPreferredSize(new java.awt.Dimension(100, 50));
        jScrollPane3.setViewportView(gjendjaShText);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 230, 80));

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusLabel.setText("Statusi shendetesor");
        getContentPane().add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        k_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(k_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, -1, -1));

        gjendjaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gjendjaLabel.setText("Gjendja shendetsore");
        getContentPane().add(gjendjaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, -1, -1));

        pastroButon.setText("Pastro");
        pastroButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pastroButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroButonActionPerformed(evt);
            }
        });
        getContentPane().add(pastroButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 230, 80, 30));

        speciaTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(speciaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 90, -1));

        pastroTblBtn.setText("Pastro");
        pastroTblBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pastroTblBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroTblBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pastroTblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 85, 36));

        menu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        menu1.setText("Ktheu");
        menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ActionPerformed(evt);
            }
        });

        menuKthehu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        menuKthehu.setText("Menu kryesore");
        menuKthehu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKthehuActionPerformed(evt);
            }
        });
        menu1.add(menuKthehu);

        galeriMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/galeri.png"))); // NOI18N
        galeriMenu.setText("Galeria");
        galeriMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galeriMenuActionPerformed(evt);
            }
        });
        menu1.add(galeriMenu);

        menuBar.add(menu1);

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        jMenu1.setText("Regjistro/Shto");

        shtoKafshe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paw.png"))); // NOI18N
        shtoKafshe.setText("kafshe");
        shtoKafshe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoKafsheActionPerformed(evt);
            }
        });
        jMenu1.add(shtoKafshe);

        specieMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paws.png"))); // NOI18N
        specieMenu.setText("specie");
        specieMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specieMenuActionPerformed(evt);
            }
        });
        jMenu1.add(specieMenu);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emriTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emriTxtActionPerformed
    }//GEN-LAST:event_emriTxtActionPerformed

    private void ngarkoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngarkoButonActionPerformed

        try {
            String kid = k_ID.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM kafshet WHERE kafsha_ID = ?");
            pst.setString(1, kid);
            rs = pst.executeQuery();

            if (rs.next() == true) {
                emriTxt.setText(rs.getString(2));
                speciaTxt.setSelectedItem((rs.getString(3)));
                gjiniaS.setSelectedItem(rs.getString(4));
                vfTxt.setText(rs.getString(7));
                komenteTxt.setText(rs.getString(9));
                k_status.setSelectedItem(rs.getString(6));
                gjendjaShText.setText(rs.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ngarkoButonActionPerformed

    private void vfTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vfTxtActionPerformed
    }//GEN-LAST:event_vfTxtActionPerformed

    private void menuKthehuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKthehuActionPerformed
        new MenuGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuKthehuActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
                dispose();
            }
        });

    }//GEN-LAST:event_menu1ActionPerformed

    private void kerkoTblBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kerkoTblBtnActionPerformed

        String[] columnNames = {"ID", "Emri", "Specia", "Gjinia", "Statusi Shendetesore", "Vendndodhja e Fundit", "Komente"};

        DefaultTableModel model = (DefaultTableModel) kafshetTable.getModel();

        try {
            Object selectedKategori = kategoria.getSelectedItem();
            Object selectedKeyword = kerkimDytesor.getSelectedItem();

            if (selectedKategori == null || selectedKeyword == null) {
                return;
            } else {
                model.setRowCount(0);
            }

            String kategori = selectedKategori.toString();
            String keyword = selectedKeyword.toString();

            if (kategori.equalsIgnoreCase("zgjidh") || keyword.equalsIgnoreCase("zgjidh")) {
                return;
            }

            pst = con.prepareStatement("SELECT * FROM kafshet WHERE " + kategori + " = ?");
            pst.setString(1, keyword);
            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("kafsha_id"),
                    rs.getString("emri"),
                    rs.getString("specia"),
                    rs.getString("gjinia"),
                    rs.getString("statusiShendetesor"),
                    rs.getString("vendndodhjaFundit"),
                    rs.getString("komente")
                });
            }

            kafshetTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            for (int column = 0; column < kafshetTable.getColumnCount(); column++) {
                TableColumn tableColumn = kafshetTable.getColumnModel().getColumn(column);
                int preferredWidth = 250;
                for (int row = 0; row < kafshetTable.getRowCount(); row++) {
                    Component c = kafshetTable.prepareRenderer(kafshetTable.getCellRenderer(row, column), row, column);
                    preferredWidth = Math.max(preferredWidth, c.getPreferredSize().width + 10);
                }
                tableColumn.setPreferredWidth(preferredWidth);
            }

        } catch (NullPointerException e) {
            System.err.println("Null pointer caught.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_kerkoTblBtnActionPerformed

    private void fshiButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshiButonActionPerformed

        int kafshaId = k_ID.getSelectedIndex();
//        Connection con = connect.ConnectProvider.getCon();
        String[] queries = {
            "DELETE FROM ndjekjamjekesore WHERE kafsha_ID = ?",
            "DELETE FROM kerkesatadoptim WHERE kafsha_ID = ?",
            "DELETE FROM kafshet WHERE kafsha_ID = ?"
        };

        for (String query : queries) {
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, kafshaId);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "U fshi me sukses!");
                LoadTableAndNo();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_fshiButonActionPerformed

    private void k_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_k_IDActionPerformed
    }//GEN-LAST:event_k_IDActionPerformed

    private void perditesoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perditesoButonActionPerformed
        String kemri = emriTxt.getText();
        String kspecia = speciaTxt.getSelectedItem().toString();
        String kgjinia = gjiniaS.getSelectedItem().toString();
        String kvf = vfTxt.getText();
        String kkomente = komenteTxt.getText();
        String kid = k_ID.getSelectedItem().toString();

        try {
            pst = con.prepareStatement("UPDATE kafshet SET emri = ?, specia=?, gjinia=?, vendndodhjaFundit=?, komente=? WHERE kafsha_ID = ?");
            pst.setString(1, kemri);
            pst.setString(2, kspecia);
            pst.setString(3, kgjinia);
            pst.setString(4, kvf);
            pst.setString(5, kkomente);
            pst.setString(6, kid);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Perditesuar me sukses!");
                pastro();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_perditesoButonActionPerformed

    private void kategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriaActionPerformed
    }//GEN-LAST:event_kategoriaActionPerformed

    private void kategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kategoriaItemStateChanged

        kerkimDytesor.removeAllItems();

        String kategori = kategoria.getSelectedItem().toString();
        if(kategori!=null || "Zgjidh".equals(kategori)){
 
        try {
            pst = con.prepareStatement("SELECT DISTINCT " + kategori + " FROM kafshet");
            rs = pst.executeQuery();
            while (rs.next()) {
                kerkimDytesor.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }else{
            PastroTable();
        }

    }//GEN-LAST:event_kategoriaItemStateChanged

    private void kerkimDytesorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kerkimDytesorItemStateChanged

    }//GEN-LAST:event_kerkimDytesorItemStateChanged

    private void fotoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotoBtnActionPerformed

        if (k_ID.getSelectedItem() == null || k_ID.getSelectedItem().toString().equals("--")) {
            JOptionPane.showMessageDialog(this, "Te lutem zgjidh ID-n e kafshes nga lista para se te shtosh foto!", "Verejtje", JOptionPane.WARNING_MESSAGE);
        } else {

            JFileChooser filechooser = new JFileChooser();
            filechooser.setDialogTitle("Zgjidh fotot");
            filechooser.setMultiSelectionEnabled(true);
            filechooser.setFileFilter(new FileNameExtensionFilter("Imazhe (JPG, JPEG, PNG)", "jpg", "jpeg", "png"));
            int result = filechooser.showOpenDialog(this);
            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File[] files = filechooser.getSelectedFiles();
            if (files == null || files.length == 0) {
                return;
            }

            File destDir = new File("src" + File.separator + "furlove" + File.separator + "foto");
            if (!destDir.exists() && !destDir.mkdirs()) {
                JOptionPane.showMessageDialog(this, "Nuk mund te krijohet dosja e fotove.", "Gabim", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int copied = 0;
            String selectedAnimalId = k_ID.getSelectedItem().toString();

            for (File f : files) {
                if (f == null || !f.isFile()) {
                    continue;
                }
                String originalName = f.getName();
                String baseName = "";
                String ext = "";
                int dot = originalName.lastIndexOf('.');
                if (dot >= 0) {
                    baseName = originalName.substring(0, dot);
                    ext = originalName.substring(dot);
                } else {
                    baseName = originalName;
                }
                String uniqueName = System.currentTimeMillis() + "_" + Math.abs(f.hashCode()) + ext;
                Path destPath = destDir.toPath().resolve(uniqueName);
                try {
                    Files.copy(f.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
                    String relativePath = "src\\furlove\\foto\\" + uniqueName;

                    String insertFotoSql = "INSERT INTO fotot_kafsheve (kafsha_ID, foto_path) VALUES (?, ?)";

                    try (PreparedStatement insertPs = con.prepareStatement(insertFotoSql)) {
                        insertPs.setInt(1, Integer.parseInt(selectedAnimalId));
                        insertPs.setString(2, relativePath);
                        int insertResult = insertPs.executeUpdate();
                        if (insertResult > 0) {
                            System.out.println("Foto u shtua ne fotot_kafsheve per kafshen me ID: " + selectedAnimalId);
                        } else {
                            System.err.println("Nuk u shtua foto ne fotot_kafsheve per kafshen ID: " + selectedAnimalId);
                        }
                    } catch (SQLException ex) {
                        System.err.println("Gabim gjate shtimit te fotos ne databaze: " + ex.getMessage());
                        ex.printStackTrace();
                    }

                    copied++;
                } catch (IOException ex) {
                    Logger.getLogger(rekordetKafshet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (copied > 0) {
                JOptionPane.showMessageDialog(this, copied + " foto u shtuan dhe u ruajten ne databaze per kafshin ID: " + selectedAnimalId);
                LoadTableAndNo();
            } else {
                JOptionPane.showMessageDialog(this, "Nuk u shtua asnje foto.", "Verejtje", JOptionPane.WARNING_MESSAGE);

            }

        }
    }//GEN-LAST:event_fotoBtnActionPerformed

    private void shtoKafsheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoKafsheActionPerformed
        new regjistroKafshGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_shtoKafsheActionPerformed

    private void pastroButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroButonActionPerformed
        pastro();
    }//GEN-LAST:event_pastroButonActionPerformed

    private void galeriMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galeriMenuActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new galeriaGUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_galeriMenuActionPerformed

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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        dialog.add(panelSpecia);
        dialog.setVisible(true);


    }//GEN-LAST:event_specieMenuActionPerformed

    private void pastroTblBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroTblBtnActionPerformed
        PastroTable();
    }//GEN-LAST:event_pastroTblBtnActionPerformed
/*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetKafshet().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel IDLabel1;
    private javax.swing.JLabel emriLabel;
    private javax.swing.JTextField emriTxt;
    private javax.swing.JButton fotoBtn;
    private javax.swing.JButton fshiButon;
    private javax.swing.JMenuItem galeriMenu;
    private javax.swing.JLabel gjendjaLabel;
    private javax.swing.JTextArea gjendjaShText;
    private javax.swing.JLabel gjiniaLabel;
    private javax.swing.JComboBox<String> gjiniaS;
    private javax.swing.JLabel img;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> k_ID;
    private javax.swing.JComboBox<String> k_status;
    private javax.swing.JTable kafshetTable;
    private javax.swing.JComboBox<String> kategoria;
    private javax.swing.JComboBox<String> kerkimDytesor;
    private javax.swing.JButton kerkoTblBtn;
    private javax.swing.JLabel komentLabel;
    private javax.swing.JTextArea komenteTxt;
    private javax.swing.JLabel labelH1;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuKthehu;
    private javax.swing.JButton ngarkoButon;
    private javax.swing.JButton pastroButon;
    private javax.swing.JButton pastroTblBtn;
    private javax.swing.JButton perditesoButon;
    private javax.swing.JMenuItem shtoKafshe;
    private javax.swing.JLabel speciaLabel;
    private javax.swing.JComboBox<String> speciaTxt;
    private javax.swing.JMenuItem specieMenu;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel vfLabel;
    private javax.swing.JTextField vfTxt;
    // End of variables declaration//GEN-END:variables

    private void pastro() {
        k_ID.setSelectedIndex(0);
        emriTxt.setText("");
        speciaTxt.setSelectedIndex(0);
        gjiniaS.setSelectedItem("");
        vfTxt.setText("");
        komenteTxt.setText("");
        k_status.setSelectedIndex(0);
        gjendjaShText.setText("");
    }

    private void PastroTable() {

        DefaultTableModel model = (DefaultTableModel) kafshetTable.getModel();
        model.setRowCount(0);

        try {

            pst = con.prepareStatement("SELECT kafsha_ID, emri, specia, gjinia, statusiShendetesor, vendndodhjaFundit, komente FROM kafshet");

            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("kafsha_id"),
                    rs.getString("emri"),
                    rs.getString("specia"),
                    rs.getString("gjinia"),
                    rs.getString("statusiShendetesor"),
                    rs.getString("vendndodhjaFundit"),
                    rs.getString("komente"),});
            }

            kafshetTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            for (int column = 0; column < kafshetTable.getColumnCount(); column++) {
                TableColumn tableColumn = kafshetTable.getColumnModel().getColumn(column);
                int preferredWidth = 250;
                for (int row = 0; row < kafshetTable.getRowCount(); row++) {
                    Component c = kafshetTable.prepareRenderer(kafshetTable.getCellRenderer(row, column), row, column);
                    preferredWidth = Math.max(preferredWidth, c.getPreferredSize().width + 10);
                }
                tableColumn.setPreferredWidth(preferredWidth);
            }

        } catch (java.sql.SQLSyntaxErrorException e) {
            model.setRowCount(0);
        } catch (NullPointerException e) {
            System.err.println("Null pointer caught.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        kategoria.setSelectedIndex(0);

        
        

    }


}
