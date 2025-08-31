package furlove;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class rekordetVeterinereve extends javax.swing.JFrame {

    public rekordetVeterinereve() {
        initComponents();
        Connect();
        LoadTableAndNo();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        try {
            pst = con.prepareStatement("SELECT id FROM veterineret");
            rs = pst.executeQuery();
            v_ID.removeAllItems();
            v_ID.addItem("--");
            while (rs.next()) {
                v_ID.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        kerkimDytesor.removeAllItems();

        PastroTable();

    }

    private void PastroTable() {

        DefaultTableModel model = (DefaultTableModel) vetTable.getModel();
        model.setRowCount(0);

        try {

            pst = con.prepareStatement("SELECT * FROM veterineret");

            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("emri"),
                    rs.getString("specializimi"),
                    rs.getString("telefoni"),});
            }

            vetTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            for (int column = 0; column < vetTable.getColumnCount(); column++) {
                TableColumn tableColumn = vetTable.getColumnModel().getColumn(column);
                int preferredWidth = 250;
                for (int row = 0; row < vetTable.getRowCount(); row++) {
                    Component c = vetTable.prepareRenderer(vetTable.getCellRenderer(row, column), row, column);
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelH1 = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        emriVetTxt = new javax.swing.JTextField();
        ngarkoButon = new javax.swing.JButton();
        emriLabel = new javax.swing.JLabel();
        speciaLabel = new javax.swing.JLabel();
        v_ID = new javax.swing.JComboBox<>();
        gjiniaLabel = new javax.swing.JLabel();
        perditesoButon = new javax.swing.JButton();
        pastroButon = new javax.swing.JButton();
        nrTelTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        vetTable = new javax.swing.JTable();
        IDLabel1 = new javax.swing.JLabel();
        kategoria = new javax.swing.JComboBox<>();
        kerkoTblBtn = new javax.swing.JButton();
        kerkimDytesor = new javax.swing.JComboBox<>();
        pastroTblBtn = new javax.swing.JButton();
        specializimTxt = new javax.swing.JTextField();
        foto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        shtoMjeketButon = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelH1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        labelH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelH1.setText("Rekordet e veterinereve");

        IDLabel.setFont(new java.awt.Font("Malgun Gothic", 0, 15)); // NOI18N
        IDLabel.setText("ID:");

        emriVetTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emriVetTxtActionPerformed(evt);
            }
        });

        ngarkoButon.setText("Ngarko");
        ngarkoButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ngarkoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngarkoButonActionPerformed(evt);
            }
        });

        emriLabel.setText("Emri");

        speciaLabel.setText("Specilizimi");

        v_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        v_ID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        v_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_IDActionPerformed(evt);
            }
        });

        gjiniaLabel.setText("Nr. i tel");

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

        pastroButon.setText("Pastro");
        pastroButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pastroButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroButonActionPerformed(evt);
            }
        });

        nrTelTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrTelTxtActionPerformed(evt);
            }
        });

        vetTable.setAutoCreateRowSorter(true);
        vetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Emri", "Specializimi", "Nr. tel"
            }
        ));
        vetTable.setShowGrid(false);
        jScrollPane1.setViewportView(vetTable);

        IDLabel1.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        IDLabel1.setText("Kategoria e kerkimit:");

        kategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Zgjidh--", "emri", "specializimi", "telefoni" }));
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

        kerkoTblBtn.setText("Kerko");
        kerkoTblBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kerkoTblBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kerkoTblBtnActionPerformed(evt);
            }
        });

        kerkimDytesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kerkimDytesor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kerkimDytesor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kerkimDytesorItemStateChanged(evt);
            }
        });

        pastroTblBtn.setText("Pastro");
        pastroTblBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pastroTblBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroTblBtnActionPerformed(evt);
            }
        });

        URL imgUrl = getClass().getResource("/icons/Fur-LoveTransparent-Med.png");

        try{

            if (imgUrl == null) {
                File devPath = new File("src/icons/Fur-LoveTransparent-Med.png");
                if (devPath.exists()) {
                    imgUrl = devPath.toURI().toURL();
                }
            }

            if (imgUrl != null) {
                ImageIcon iconOriginal = new ImageIcon(imgUrl);
                Image iconScaled = iconOriginal.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
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

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jMenu1.setText("Ktheu");

        menuKthehu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        menuKthehu.setText("Menu kryesore");
        menuKthehu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKthehuActionPerformed(evt);
            }
        });
        jMenu1.add(menuKthehu);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        jMenu2.setText("Regjistro/Shto");

        shtoMjeketButon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vet.png"))); // NOI18N
        shtoMjeketButon.setText("Mjeket");
        shtoMjeketButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoMjeketButonActionPerformed(evt);
            }
        });
        jMenu2.add(shtoMjeketButon);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelH1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emriLabel)
                                .addGap(66, 66, 66)
                                .addComponent(emriVetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(speciaLabel)
                                .addGap(32, 32, 32)
                                .addComponent(specializimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gjiniaLabel)
                                .addGap(52, 52, 52)
                                .addComponent(nrTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(v_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(ngarkoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(pastroButon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(perditesoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(IDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kerkimDytesor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(kerkoTblBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pastroTblBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelH1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(v_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ngarkoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pastroButon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(perditesoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emriLabel)
                                    .addComponent(emriVetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(speciaLabel)
                                    .addComponent(specializimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gjiniaLabel)
                                    .addComponent(nrTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(kerkimDytesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kerkoTblBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pastroTblBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 910, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emriVetTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emriVetTxtActionPerformed

    }//GEN-LAST:event_emriVetTxtActionPerformed

    private void ngarkoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngarkoButonActionPerformed

        try {
            String kid = v_ID.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM veterineret WHERE id = ?");
            pst.setString(1, kid);
            rs = pst.executeQuery();

            if (rs.next() == true) {
                emriVetTxt.setText(rs.getString(2));
                specializimTxt.setText((rs.getString(3)));
                nrTelTxt.setText(Integer.toString(rs.getInt(4)));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ngarkoButonActionPerformed

    private void v_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_IDActionPerformed

    }//GEN-LAST:event_v_IDActionPerformed

    private void perditesoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perditesoButonActionPerformed
        String kemri = emriVetTxt.getText();
        String kspecia = specializimTxt.getText();
        String telefoni = nrTelTxt.getText();
        String kid = v_ID.getSelectedItem().toString();

        try {
            pst = con.prepareStatement("UPDATE veterineret SET emri = ?, specializimi=?, telefoni=? WHERE id = ?");
            pst.setString(1, kemri);
            pst.setString(2, kspecia);
            pst.setString(3, telefoni);
            pst.setString(4, kid);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Perditesuar me sukses!");
                pastro();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_perditesoButonActionPerformed

    private void pastroButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroButonActionPerformed
        pastro();
    }//GEN-LAST:event_pastroButonActionPerformed

    private void kategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kategoriaItemStateChanged

        kerkimDytesor.removeAllItems();

        String kategori = kategoria.getSelectedItem().toString();

        try {
            pst = con.prepareStatement("SELECT DISTINCT " + kategori + " FROM veterineret");
            rs = pst.executeQuery();
            while (rs.next()) {
                kerkimDytesor.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_kategoriaItemStateChanged

    private void kategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriaActionPerformed

    }//GEN-LAST:event_kategoriaActionPerformed

    private void kerkoTblBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kerkoTblBtnActionPerformed

        DefaultTableModel model = (DefaultTableModel) vetTable.getModel();

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

            pst = con.prepareStatement("SELECT * FROM veterineret WHERE " + kategori + " = ?");
            pst.setString(1, keyword);
            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("emri"),
                    rs.getString("specializimi"),
                    rs.getString("telefoni"),});
            }

            vetTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            for (int column = 0; column < vetTable.getColumnCount(); column++) {
                TableColumn tableColumn = vetTable.getColumnModel().getColumn(column);
                int preferredWidth = 250;
                for (int row = 0; row < vetTable.getRowCount(); row++) {
                    Component c = vetTable.prepareRenderer(vetTable.getCellRenderer(row, column), row, column);
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

    private void kerkimDytesorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kerkimDytesorItemStateChanged

    }//GEN-LAST:event_kerkimDytesorItemStateChanged

    private void pastroTblBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroTblBtnActionPerformed
        PastroTable();
    }//GEN-LAST:event_pastroTblBtnActionPerformed

    private void nrTelTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrTelTxtActionPerformed
    }//GEN-LAST:event_nrTelTxtActionPerformed

    private void menuKthehuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKthehuActionPerformed

        new MenuGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuKthehuActionPerformed

    private void shtoMjeketButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoMjeketButonActionPerformed

        JDialog dialogJ = new JDialog((Frame) null, "Shto veterinerin", true);
        dialogJ.setSize(400, 300);

        JPanel dialog = new JPanel(new GridLayout(5, 2, 15, 15));

        JTextField emriField = new JTextField("Dr. ");
        JTextField specializimField = new JTextField();
        JTextField numerTelField = new JTextField();

        JButton ruajButon = new JButton("Ruaj");

        JButton anulloButon = new JButton("Anullo");

        GUIHelper.styleComponents(this.getContentPane());

        dialog.add(new JLabel("Emri:"));
        dialog.add(emriField);

        dialog.add(new JLabel("Specializim:"));
        dialog.add(specializimField);

        dialog.add(new JLabel("Nr. Tel:"));
        dialog.add(numerTelField);

        dialog.add(ruajButon);
        dialog.add(anulloButon);

        dialog.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        dialogJ.add(dialog);

        GUIHelper.styleComponents(dialogJ);

        ruajButon.addActionListener(ev -> {
            String name = emriField.getText();
            String speciality = specializimField.getText();
            String phone = numerTelField.getText();

            if (name.isEmpty() || speciality.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(dialogJ, "Te lutem ploteso te gjitha fushat!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO veterineret (emri, specializimi, telefoni) VALUES (?, ?, ?)")) {
                ps.setString(1, name);
                ps.setString(2, speciality);
                ps.setString(3, phone);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(dialogJ, "Shtuar me sukses!");
                dialogJ.dispose();
                LoadTableAndNo();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(dialogJ, "Problem ne ruajtje", "Problem", JOptionPane.ERROR_MESSAGE);
            }
        });

        anulloButon.addActionListener(ev -> dialogJ.dispose());

        dialogJ.setLocationRelativeTo(null);
        dialogJ.setVisible(true);
    }//GEN-LAST:event_shtoMjeketButonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetVeterinereve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel IDLabel1;
    private javax.swing.JLabel emriLabel;
    private javax.swing.JTextField emriVetTxt;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel gjiniaLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategoria;
    private javax.swing.JComboBox<String> kerkimDytesor;
    private javax.swing.JButton kerkoTblBtn;
    private javax.swing.JLabel labelH1;
    private javax.swing.JMenuItem menuKthehu;
    private javax.swing.JButton ngarkoButon;
    private javax.swing.JTextField nrTelTxt;
    private javax.swing.JButton pastroButon;
    private javax.swing.JButton pastroTblBtn;
    private javax.swing.JButton perditesoButon;
    private javax.swing.JMenuItem shtoMjeketButon;
    private javax.swing.JLabel speciaLabel;
    private javax.swing.JTextField specializimTxt;
    private javax.swing.JComboBox<String> v_ID;
    private javax.swing.JTable vetTable;
    // End of variables declaration//GEN-END:variables

    private void pastro() {
        v_ID.setSelectedIndex(0);
        emriVetTxt.setText("");
        specializimTxt.setText("");
        nrTelTxt.setText("");
    }
}
