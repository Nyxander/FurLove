package furlove;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

public class galeriaGUI extends javax.swing.JFrame {

    public galeriaGUI() {
        initComponents();
        Connect();
        Load();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GUIHelper.styleComponents(this.getContentPane());
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private void Load() {

        try {
            k_ID.removeAllItems();
            k_ID.addItem("--");
            pst = con.prepareStatement("SELECT kafsha_id FROM kafshet WHERE 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                k_ID.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void Connect() {

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

        jLabel1 = new javax.swing.JLabel();
        k_ID = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ngarkoButon = new javax.swing.JButton();
        fotoBtn = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKthehu = new javax.swing.JMenuItem();
        galeriMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Harrington", 0, 48)); // NOI18N
        jLabel1.setText("Galeria");

        k_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        k_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel2.setText("ID e kafshes:");

        ngarkoButon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngarkoButon.setText("Ngarko fotot");
        ngarkoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngarkoButonActionPerformed(evt);
            }
        });

        fotoBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fotoBtn.setText("Shto foto");
        fotoBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fotoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotoBtnActionPerformed(evt);
            }
        });

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

        galeriMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paw.png"))); // NOI18N
        galeriMenu.setText("Rekordet e kafsheve");
        galeriMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galeriMenuActionPerformed(evt);
            }
        });
        jMenu1.add(galeriMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(fotoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(k_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(ngarkoButon)))
                .addGap(95, 95, 95)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fotoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(k_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ngarkoButon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
        );

        URL imgUrl = getClass().getResource("/icons/Fur-LoveTransparent-Galeria.png");

        try{

            if (imgUrl == null) {
                File devPath = new File("src/icons/Fur-LoveTransparent-Galeria.png");
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
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 160, 910, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ngarkoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngarkoButonActionPerformed
        shfaqFototPerKafshen();
    }//GEN-LAST:event_ngarkoButonActionPerformed

    private void fotoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotoBtnActionPerformed

        if (k_ID.getSelectedItem() == null || k_ID.getSelectedItem().toString().equals("--")) {
            JOptionPane.showMessageDialog(this, "Te lutem zgjidh ID-n e kafshes nga lista para se te shtosh foto!", "Verejtje", JOptionPane.WARNING_MESSAGE);
            return;
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
                String baseName;
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

                    try {
                    
                        String updateSql = "UPDATE kafshet SET foto = ? WHERE kafsha_ID = ?";
                        try (PreparedStatement ps = con.prepareStatement(updateSql)) {
                            ps.setString(1, relativePath);
                            ps.setInt(2, Integer.parseInt(selectedAnimalId));
                            int updateResult = ps.executeUpdate();

                            if (updateResult > 0) {
                            } else {
                                JOptionPane.showMessageDialog(this, "Fotoja nuk arrite te ruhej ne databaze.");
                            }
                        }
                    } catch (SQLException ex) {
                        System.err.println("Fotoja nuk arrite te ruhej ne databaze: " + ex.getMessage());
                        ex.printStackTrace();
                    }

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
                    ex.printStackTrace();
                }
            }

            if (copied > 0) {
                JOptionPane.showMessageDialog(this, copied + " foto u shtuan dhe u ruajten ne databaze per kafshin ID: " + selectedAnimalId);
                Load();
            } else {
                JOptionPane.showMessageDialog(this, "Nuk u shtua asnje foto.", "Verejtje", JOptionPane.WARNING_MESSAGE);

            }

        }
    }//GEN-LAST:event_fotoBtnActionPerformed

    private void menuKthehuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKthehuActionPerformed
        new MenuGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuKthehuActionPerformed

    private void galeriMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galeriMenuActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekordetKafshet().setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_galeriMenuActionPerformed
/*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new galeriaGUI().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel foto;
    private javax.swing.JButton fotoBtn;
    private javax.swing.JMenuItem galeriMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox<String> k_ID;
    private javax.swing.JMenuItem menuKthehu;
    private javax.swing.JButton ngarkoButon;
    // End of variables declaration//GEN-END:variables

    private void shfaqFototPerKafshen() {
        try {
            String kafshaId = k_ID.getSelectedItem().toString();

            String sql = "SELECT foto_path FROM fotot_kafsheve WHERE kafsha_ID = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, kafshaId);
            rs = pst.executeQuery();

            JPanel panelFoto = new JPanel(new FlowLayout());
            panelFoto.setLayout(new BoxLayout(panelFoto, BoxLayout.Y_AXIS));

            while (rs.next()) {
                String relativePath = rs.getString("foto_path");
                File fotoFile = new File(relativePath);

                if (!fotoFile.exists()) {
                    continue;
                }

                try {
                    BufferedImage img = ImageIO.read(fotoFile);
                    if (img == null) {
                        continue;
                    }

                    int targetHeight = 150;
                    int targetWidth = (int) ((double) img.getWidth() / img.getHeight() * targetHeight);

                    BufferedImage scaled = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2d = scaled.createGraphics();
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.drawImage(img, 0, 0, targetWidth, targetHeight, null);
                    g2d.dispose();

                    JPanel photoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    photoPanel.setBorder(BorderFactory.createBevelBorder(3));

                    JLabel label = new JLabel(new ImageIcon(scaled));
                    JButton deleteBtn = new JButton("Fshi");
                    deleteBtn.setBackground(Color.WHITE);
                    deleteBtn.setPreferredSize(new Dimension(60, 20));

                    deleteBtn.addActionListener(e -> {
                        int confirm = JOptionPane.showConfirmDialog(
                                this,
                                "Doni te fshini foton?",
                                "Konfirmo Delete",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (confirm == JOptionPane.YES_OPTION) {
                            if (deletePhoto(relativePath, kafshaId)) {
                                panelFoto.remove(photoPanel);
                                panelFoto.revalidate();
                                panelFoto.repaint();
                            }
                        }
                    });

                    photoPanel.add(label);
                    photoPanel.add(deleteBtn);
                    panelFoto.add(photoPanel);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            JScrollPane scrollPane = new JScrollPane(panelFoto);
            scrollPane.setPreferredSize(new Dimension(500, 400));

            JOptionPane.showMessageDialog(null, scrollPane, "Fotot e kafshës", JOptionPane.PLAIN_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gabim gjatë marrjes së fotove: " + e.getMessage());
        }
    }

    private boolean deletePhoto(String photoPath, String kafshaId) {
        try {
            String deleteSql = "DELETE FROM fotot_kafsheve WHERE kafsha_ID = ? AND foto_path = ?";
            try (PreparedStatement ps = con.prepareStatement(deleteSql)) {
                ps.setString(1, kafshaId);
                ps.setString(2, photoPath);
                int deleteResult = ps.executeUpdate();

                if (deleteResult > 0) {
                    File photoFile = new File(photoPath);
                    if (photoFile.exists() && photoFile.delete()) {
                        JOptionPane.showMessageDialog(this, "Foto u fshi me sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Foto u fshi nga databaza por nuk mund te fshihet nga sistemi!", "Verejtje", JOptionPane.WARNING_MESSAGE);
                    }
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "Nuk mund te fshihet foto nga databaza!", "Gabim", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjatë fshirjes së fotos: " + ex.getMessage(), "Gabim", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public static ImageIcon getScaledIcon(Image original, int width, int height) {
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();

        return new ImageIcon(scaled);
    }

}
