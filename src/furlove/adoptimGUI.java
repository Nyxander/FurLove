package furlove;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Date;

public class adoptimGUI extends javax.swing.JFrame {

    public adoptimGUI() {
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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Probleme ne lidhje me databazen!");
        }
    }

    public void Load() {

        setupAdoptionUI();

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

        try {
            pst = con.prepareStatement("SELECT adresa FROM strehezaperkohshme");
            rs = pst.executeQuery();
            strehaTxt.removeAllItems();
            strehaTxt.addItem("--");
            while (rs.next()) {
                strehaTxt.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dispoF.removeAllItems();
        dispoF.addItem("--");
        dispoF.addItem("0");
        dispoF.addItem("1");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        k_ID = new javax.swing.JComboBox<>();
        labelH1 = new javax.swing.JLabel();
        kafshaID = new javax.swing.JLabel();
        Disponueshmeria = new javax.swing.JLabel();
        streha = new javax.swing.JLabel();
        perditesoBtn = new javax.swing.JButton();
        fshiBtn = new javax.swing.JButton();
        pastroBtn = new javax.swing.JButton();
        approveBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        shtoAplikimeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        appsTable = new javax.swing.JTable();
        labelTab = new javax.swing.JLabel();
        strehaTxt = new javax.swing.JComboBox<>();
        dispoF = new javax.swing.JComboBox<>();
        Fshi = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        adoptimeRekord = new javax.swing.JMenuItem();
        rekordetKthim = new javax.swing.JMenuItem();
        addMenu = new javax.swing.JMenu();
        strehezaShto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        k_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        k_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        k_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k_IDActionPerformed(evt);
            }
        });
        getContentPane().add(k_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 80, -1));

        labelH1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelH1.setText("Disponueshmeria per adoptim");
        getContentPane().add(labelH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 520, 70));

        kafshaID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kafshaID.setText("Ngarko disponueshmerine e kafshes me ID:");
        getContentPane().add(kafshaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 330, 34));

        Disponueshmeria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Disponueshmeria.setText("I disponueshem");
        getContentPane().add(Disponueshmeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 140, 40));

        streha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        streha.setText("Adresa");
        getContentPane().add(streha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 100, 30));

        perditesoBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        perditesoBtn.setText("Perditeso");
        perditesoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perditesoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(perditesoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, -1, -1));

        fshiBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fshiBtn.setText("Fshi");
        fshiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshiBtnActionPerformed(evt);
            }
        });
        getContentPane().add(fshiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 90, -1));

        pastroBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pastroBtn.setText("Pastro");
        pastroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pastroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        approveBtn.setText("Aprovo");
        approveBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 255, 153)));
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(approveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 610, 160, -1));

        rejectBtn.setText("Refuzo");
        rejectBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 51)));
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rejectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 650, 160, -1));

        shtoAplikimeBtn.setText("Shto aplikim");
        shtoAplikimeBtn.setBorder(new javax.swing.border.MatteBorder(null));
        shtoAplikimeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoAplikimeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(shtoAplikimeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 160, -1));

        appsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Streha", "Kerkuesi", "Data", "Status"
            }
        ));
        appsTable.setRowSorter(new TableRowSorter<>( (DefaultTableModel) appsTable.getModel() ) );
        jScrollPane1.setViewportView(appsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 890, 140));

        labelTab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTab.setText("Tabela e kerkesave per adoptim");
        getContentPane().add(labelTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 270, 30));

        strehaTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        strehaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strehaTxtActionPerformed(evt);
            }
        });
        getContentPane().add(strehaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 400, 40));

        dispoF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "0", "1" }));
        getContentPane().add(dispoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 400, 40));

        Fshi.setText("Fshi");
        Fshi.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 102)));
        Fshi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FshiActionPerformed(evt);
            }
        });
        getContentPane().add(Fshi, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 690, 160, -1));

        URL imgUrl = getClass().getResource("/icons/Fur-LoveTransparent-Adopt.png");

        try{

            if (imgUrl == null) {
                File devPath = new File("src/icons/Fur-LoveTransparent-Adopt.png");
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

        saveBtn.setText("Modifiko");
        saveBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 255)));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 730, 160, -1));

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

        adoptimeRekord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/done-adoption.png"))); // NOI18N
        adoptimeRekord.setText("Adoptime te suksesshme");
        adoptimeRekord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptimeRekordActionPerformed(evt);
            }
        });
        menu1.add(adoptimeRekord);

        rekordetKthim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/records.png"))); // NOI18N
        rekordetKthim.setText("Rekordet e kafsheve");
        rekordetKthim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekordetKthimActionPerformed(evt);
            }
        });
        menu1.add(rekordetKthim);

        jMenuBar.add(menu1);

        addMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        addMenu.setText("Regjistro/Shto");

        strehezaShto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/roof.png"))); // NOI18N
        strehezaShto.setText("streheza te perkoheshme");
        strehezaShto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strehezaShtoActionPerformed(evt);
            }
        });
        addMenu.add(strehezaShto);

        jMenuBar.add(addMenu);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

	private void perditesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perditesoBtnActionPerformed
            updateDisponueshmeria();
	}//GEN-LAST:event_perditesoBtnActionPerformed

	private void fshiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshiBtnActionPerformed
            deleteDisponueshmeria();
	}//GEN-LAST:event_fshiBtnActionPerformed

    private void k_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_k_IDActionPerformed
        loadDisponueshmeriaForSelectedAnimal();
        loadApplications();
    }//GEN-LAST:event_k_IDActionPerformed

    private void pastroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroBtnActionPerformed
        dispoF.setSelectedIndex(0);
        strehaTxt.setSelectedIndex(0);
        k_ID.setSelectedIndex(0);
    }//GEN-LAST:event_pastroBtnActionPerformed

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed

        Integer appId = getSelectedApplicationId();
        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Zgjidh nje rresht!");
            return;
        }
        if (!hasColumn("kerkesatadoptim", "status")) {
            JOptionPane.showMessageDialog(this, "Kolona 'status' nuk ekziston.");
            return;
        }

        try {
            try (PreparedStatement ps = con.prepareStatement("UPDATE kerkesatadoptim SET status='MIRATUAR' WHERE ka_ID=?")) {
                ps.setInt(1, appId);
                ps.executeUpdate();
            }

            Integer animalId = null;
            String kerkuesi = null, telefoni = null, email = null, shenim = null;
            try (PreparedStatement psApp = con.prepareStatement("SELECT kafsha_ID, kerkuesi, telefoni, email, shenim FROM kerkesatadoptim WHERE ka_ID=?")) {
                psApp.setInt(1, appId);
                try (ResultSet r = psApp.executeQuery()) {
                    if (r.next()) {
                        animalId = r.getInt(1);
                        kerkuesi = r.getString(2);
                        telefoni = r.getString(3);
                        email = r.getString(4);
                        shenim = r.getString(5);
                    }
                }
            }

            if (animalId == null || animalId == 0) {
                String sel = (String) k_ID.getSelectedItem();
                if (sel != null && !sel.equals("--")) {
                    animalId = Integer.parseInt(sel);
                }
            }
            if (animalId == null || animalId == 0) {
                JOptionPane.showMessageDialog(this, "Nuk mund te percaktoj kafshen per adoptim.");
                return;
            }

            if (hasColumn("kafshet", "adoption_status")) {
                try (PreparedStatement ps2 = con.prepareStatement("UPDATE kafshet SET adoption_status='I ADOPTUAR' WHERE kafsha_ID = ?")) {
                    ps2.setInt(1, animalId);
                    ps2.executeUpdate();
                }
            }
            try (PreparedStatement psEnd = con.prepareStatement("UPDATE caktimi_i_kafsheve_ne_streha SET end_date = curdate() WHERE kafsha_ID = ? AND end_date IS NULL")) {
                psEnd.setInt(1, animalId);
                psEnd.executeUpdate();
            }

            String emer = kerkuesi, mbiemer = null;
            if (kerkuesi != null) {
                String[] parts = kerkuesi.trim().split("\\s+", 2);
                if (parts.length > 0) {
                    emer = parts[0];
                }
                if (parts.length > 1) {
                    mbiemer = parts[1];
                }
            }
            try (PreparedStatement psIns = con.prepareStatement(
                    "INSERT INTO adoptime (kafsha_ID, aplikim_ID, emer, mbiemer, telefoni, email, tarifa, kontrat, shenime) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                psIns.setInt(1, animalId);
                psIns.setInt(2, appId);
                psIns.setString(3, emer);
                psIns.setString(4, mbiemer);
                psIns.setString(5, telefoni);
                psIns.setString(6, email);
                psIns.setNull(7, java.sql.Types.DECIMAL);
                psIns.setString(8, null);
                psIns.setString(9, shenim);
                psIns.executeUpdate();
            }

            try {
                dispoF.setSelectedItem("0");
            } catch (Exception ignore) {
            }
            loadDisponueshmeriaForSelectedAnimal();
            loadApplications();
            JOptionPane.showMessageDialog(this, "Adoptimi u regjistrua te 'adoptime'.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gabim: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_approveBtnActionPerformed

    private void strehaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strehaTxtActionPerformed
    }//GEN-LAST:event_strehaTxtActionPerformed

    private void shtoAplikimeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoAplikimeBtnActionPerformed
        newAppBtnActionPerformed();
    }//GEN-LAST:event_shtoAplikimeBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        reject();
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void FshiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FshiActionPerformed
        deleteAppBtnActionPerformed();
    }//GEN-LAST:event_FshiActionPerformed

    private void adoptimeRekordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoptimeRekordActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adoptimetGUI().setVisible(true);
                dispose();
            }
        });


    }//GEN-LAST:event_adoptimeRekordActionPerformed

    private void rekordetKthimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekordetKthimActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetKafshet().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_rekordetKthimActionPerformed

    private void handleStatusChange(int firstRow, int lastRow) {
        for (int row = firstRow; row <= lastRow; row++) {
            try {

                Integer appId = (Integer) appsTable.getValueAt(row, 0);
                if (appId == null) {
                    continue;
                }

                String newStatus = (String) appsTable.getValueAt(row, 4);
                if (newStatus == null) {
                    continue;
                }

                String sql = "UPDATE kerkesatadoptim SET status = ? WHERE ka_ID = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, newStatus);
                    ps.setInt(2, appId);
                    ps.executeUpdate();
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gabim gjatë përditësimit të statusit: " + e.getMessage());
            }
        }
    }

    private void strehezaShtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strehezaShtoActionPerformed
        shtoStrehez();
    }//GEN-LAST:event_strehezaShtoActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int selectedRow = appsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni një rresht nga tabela për ta edituar!");
            return;
        }

        Integer appId = getSelectedApplicationId();
        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Nuk mund të identifikohet ID-ja e aplikimit!");
            return;
        }

        ModifikoAdoptimDialog dialog = new ModifikoAdoptimDialog(this, con, appId);
        dialog.setVisible(true);

        if (dialog.isOkPressed()) {
            String applicantName = dialog.getApplicantName();
            String phone = dialog.getPhone();
            String email = dialog.getEmail();
            String note = dialog.getNote();
            String status = dialog.getStatus();
            Integer shelterId = dialog.getShelterId();
            Integer animalId = dialog.getAnimalId();
            Date date = dialog.getDate();
            if (applicantName == null || applicantName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ju lutem vendosni emrin e aplikantit!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (phone == null || phone.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ju lutem vendosni numrin e telefonit!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(this, "Ju lutem vendosni një email të vlefshëm!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (status == null || status.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni nje status!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (shelterId == null || shelterId <= 0) {
                JOptionPane.showMessageDialog(this, "ID e strehes eshte e pavlefshme!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (animalId == null || animalId <= 0) {
                JOptionPane.showMessageDialog(this, "ID e kafshes eshte e pavlefshme!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (date == null) {
                JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni nje date!", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                String sql = "UPDATE kerkesatadoptim SET "
                        + "kerkuesi = ?, "
                        + "telefoni = ?, "
                        + "email = ?, "
                        + "shenim = ?, "
                        + "status = ?, "
                        + "streha_ID = ?, "
                        + "kafsha_ID = ?, "
                        + "dataKerkeses = ? "
                        + "WHERE ka_ID = ?";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, dialog.getApplicantName());
                    ps.setString(2, dialog.getPhone());
                    ps.setString(3, dialog.getEmail());
                    ps.setString(4, dialog.getNote());
                    ps.setString(5, dialog.getStatus());
                    ps.setInt(6, dialog.getShelterId());
                    ps.setInt(7, dialog.getAnimalId());

                    if (date != null) {
                        ps.setDate(8, new java.sql.Date(date.getTime()));
                    } else {
                        ps.setDate(8, null);
                    }

                    ps.setInt(9, appId);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Ndryshimet u ruajtën me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        loadApplications();
                    } else {
                        JOptionPane.showMessageDialog(this, "Nuk u bënë ndryshime në databazë.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gabim gjatë ruajtjes së ndryshimeve: " + e.getMessage(), "Gabim", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adoptimGUI().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Disponueshmeria;
    private javax.swing.JButton Fshi;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem adoptimeRekord;
    private javax.swing.JButton approveBtn;
    private javax.swing.JTable appsTable;
    private javax.swing.JComboBox<String> dispoF;
    private javax.swing.JLabel foto;
    private javax.swing.JButton fshiBtn;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> k_ID;
    private javax.swing.JLabel kafshaID;
    private javax.swing.JLabel labelH1;
    private javax.swing.JLabel labelTab;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem menuKthehu;
    private javax.swing.JButton pastroBtn;
    private javax.swing.JButton perditesoBtn;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JMenuItem rekordetKthim;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton shtoAplikimeBtn;
    private javax.swing.JLabel streha;
    private javax.swing.JComboBox<String> strehaTxt;
    private javax.swing.JMenuItem strehezaShto;
    // End of variables declaration//GEN-END:variables

    private void setupAdoptionUI() {
        boolean hasAdoptStatus = hasColumn("kafshet", "adoption_status");
        boolean hasAppStatus = hasColumn("kerkesatadoptim", "status");
        approveBtn.setEnabled(hasAdoptStatus && hasAppStatus);
        rejectBtn.setEnabled(hasAppStatus);
        loadApplications();
    }

    private boolean hasColumn(String tableName, String columnName) {
        try {
            DatabaseMetaData meta = con.getMetaData();
            try (ResultSet cols = meta.getColumns(null, null, tableName, columnName)) {
                return cols.next();
            }
        } catch (SQLException e) {
            return false;
        }
    }

    private void loadApplications() {
        DefaultTableModel model = (DefaultTableModel) appsTable.getModel();
        model.setRowCount(0);
        String selected = (String) k_ID.getSelectedItem();
        boolean hasAppStatus = hasColumn("kerkesatadoptim", "status");

        String sql;
        if (selected == null || selected.equals("--") || !selected.matches("\\d+")) {
            sql = "SELECT k.ka_ID, k.kerkuesi, k.dataKerkeses, s.emer"
                    + (hasAppStatus ? ", k.status" : "")
                    + " FROM kerkesatadoptim k LEFT JOIN strehezaperkohshme s ON k.streha_ID = s.streha_ID "
                    + "ORDER BY k.dataKerkeses DESC, k.ka_ID DESC";

            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet r = ps.executeQuery()) {
                while (r.next()) {
                    Object status = hasAppStatus ? r.getString("status") : "-";
                    model.addRow(new Object[]{
                        r.getInt("ka_ID"),
                        r.getString("emer"),
                        r.getString("kerkuesi"),
                        r.getDate("dataKerkeses"),
                        status
                    });
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gabim gjatë ngarkimit të aplikimeve: " + e.getMessage());
            }

        } else {
            sql = "SELECT k.ka_ID, k.kerkuesi, k.dataKerkeses, s.emer"
                    + (hasAppStatus ? ", k.status" : "")
                    + " FROM kerkesatadoptim k LEFT JOIN strehezaperkohshme s ON k.streha_ID = s.streha_ID "
                    + "WHERE k.kafsha_ID = ? "
                    + "ORDER BY k.dataKerkeses DESC, k.ka_ID DESC";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(selected)); 
                try (ResultSet r = ps.executeQuery()) {
                    while (r.next()) {
                        Object status = hasAppStatus ? r.getString("status") : "-";
                        model.addRow(new Object[]{
                            r.getInt("ka_ID"),
                            r.getString("emer"),
                            r.getString("kerkuesi"),
                            r.getDate("dataKerkeses"),
                            status
                        });
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gabim gjatë ngarkimit të aplikimeve: " + e.getMessage());
            }
        }
    }

    private Integer getSelectedApplicationId() {
        int row = appsTable.getSelectedRow();
        if (row < 0) {
            return null;
        }
        return (Integer) appsTable.getModel().getValueAt(row, 0);
    }

    private void reject() {
        Integer appId = getSelectedApplicationId();
        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Zgjidh nje rresht!");
            return;
        }
        if (!hasColumn("kerkesatadoptim", "status")) {
            JOptionPane.showMessageDialog(this, "Kolona 'status' nuk ekziston.");
            return;
        }
        try (PreparedStatement ps = con.prepareStatement("UPDATE kerkesatadoptim SET status='REFUZUAR' WHERE ka_ID=?")) {
            ps.setInt(1, appId);
            ps.executeUpdate();
            loadApplications();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gabim: " + e.getMessage());
        }
    }

    private void loadDisponueshmeriaForSelectedAnimal() {
        String selected = (String) k_ID.getSelectedItem();
        if (selected == null || selected.equals("--")) {
            clearFields();
            dispoF.setEnabled(false);
            strehaTxt.setEnabled(false);
            approveBtn.setEnabled(false);
            shtoAplikimeBtn.setEnabled(false);
            rejectBtn.setEnabled(false);
            return;
        }
        try {
            String sql = "SELECT k.adoption_status, s.adresa FROM kafshet k "
                    + "LEFT JOIN caktimi_i_kafsheve_ne_streha c ON c.kafsha_ID = k.kafsha_ID AND c.end_date IS NULL "
                    + "LEFT JOIN strehezaperkohshme s ON s.streha_ID = c.streha_ID WHERE k.kafsha_ID = ? LIMIT 1";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(selected));
                try (ResultSet rsLocal = ps.executeQuery()) {
                    if (rsLocal.next()) {
                        String adoptionStatus = rsLocal.getString("adoption_status");
                        String adresa = rsLocal.getString("adresa");

                        if (adoptionStatus != null && adoptionStatus.equalsIgnoreCase("I LIRE")) {
                            dispoF.setSelectedItem("1");
                            approveBtn.setEnabled(true);
                            shtoAplikimeBtn.setEnabled(true);
                            rejectBtn.setEnabled(true);
                            dispoF.setEnabled(true);
                            strehaTxt.setEnabled(true);
                        } else {
                            dispoF.setSelectedItem("0");
                            approveBtn.setEnabled(false);
                            shtoAplikimeBtn.setEnabled(false);
                            rejectBtn.setEnabled(false);

                        }

                        if (adresa == null) {
                            strehaTxt.setSelectedIndex(0);
                        } else {
                            strehaTxt.setSelectedItem(adresa);
                        }
                    } else {
                        clearFields();
                        approveBtn.setEnabled(false);
                        shtoAplikimeBtn.setEnabled(false);
                        rejectBtn.setEnabled(false);
                        dispoF.setEnabled(false);
                        strehaTxt.setEnabled(false);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjatë ngarkimit të disponueshmerisë: " + ex.getMessage());
        }
    }

    private void updateDisponueshmeria() {
        String selected = (String) k_ID.getSelectedItem();
        if (selected == null || selected.equals("--")) {
            JOptionPane.showMessageDialog(this, "Zgjidh nje kafshe!");
            return;
        }
        Integer disponimVal = parseDisponim(dispoF.getSelectedItem().toString());
        if (disponimVal == null) {
            JOptionPane.showMessageDialog(this, "Shkruaj 1/0 per Po/Jo per disponueshmeri.");
            return;
        }
        String shelterText = strehaTxt.getSelectedItem().toString();
        Integer strehaId = resolveShelterId(shelterText);
        if (shelterText != null && !shelterText.trim().isEmpty() && strehaId == null) {
            JOptionPane.showMessageDialog(this, "Streha e zgjedhur nuk u gjet.");
            return;
        }
        try {
            String status = (disponimVal == 1) ? "I LIRE" : "I ZENE";
            try (PreparedStatement ps = con.prepareStatement("UPDATE kafshet SET adoption_status = ? WHERE kafsha_ID = ?")) {
                ps.setString(1, status);
                ps.setInt(2, Integer.parseInt(selected));
                ps.executeUpdate();
            }
            try (PreparedStatement psEnd = con.prepareStatement("UPDATE caktimi_i_kafsheve_ne_streha SET end_date = curdate() WHERE kafsha_ID = ? AND end_date IS NULL")) {
                psEnd.setInt(1, Integer.parseInt(selected));
                psEnd.executeUpdate();
            }
            if (strehaId != null) {
                try (PreparedStatement psIns = con.prepareStatement(
                        "INSERT INTO caktimi_i_kafsheve_ne_streha (kafsha_ID, streha_ID, start_date) VALUES (?, ?, curdate())")) {
                    psIns.setInt(1, Integer.parseInt(selected));
                    psIns.setInt(2, strehaId);
                    psIns.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(this, "Databasa u perditesua me sukses.");
            loadDisponueshmeriaForSelectedAnimal();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjate perditesimit: " + ex.getMessage());
        }
    }

    private void deleteDisponueshmeria() {
        String selected = (String) k_ID.getSelectedItem();
        if (selected == null || selected.equals("--")) {
            JOptionPane.showMessageDialog(this, "Zgjidh nje kafshe!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Doni te hiqni caktimin dhe te riktheni ne gjendje 'I LIRE'?", "Konfirmo", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            try (PreparedStatement ps = con.prepareStatement("UPDATE kafshet SET adoption_status = 'I LIRE' WHERE kafsha_ID = ?")) {
                ps.setInt(1, Integer.parseInt(selected));
                ps.executeUpdate();
            }
            try (PreparedStatement psEnd = con.prepareStatement("UPDATE caktimi_i_kafsheve_ne_streha SET end_date = curdate() WHERE kafsha_ID = ? AND end_date IS NULL")) {
                psEnd.setInt(1, Integer.parseInt(selected));
                int res = psEnd.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Caktimi u fshi dhe statusi u rikthye ne 'I LIRE'.");
                } else {
                    JOptionPane.showMessageDialog(this, "Asnje caktim aktiv per t'u hequr. Statusi u rikthye ne 'I LIRE'.");
                }
            }
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjate fshirjes: " + ex.getMessage());
        }
    }

    private Integer resolveShelterId(String text) {
        if (text == null) {
            return null;
        }
        String t = text.trim();
        if (t.isEmpty()) {
            return null;
        }
        try {
            int id = Integer.parseInt(t);
            String sql = "SELECT streha_ID FROM strehezaperkohshme WHERE streha_ID = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rsLocal = ps.executeQuery()) {
                    if (rsLocal.next()) {
                        return id;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(adoptimGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ignore) {
        }
        try {
            String sql = "SELECT streha_ID FROM strehezaperkohshme WHERE adresa = ? LIMIT 1";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, t);
                try (ResultSet rsLocal = ps.executeQuery()) {
                    if (rsLocal.next()) {
                        return rsLocal.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void shtoStrehez() {

        JDialog dialogJ = new JDialog((Frame) null, "Shto strehe", true);
        dialogJ.setSize(400, 300);

        JPanel dialog = new JPanel(new GridLayout(5, 2, 15, 15));

        JTextField adresa = new JTextField();
        JTextField emer = new JTextField();
        JTextField kapaciteti = new JTextField();

        JButton ruajButon = new JButton("Ruaj");

        JButton anulloButon = new JButton("Anullo");

        dialog.add(new JLabel("Emri i strehes:"));
        dialog.add(emer);

        dialog.add(new JLabel("Adresa:"));
        dialog.add(adresa);

        dialog.add(new JLabel("Kapaciteti:"));
        dialog.add(kapaciteti);

        dialog.add(ruajButon);
        dialog.add(anulloButon);

        dialog.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        dialogJ.add(dialog);

        GUIHelper.styleComponents(dialogJ);

        ruajButon.addActionListener(ev -> {
            String adresaString = adresa.getText();
            String emriString = emer.getText();
            String kapacitetiString = kapaciteti.getText();

            if (adresaString.isEmpty() || emriString.isEmpty() || kapacitetiString.isEmpty()) {
                JOptionPane.showMessageDialog(dialogJ, "Te lutem ploteso te gjitha fushat!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO strehezaperkohshme (adresa, emer, kapaciteti) VALUES (?, ?, ?)")) {
                ps.setString(1, adresaString);
                ps.setString(2, emriString);
                ps.setString(3, kapacitetiString);
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
    }

    private void clearFields() {
        dispoF.setSelectedIndex(0);
        strehaTxt.setSelectedIndex(0);
    }

    private Integer parseDisponim(String text) {
        if (text == null) {
            return null;
        }
        String t = text.trim().toLowerCase();
        if (t.equals("1") || t.equals("po") || t.equals("yes") || t.equals("true")) {
            return 1;
        }
        if (t.equals("0") || t.equals("jo") || t.equals("no") || t.equals("false")) {
            return 0;
        }
        try {
            int v = Integer.parseInt(t);
            if (v == 0 || v == 1) {
                return v;
            }
        } catch (NumberFormatException ignored) {
        }
        return null;
    }

    private void newAppBtnActionPerformed() {
        String selected = (String) k_ID.getSelectedItem();
        if (selected == null || selected.equals("--")) {
            JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni një kafshë!", "Gabim", JOptionPane.WARNING_MESSAGE);
            return;
        }

        aplikimiRiDialog dialog = new aplikimiRiDialog(this);
        dialog.setVisible(true);
        if (!dialog.isOkPressed()) {
            return;
        }

        String kerkuesi = dialog.getApplicantName() != null ? dialog.getApplicantName().trim() : "";
        String nrTel = dialog.getPhone() != null ? dialog.getPhone().trim() : "";
        String email = dialog.getEmail() != null ? dialog.getEmail().trim() : "";
        String shenim = dialog.getNote() != null ? dialog.getNote().trim() : "";

        String adresa = (String) strehaTxt.getSelectedItem();
        Integer strehaId = resolveShelterId(adresa);

        try (PreparedStatement ps = con.prepareStatement(
                "INSERT INTO kerkesatadoptim (streha_ID, kafsha_ID, kerkuesi, dataKerkeses, telefoni, email, shenim) VALUES (?, ?, ?, CURRENT_DATE, ?, ?, ?)")) {

            if (strehaId == null) {
                ps.setNull(1, Types.INTEGER);
            } else {
                ps.setInt(1, strehaId);
            }

            ps.setInt(2, Integer.parseInt(selected));
            ps.setString(3, kerkuesi);
            ps.setString(4, nrTel);
            ps.setString(5, email);
            ps.setString(6, shenim);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Aplikimi u shtua me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadApplications();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gabim gjatë shtimit të aplikimit: " + e.getMessage(), "Gabim", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void deleteAppBtnActionPerformed() {

        Integer appId = getSelectedApplicationId();
        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Zgjidh nje rresht!");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Fshije aplikimin?", "Konfirmo", JOptionPane.YES_NO_OPTION);
        if (c != JOptionPane.YES_OPTION) {
            return;
        }
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM kerkesatadoptim WHERE ka_ID=?")) {
            ps.setInt(1, appId);
            ps.executeUpdate();
            loadApplications();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gabim: " + e.getMessage());
        }

    }
}
