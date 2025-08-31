package furlove;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class adoptimetGUI extends javax.swing.JFrame {

    public adoptimetGUI() {
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
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        adoptimeTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fshiBtn = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        editoBtn = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        adoptimeRekord = new javax.swing.JMenuItem();
        addMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adoptimeTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Aplikimit", "Aplikanti", "Nr. tel", "Email", "Data e adoptimit"
            }
        ));
        jScrollPane1.setViewportView(adoptimeTbl);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Adoptimet e kryera me sukses");

        fshiBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fshiBtn.setText("Fshi");
        fshiBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 102)));
        fshiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshiBtnActionPerformed(evt);
            }
        });

        editoBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editoBtn.setText("Edito");
        editoBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 255)));
        editoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editoBtnActionPerformed(evt);
            }
        });

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

        adoptimeRekord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/records.png"))); // NOI18N
        adoptimeRekord.setText("Ktheu pas");
        adoptimeRekord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptimeRekordActionPerformed(evt);
            }
        });
        menu1.add(adoptimeRekord);

        jMenuBar.add(menu1);

        addMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        addMenu.setText("Shto...");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/roof.png"))); // NOI18N
        jMenuItem1.setText("streheza te perkoheshme");
        addMenu.add(jMenuItem1);

        jMenuBar.add(addMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fshiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fshiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                .addContainerGap())
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fshiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshiBtnActionPerformed

        Integer appId = getSelectedApplicationId();
        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Zgjidh nje rresht!");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Fshije aplikimin?", "Konfirmo", JOptionPane.YES_NO_OPTION);
        if (c != JOptionPane.YES_OPTION) {
            return;
        }
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM adoptime WHERE aplikim_ID=?")) {
            ps.setInt(1, appId);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gabim: " + e.getMessage());
            return;
        }

        ktheMiratimin(appId);
        Load();


    }//GEN-LAST:event_fshiBtnActionPerformed

    private void menuKthehuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKthehuActionPerformed
        new MenuGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuKthehuActionPerformed

    private void adoptimeRekordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoptimeRekordActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adoptimGUI().setVisible(true);
                dispose();
            }
        });

    }//GEN-LAST:event_adoptimeRekordActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_menu1ActionPerformed

    private void editoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editoBtnActionPerformed
        Integer appId = getSelectedApplicationId();
        System.out.println("Loading adoption ID: " + appId);

        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni një rresht nga tabela për ta edituar!");
            return;
        }

        EditoRekordinDialog dialog = new EditoRekordinDialog(this, appId);
        dialog.setVisible(true);

        if (dialog.isOkPressed()) {
            try {
                String sql = "UPDATE adoptime SET "
                        + "emer = ?, "
                        + "mbiemer = ?, "
                        + "telefoni = ?, "
                        + "email = ?, "
                        + "data_adoptimit = ?, "
                        + "tarifa = ?, "
                        + "kontrat = ?, "
                        + "shenime = ? "
                        + "WHERE aplikim_ID = ?";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, dialog.getApplicantName());
                    ps.setString(2, dialog.getApplicantSurname());
                    ps.setString(3, dialog.getPhone());
                    ps.setString(4, dialog.getEmail());

                    Date adoptionDate = dialog.getAdoptionDate();
                    if (adoptionDate != null) {
                        ps.setDate(5, new java.sql.Date(adoptionDate.getTime()));
                    } else {
                        ps.setDate(5, null);
                    }

                    ps.setBigDecimal(6, dialog.getFee());
                    ps.setString(7, dialog.getContract());
                    ps.setString(8, dialog.getNotes());
                    ps.setInt(9, appId);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Ndryshimet u ruajtën me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        Load();
                    } else {
                        JOptionPane.showMessageDialog(this, "Nuk u bënë ndryshime në databazë.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gabim gjatë ruajtjes së ndryshimeve: " + e.getMessage(), "Gabim", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_editoBtnActionPerformed

    private void contractBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Integer appId = getSelectedApplicationId();
        if (appId == null) {
            JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni një rresht nga tabela për të shikuar kontratën!");
            return;
        }
        KontrataAdoptimiDialog dialog = new KontrataAdoptimiDialog(this, con, appId);
        dialog.setVisible(true);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adoptimetGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem adoptimeRekord;
    private javax.swing.JTable adoptimeTbl;
    private javax.swing.JButton editoBtn;
    private javax.swing.JLabel foto;
    private javax.swing.JButton fshiBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem menuKthehu;
    // End of variables declaration//GEN-END:variables

    private void Load() {

        String[] columnNames = {"ID Aplikimit", "Aplikanti", "Nr. tel", "Email", "Data e adoptimit"};
        DefaultTableModel model = (DefaultTableModel) adoptimeTbl.getModel();
        model.setRowCount(0);

        try {

            pst = con.prepareStatement(
                    "SELECT aplikim_ID, CONCAT(emer, ' ', mbiemer) AS aplikanti, telefoni, email, data_adoptimit "
                    + "FROM adoptime"
            );
            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("aplikim_ID"),
                    rs.getString("aplikanti"),
                    rs.getString("telefoni"),
                    rs.getString("email"),
                    rs.getString("data_adoptimit"),});
            }

            adoptimeTbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            for (int column = 0; column < adoptimeTbl.getColumnCount(); column++) {
                TableColumn tableColumn = adoptimeTbl.getColumnModel().getColumn(column);
                int preferredWidth = 250;
                for (int row = 0; row < adoptimeTbl.getRowCount(); row++) {
                    Component c = adoptimeTbl.prepareRenderer(adoptimeTbl.getCellRenderer(row, column), row, column);
                    preferredWidth = Math.max(preferredWidth, c.getPreferredSize().width + 10);
                }
                tableColumn.setPreferredWidth(preferredWidth);
            }

        } catch (java.sql.SQLSyntaxErrorException e) {
            model.setRowCount(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Integer getSelectedApplicationId() {
        int row = adoptimeTbl.getSelectedRow();
        if (row < 0) {
            return null;
        }
        return Integer.valueOf(adoptimeTbl.getModel().getValueAt(row, 0).toString());

    }

    private void ktheMiratimin(int appId) {

        try (PreparedStatement ps = con.prepareStatement("UPDATE kerkesatadoptim SET status='NË PRITJE' WHERE ka_ID=?")) {
            ps.setInt(1, appId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement ps = con.prepareStatement("UPDATE kafshet SET adoption_status='I LIRE' WHERE kafsha_ID=(SELECT kafsha_ID FROM kerkesatadoptim WHERE ka_id=?)")) {

            ps.setInt(1, appId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
