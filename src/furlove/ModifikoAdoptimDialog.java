package furlove;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class ModifikoAdoptimDialog extends JDialog {

    private JTextField applicantField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextArea noteArea;
    private JComboBox<String> statusCombo;
    private JComboBox<String> shelterCombo;
    private JComboBox<String> animalCombo;
    private JTextField dateField;

    private boolean okPressed = false;
    private int aplikimId;

    public ModifikoAdoptimDialog(JFrame owner, Connection con, int applicationId) {
        super(owner, "Edito Formen e Adoptimit", true);
        Connect();
        this.aplikimId = applicationId;
        initComponents();
        loadApplicationData();
        pack();
        setMinimumSize(new Dimension(500, 550));
        GUIHelper.styleComponents(this.getContentPane());
    }

    Connection con;

    private void initComponents() {

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Edito Aplikimin e Adoptimit");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 18));
        
        add(titleLabel, BorderLayout.NORTH);

        int row = 0;

        addRow(formPanel, gbc, row++, new JLabel("Emri i Kerkuesit:"), applicantField = new JTextField(20));

        addRow(formPanel, gbc, row++, new JLabel("Telefoni:"), phoneField = new JTextField(20));

        addRow(formPanel, gbc, row++, new JLabel("Email:"), emailField = new JTextField(20));

        statusCombo = new JComboBox<>(new String[]{"NË PRITJE", "MIRATUAR", "REFUZUAR", "ANULUAR"});
        addRow(formPanel, gbc, row++, new JLabel("Statusi:"), statusCombo);

        shelterCombo = new JComboBox<>();
        loadShelters();
        addRow(formPanel, gbc, row++, new JLabel("Streha:"), shelterCombo);

        animalCombo = new JComboBox<>();
        loadAnimals();
        addRow(formPanel, gbc, row++, new JLabel("Kafsha:"), animalCombo);

        dateField = new JTextField(20);
        dateField.setToolTipText("Formati: YYYY-MM-DD (p.sh. 2025-08-19)");
        addRow(formPanel, gbc, row++, new JLabel("Data e Kërkesës:"), dateField);

        noteArea = new JTextArea(4, 20);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        JScrollPane noteScroll = new JScrollPane(noteArea);
        noteScroll.setPreferredSize(new Dimension(200, 80));
        addRow(formPanel, gbc, row++, new JLabel("Shenime:"), noteScroll);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton saveBtn = new JButton("Ruaj");
        JButton cancelBtn = new JButton("Anulo");

        cancelBtn.addActionListener(e -> {
            okPressed = false;
            dispose();
        });

        saveBtn.addActionListener(e -> {
            if (validateForm()) {
                okPressed = true;
                dispose();
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

    private void loadShelters() {
        try {
            shelterCombo.removeAllItems();
            shelterCombo.addItem("--");

            String sql = "SELECT streha_ID, adresa FROM strehezaperkohshme ORDER BY adresa";
            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    shelterCombo.addItem(rs.getString("adresa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAnimals() {
        try {
            animalCombo.removeAllItems();
            animalCombo.addItem("--");

            String sql = "SELECT kafsha_ID, emri, specia FROM kafshet ORDER BY emri";
            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String displayText = rs.getString("emri") + " (" + rs.getString("specia") + ")";
                    animalCombo.addItem(displayText);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadApplicationData() {
        try {
            String sql = "SELECT k.*, s.adresa FROM kerkesatadoptim k "
                    + "LEFT JOIN strehezaperkohshme s ON k.streha_ID = s.streha_ID "
                    + "WHERE k.ka_ID = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, aplikimId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        applicantField.setText(rs.getString("kerkuesi"));
                        phoneField.setText(rs.getString("telefoni"));
                        emailField.setText(rs.getString("email"));
                        noteArea.setText(rs.getString("shenim"));

                        // Set status
                        String status = rs.getString("status");
                        if (status != null) {
                            statusCombo.setSelectedItem(status);
                        }

                        // Set shelter
                        String shelter = rs.getString("adresa");
                        if (shelter != null) {
                            shelterCombo.setSelectedItem(shelter);
                        }

                        // Set animal
                        int animalId = rs.getInt("kafsha_ID");
                        if (animalId > 0) {
                            String animalName = getAnimalDisplayName(animalId);
                            if (animalName != null) {
                                animalCombo.setSelectedItem(animalName);
                            }
                        }

                        // Set date
                        Date date = rs.getDate("dataKerkeses");
                        if (date != null) {
                            dateField.setText(date.toString());
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjatë ngarkimit të të dhënave: " + e.getMessage());
        }
    }

    private String getAnimalDisplayName(int animalId) {
        try {
            String sql = "SELECT emri, specia FROM kafshet WHERE kafsha_ID = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, animalId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("emri") + " (" + rs.getString("specia") + ")";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public boolean isOkPressed() {
        return okPressed;
    }

    public String getApplicantName() {
        return applicantField.getText().trim();
    }

    public String getPhone() {
        String phone = phoneField.getText().trim();
        return phone.isEmpty() ? null : phone;
    }

    public String getEmail() {
        String email = emailField.getText().trim();
        return email.isEmpty() ? null : email;
    }

    public String getNote() {
        String note = noteArea.getText().trim();
        return note.isEmpty() ? null : note;
    }

    public String getStatus() {
        return (String) statusCombo.getSelectedItem();
    }

    public String getShelter() {
        return (String) shelterCombo.getSelectedItem();
    }

    public String getAnimal() {
        return (String) animalCombo.getSelectedItem();
    }

    public Date getDate() {
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

    public int getShelterId() {
        String shelterAddress = getShelter();
        try {
            String sql = "SELECT streha_ID FROM strehezaperkohshme WHERE adresa = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, shelterAddress);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("streha_ID");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getAnimalId() {
        String animalDisplay = getAnimal();
        if (animalDisplay == null || animalDisplay.equals("--")) {
            return -1;
        }

        String animalName = animalDisplay.substring(0, animalDisplay.indexOf(" ("));

        try {
            String sql = "SELECT kafsha_ID FROM kafshet WHERE emri = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, animalName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("kafsha_ID");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furlove", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private boolean validateForm() {
    String applicant = applicantField.getText().trim();
    if (applicant.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ju lutem shkruani emrin e kerkuesit.", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String phone = phoneField.getText().trim();
    if (!phone.isEmpty() && !phone.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this, "Numri i telefonit duhet te permbaje vetem numra (10 shifra).", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String email = emailField.getText().trim();
    if (!email.isEmpty() && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
        JOptionPane.showMessageDialog(this, "Email-i nuk eshte ne format te vlefshem.", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (statusCombo.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni nje status.", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (shelterCombo.getSelectedItem() == null || shelterCombo.getSelectedItem().equals("--")) {
        JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni nje strehe.", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (animalCombo.getSelectedItem() == null || animalCombo.getSelectedItem().equals("--")) {
        JOptionPane.showMessageDialog(this, "Ju lutem zgjidhni nje kafshe.", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String dateStr = dateField.getText().trim();
    if (!dateStr.isEmpty()) {
        if (!dateStr.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Data duhet t jete ne formatin YYYY-MM-DD.", "Gabim", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            java.sql.Date.valueOf(dateStr); 
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Data e dhene nuk eshte e vlefshme.", "Gabim", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Ju lutem shkruani daten e kerkeses.", "Gabim", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    return true; 
}

}
