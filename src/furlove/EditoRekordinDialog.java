package furlove;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class EditoRekordinDialog extends JDialog {

    private JTextField applicantNameField;
    private JTextField applicantSurnameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField feeField;
    private JTextField contractField;
    private JTextArea notesArea;
    private JTextField dateField;

    private boolean okPressed = false;
    private int adoptionId;

    public EditoRekordinDialog(JFrame owner, int adoptionId) {
        super(owner, "Edito Regjistrin e Adoptimit", true);
        this.adoptionId = adoptionId;
        Connect();
        initComponents();
        loadAdoptionData();
        pack();
        setLocationRelativeTo(owner);
        setMinimumSize(new Dimension(500, 500));
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

    private void initComponents() {
        Connect();
        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Edito Regjistrin e Adoptimit");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        int row = 0;

        addRow(formPanel, gbc, row++, new JLabel("Emri:"), applicantNameField = new JTextField(20));

        addRow(formPanel, gbc, row++, new JLabel("Mbiemri:"), applicantSurnameField = new JTextField(20));

        addRow(formPanel, gbc, row++, new JLabel("Telefoni:"), phoneField = new JTextField(20));

        addRow(formPanel, gbc, row++, new JLabel("Email:"), emailField = new JTextField(20));

        dateField = new JTextField(20);
        dateField.setToolTipText("Formati: YYYY-MM-DD (p.sh. 2025-08-19)");
        addRow(formPanel, gbc, row++, new JLabel("Data e Adoptimit:"), dateField);

        addRow(formPanel, gbc, row++, new JLabel("Tarifa:"), feeField = new JTextField(20));

        addRow(formPanel, gbc, row++, new JLabel("Kontrat:"), contractField = new JTextField(20));

        notesArea = new JTextArea(4, 20);
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        JScrollPane notesScroll = new JScrollPane(notesArea);
        notesScroll.setPreferredSize(new Dimension(200, 80));
        addRow(formPanel, gbc, row++, new JLabel("Shenime:"), notesScroll);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton cancelBtn = new JButton("Anulo");
        JButton saveBtn = new JButton("Ruaj");

        cancelBtn.addActionListener(e -> {
            okPressed = false;
            dispose();
        });

        saveBtn.addActionListener(e -> {
            if (validateForm()) {
                perditesoTabelen();
            }
        });

        buttonPanel.add(cancelBtn);
        buttonPanel.add(saveBtn);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, JComponent label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(field, gbc);
    }

    private void loadAdoptionData() {
        try {
            String sql = "SELECT * FROM adoptime WHERE aplikim_ID = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, adoptionId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        applicantNameField.setText(rs.getString("emer"));
                        applicantSurnameField.setText(rs.getString("mbiemer"));
                        phoneField.setText(rs.getString("telefoni"));
                        emailField.setText(rs.getString("email"));

                        Date date = rs.getDate("data_adoptimit");
                        if (date != null) {
                            dateField.setText(date.toString());
                        }

                        java.math.BigDecimal fee = rs.getBigDecimal("tarifa");
                        if (fee != null) {
                            feeField.setText(fee.toString());
                        }

                        contractField.setText(rs.getString("kontrat"));
                        notesArea.setText(rs.getString("shenime"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjatë ngarkimit të të dhënave: " + e.getMessage());
            System.err.println(e);
        }
    }

    private boolean validateForm() {
        if (applicantNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ju lutem shkruani emrin e aplikantit.");
            return false;
        }

        if (applicantSurnameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ju lutem shkruani mbiemrin e aplikantit.");
            return false;
        }

        if (dateField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ju lutem shkruani datën e adoptimit.");
            return false;
        }

        try {
            if (!dateField.getText().trim().isEmpty()) {
                java.sql.Date.valueOf(dateField.getText().trim());
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Formati i datës duhet të jetë YYYY-MM-DD");
            return false;
        }

        if (!feeField.getText().trim().isEmpty()) {
            try {
                Double.parseDouble(feeField.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Tarifa duhet të jetë një numër i vlefshëm.");
                return false;
            }
        }

        return true;
    }

    public boolean isOkPressed() {
        return okPressed;
    }

    public String getApplicantName() {
        return applicantNameField.getText().trim();
    }

    public String getApplicantSurname() {
        return applicantSurnameField.getText().trim();
    }

    public String getPhone() {
        String phone = phoneField.getText().trim();
        return phone.isEmpty() ? null : phone;
    }

    public String getEmail() {
        String email = emailField.getText().trim();
        return email.isEmpty() ? null : email;
    }

    public Date getAdoptionDate() {
        try {
            String dateStr = dateField.getText().trim();
            if (dateStr.isEmpty()) {
                return null;
            }
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateStr);
            return new Date(sqlDate.getTime());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public java.math.BigDecimal getFee() {
        try {
            String feeStr = feeField.getText().trim();
            if (feeStr.isEmpty()) {
                return null;
            }
            return new java.math.BigDecimal(feeStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getContract() {
        String contract = contractField.getText().trim();
        return contract.isEmpty() ? null : contract;
    }

    public String getNotes() {
        String notes = notesArea.getText().trim();
        return notes.isEmpty() ? null : notes;
    }

    private void perditesoTabelen() {
        String sql = "UPDATE adoptime SET emer=?, mbiemer=?, telefoni=?, email=?, data_adoptimit=?, tarifa=?, kontrat=?, shenime=? WHERE aplikim_ID=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, getApplicantName());
            pst.setString(2, getApplicantSurname());
            pst.setString(3, getPhone());
            pst.setString(4, getEmail());

            java.sql.Date adoptionDate = null;
            if (getAdoptionDate() != null) {
                adoptionDate = new java.sql.Date(getAdoptionDate().getTime());
            }
            pst.setDate(5, adoptionDate);

            java.math.BigDecimal fee = getFee();
            if (fee != null) {
                pst.setBigDecimal(6, fee);
            } else {
                pst.setNull(6, java.sql.Types.DECIMAL);
            }

            pst.setString(7, getContract());
            pst.setString(8, getNotes());
            pst.setInt(9, adoptionId);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Perditesuar me sukses!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes: " + e.getMessage());
        }
        
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adoptimetGUI().setVisible(true);
                dispose();
            }
        });
    }

}
