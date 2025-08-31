package furlove;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class rekordetMjeksore extends javax.swing.JFrame {

    public rekordetMjeksore() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Connect();
        Load();
        GUIHelper.styleComponents(this.getContentPane());

    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furlove", "root", "");

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void Load() {

        try {
            pst = con.prepareStatement("SELECT kafsha_ID FROM kafshet");
            rs = pst.executeQuery();
            k_ID.removeAllItems();
            k_ID.addItem("  -  ");
            while (rs.next()) {
                k_ID.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst = con.prepareStatement("SELECT emri FROM veterineret");
            rs = pst.executeQuery();
            mjekuText.removeAllItems();
            mjekuText.addItem("--");
            while (rs.next()) {
                mjekuText.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst = con.prepareStatement("SELECT nm_id FROM ndjekjamjekesore");
            rs = pst.executeQuery();
            IDList.removeAllItems();

            IDList.addItem("--");
            while (rs.next()) {
                IDList.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] columnNames = {"ID", "kafsha_ID", "Lloji i Procedures", "Mjeku", "Data", "Rezultati", "Komente"};
        DefaultTableModel model = (DefaultTableModel) rekordeTabel.getModel();
        model.setRowCount(0);

        try {

            pst = con.prepareStatement("SELECT * FROM ndjekjamjekesore");
            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nm_ID"),
                    rs.getString("kafsha_ID"),
                    rs.getString("llojiProcedures"),
                    rs.getString("mjeku"),
                    rs.getString("data"),
                    rs.getString("rezultati"),
                    rs.getString("komente")
                });
            }

            rekordeTabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            for (int column = 0; column < rekordeTabel.getColumnCount(); column++) {
                TableColumn tableColumn = rekordeTabel.getColumnModel().getColumn(column);
                int preferredWidth = 250;
                for (int row = 0; row < rekordeTabel.getRowCount(); row++) {
                    Component c = rekordeTabel.prepareRenderer(rekordeTabel.getCellRenderer(row, column), row, column);
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

        pastro();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelH1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rekordeTabel = new javax.swing.JTable();
        labTab = new javax.swing.JLabel();
        ngarkoButon = new javax.swing.JButton();
        IDlabel = new javax.swing.JLabel();
        procedurLabel = new javax.swing.JLabel();
        mjekuLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        rezultatLabel = new javax.swing.JLabel();
        komentLabel = new javax.swing.JLabel();
        nmID = new javax.swing.JLabel();
        procedurText = new javax.swing.JTextField();
        rezultatText = new javax.swing.JTextField();
        IDList = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        komenteText = new javax.swing.JTextArea();
        perditesoButon = new javax.swing.JButton();
        fshiButon = new javax.swing.JButton();
        shtoButon = new javax.swing.JButton();
        dataText = new com.toedter.calendar.JDateChooser();
        pastroButon = new javax.swing.JButton();
        k_ID = new javax.swing.JComboBox<>();
        mjekuText = new javax.swing.JComboBox<>();
        foto = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        shtoMjeketButon = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelH1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelH1.setText("Rekordet mjekesore");

        rekordeTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "kafsha_ID", "Lloji i Procedures", "Mjeku", "Data", "Rezultate", "Komente"
            }
        ));
        jScrollPane1.setViewportView(rekordeTabel);

        labTab.setText("Tabela e plote");

        ngarkoButon.setText("Ngarko");
        ngarkoButon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ngarkoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngarkoButonActionPerformed(evt);
            }
        });

        IDlabel.setText("ID e kafshes: ");

        procedurLabel.setText("Lloji i procedures:");

        mjekuLabel.setText("Mjeku vet. ");

        dataLabel.setText("Data");

        rezultatLabel.setText("Rezultati");

        komentLabel.setText("Komente");

        nmID.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        nmID.setText("ID e nderhyrjes mjeksore:");

        procedurText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procedurTextActionPerformed(evt);
            }
        });

        rezultatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rezultatTextActionPerformed(evt);
            }
        });

        IDList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        komenteText.setColumns(20);
        komenteText.setRows(5);
        jScrollPane2.setViewportView(komenteText);

        perditesoButon.setText("Perditeso");
        perditesoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perditesoButonActionPerformed(evt);
            }
        });

        fshiButon.setText("Fshi");
        fshiButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshiButonActionPerformed(evt);
            }
        });

        shtoButon.setText("Shto");
        shtoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoButonActionPerformed(evt);
            }
        });

        dataText.setDateFormatString("dd-MM-yyyy");

        pastroButon.setText("Pastro");
        pastroButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroButonActionPerformed(evt);
            }
        });

        k_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mjekuText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        menu.setText("Ktheu ");
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

        menuBar.add(menu);

        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        jMenu1.setText("Regjistro/Shto");

        shtoMjeketButon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vet.png"))); // NOI18N
        shtoMjeketButon.setText("Mjeket");
        shtoMjeketButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoMjeketButonActionPerformed(evt);
            }
        });
        jMenu1.add(shtoMjeketButon);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelH1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(375, 375, 375))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(procedurLabel)
                                    .addComponent(mjekuLabel)
                                    .addComponent(IDlabel))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(procedurText)
                                    .addComponent(k_ID, 0, 140, Short.MAX_VALUE)
                                    .addComponent(mjekuText, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(komentLabel)
                                    .addComponent(rezultatLabel)
                                    .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(shtoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(perditesoButon)
                                .addGap(28, 28, 28)
                                .addComponent(fshiButon)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rezultatText, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ngarkoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IDList, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pastroButon)))
                            .addComponent(nmID))
                        .addGap(99, 99, 99))))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labTab)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(labelH1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IDlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(procedurLabel)
                                .addGap(18, 18, 18)
                                .addComponent(mjekuLabel)
                                .addGap(70, 70, 70))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nmID)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(IDList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ngarkoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(pastroButon))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dataText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(dataLabel)
                                            .addComponent(k_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(procedurText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(mjekuText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rezultatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(rezultatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(komentLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(fshiButon)
                                                        .addComponent(perditesoButon)
                                                        .addComponent(shtoButon)))
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(labTab, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

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
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 160, 910, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procedurTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procedurTextActionPerformed
    }//GEN-LAST:event_procedurTextActionPerformed

    private void rezultatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezultatTextActionPerformed
    }//GEN-LAST:event_rezultatTextActionPerformed

    private void ngarkoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngarkoButonActionPerformed

        try {

            String id = IDList.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM ndjekjamjekesore WHERE nm_id = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();

            if (rs.next() == true) {

                k_ID.setSelectedItem((rs.getString(2)));
                procedurText.setText(rs.getString(3));
                mjekuText.setSelectedItem((rs.getString(4)));
                dataText.setDate(rs.getDate(5));
                rezultatText.setText(rs.getString(6));
                komenteText.setText(rs.getString(7));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_ngarkoButonActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
                dispose();
            }
        });

    }//GEN-LAST:event_menuActionPerformed

    private void menuKthehuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKthehuActionPerformed

        new MenuGUI().setVisible(true);
        dispose();

    }//GEN-LAST:event_menuKthehuActionPerformed

    private void fshiButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshiButonActionPerformed

        try {

            String id = IDList.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM ndjekjamjekesore WHERE nm_id = ?");
            pst.setString(1, id);

            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted > 0) {
                Load();
                JOptionPane.showMessageDialog(this, "Rekordi u fshi me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Asnje rekord nuk u gjet me kete ID.", "Nuk u gjet!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_fshiButonActionPerformed

    private void perditesoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perditesoButonActionPerformed

        try {

            String kafshID = k_ID.getSelectedItem().toString();
            String procedur = procedurText.getText();
            String mjeku = mjekuText.getSelectedItem().toString();
            java.util.Date data = dataText.getDate();
            String rezultat = rezultatText.getText();
            String komente = komenteText.getText();

            String id = IDList.getSelectedItem().toString();

            pst = con.prepareStatement("UPDATE ndjekjamjekesore SET kafsha_ID=?,llojiProcedures=?,mjeku=?,data=?,"
                    + "rezultati=?,komente=? WHERE nm_ID=?");

            pst.setString(1, kafshID);
            pst.setString(2, procedur);
            pst.setString(3, mjeku);
            pst.setDate(4, new java.sql.Date(data.getTime()));
            pst.setString(5, rezultat);
            pst.setString(6, komente);
            pst.setString(7, id);

            int k = pst.executeUpdate();
            if (k == 1) {
                Load();
                JOptionPane.showMessageDialog(this, "Perditesuar me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                k_ID.setSelectedIndex(0);
                procedurText.setText("");
                mjekuText.setSelectedItem("--");
                komenteText.setText("");
                rezultatText.setText("");
                dataText.setDate(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_perditesoButonActionPerformed

    private void shtoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoButonActionPerformed

        if (IDList.getSelectedItem() == "--") {

            try {

                String kafshID = k_ID.getSelectedItem().toString();
                int kid = Integer.parseInt(kafshID);
                String procedur = procedurText.getText();
                String mjeku = mjekuText.getSelectedItem().toString();
                Date data = dataText.getDate();
                String rezultat = rezultatText.getText();
                String komente = komenteText.getText();

                if (valido(kafshID) && valido(mjeku) && valido(procedur) && valido(rezultat) && valido(komente)
                        && valido(data)) {

                    String id = IDList.getSelectedItem().toString();

                    pst = con.prepareStatement(
                            "INSERT INTO ndjekjamjekesore (kafsha_ID, llojiProcedures, mjeku, data, rezultati, komente) VALUES (?,?,?,?,?,?)"
                    );
                    pst.setInt(1, kid);
                    pst.setString(2, procedur);
                    pst.setString(3, mjeku);
                    pst.setDate(4, new java.sql.Date(data.getTime()));
                    pst.setString(5, rezultat);
                    pst.setString(6, komente);

                    int k = pst.executeUpdate();

                    if (k == 1) {
                        Load();
                        JOptionPane.showMessageDialog(this, "Shtuar me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        pastro();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Ploteso formularin!", "Formulari!", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Sigurohu qe ID e ndjekjes mjekesore te jete ne '--'", "!", JOptionPane.WARNING_MESSAGE);
            pastro();

        }

    }//GEN-LAST:event_shtoButonActionPerformed

    private void pastroButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroButonActionPerformed
        pastro();
    }//GEN-LAST:event_pastroButonActionPerformed

    private void shtoMjeketButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoMjeketButonActionPerformed

        JDialog dialogJ = new JDialog((Frame) null, "Shto veterinerin", true);
        dialogJ.setSize(400, 300);

        JPanel dialog = new JPanel(new GridLayout(5, 2, 15, 15));

        JTextField emriField = new JTextField("Dr. ");
        JTextField specializimField = new JTextField();
        JTextField numerTelField = new JTextField();

        JButton ruajButon = new JButton("Ruaj");
        ruajButon.setBackground(Color.WHITE);
        ruajButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JButton anulloButon = new JButton("Anullo");
        anulloButon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anulloButon.setBackground(Color.WHITE);

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
                Load();
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
                new rekordetMjeksore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> IDList;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JLabel dataLabel;
    private com.toedter.calendar.JDateChooser dataText;
    private javax.swing.JLabel foto;
    private javax.swing.JButton fshiButon;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> k_ID;
    private javax.swing.JLabel komentLabel;
    private javax.swing.JTextArea komenteText;
    private javax.swing.JLabel labTab;
    private javax.swing.JLabel labelH1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuKthehu;
    private javax.swing.JLabel mjekuLabel;
    private javax.swing.JComboBox<String> mjekuText;
    private javax.swing.JButton ngarkoButon;
    private javax.swing.JLabel nmID;
    private javax.swing.JButton pastroButon;
    private javax.swing.JButton perditesoButon;
    private javax.swing.JLabel procedurLabel;
    private javax.swing.JTextField procedurText;
    private javax.swing.JTable rekordeTabel;
    private javax.swing.JLabel rezultatLabel;
    private javax.swing.JTextField rezultatText;
    private javax.swing.JButton shtoButon;
    private javax.swing.JMenuItem shtoMjeketButon;
    // End of variables declaration//GEN-END:variables

    private boolean valido(Date data) {
        if (data == null) {
            return false;
        }
        return true;

    }

    public boolean valido(String fusha) {
        String fushTrim = fusha.trim();
        return !fushTrim.isEmpty();
    }

    private void pastro() {

        IDList.setSelectedIndex(0);
        k_ID.setSelectedIndex(0);
        procedurText.setText("");
        mjekuText.setSelectedItem("--");
        komenteText.setText("");
        rezultatText.setText("");
        dataText.setDate(null);

    }

}
