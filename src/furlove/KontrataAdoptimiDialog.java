package furlove;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class KontrataAdoptimiDialog extends JDialog {

    private JTextArea contractTextArea;
    private JTextField contractNumberField;
    private JTextField contractDateField;
    private JTextField applicantNameField;
    private JTextField animalNameField;
    private JTextField adoptionDateField;
    private JTextField feeField;
    private JTextArea termsArea;
    private JButton saveContractBtn;
    private JButton printContractBtn;
    private JButton closeBtn;

    Connection con;
    private int aplikimId;
    private String contractPath;

    public KontrataAdoptimiDialog(JFrame owner, Connection con, int adoptionId) {
        super(owner, "Kontratë e Adoptimit", true);
        this.con = con;
        this.aplikimId = adoptionId;
        this.contractPath = "src/contracts/";

        initComponents();
        loadAdoptionData();
        loadExistingContract();
        pack();
        setLocationRelativeTo(owner);
        setMinimumSize(new Dimension(800, 700));
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Kontratë e Adoptimit");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel detailsPanel = createDetailsPanel();
        mainPanel.add(detailsPanel, BorderLayout.WEST);

        JPanel contractPanel = createContractPanel();
        mainPanel.add(contractPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createDetailsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Detajet e Kontratës"));
        panel.setPreferredSize(new Dimension(300, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        addRow(panel, gbc, row++, new JLabel("Nr. Kontratës:"), contractNumberField = new JTextField(15));
        contractNumberField.setText("KONT-" + String.format("%06d", aplikimId));
        contractNumberField.setEditable(false);

        addRow(panel, gbc, row++, new JLabel("Data e Kontratës:"), contractDateField = new JTextField(15));
        contractDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        contractDateField.setEditable(false);

        addRow(panel, gbc, row++, new JLabel("Emri i Aplikantit:"), applicantNameField = new JTextField(15));
        applicantNameField.setEditable(false);

        addRow(panel, gbc, row++, new JLabel("Emri i Kafshes:"), animalNameField = new JTextField(15));
        animalNameField.setEditable(false);

        addRow(panel, gbc, row++, new JLabel("Data e Adoptimit:"), adoptionDateField = new JTextField(15));
        adoptionDateField.setEditable(false);

        addRow(panel, gbc, row++, new JLabel("Tarifa:"), feeField = new JTextField(15));
        feeField.setEditable(false);

        addRow(panel, gbc, row++, new JLabel("Kushtet:"), new JLabel(""));
        termsArea = new JTextArea(8, 25);
        termsArea.setLineWrap(true);
        termsArea.setWrapStyleWord(true);
        termsArea.setText(getDefaultTerms());
        JScrollPane termsScroll = new JScrollPane(termsArea);
        termsScroll.setPreferredSize(new Dimension(250, 120));
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        panel.add(termsScroll, gbc);

        return panel;
    }

    private JPanel createContractPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Teksti i Kontrates"));

        contractTextArea = new JTextArea();
        contractTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contractTextArea.setEditable(false);
        contractTextArea.setLineWrap(true);
        contractTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(contractTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        saveContractBtn = new JButton("Ruaj Kontraten");
        saveContractBtn.setBackground(new Color(0, 153, 255));
        saveContractBtn.setForeground(Color.WHITE);
        saveContractBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        printContractBtn = new JButton("Printo Kontraten");
        printContractBtn.setBackground(new Color(76, 175, 80));
        printContractBtn.setForeground(Color.WHITE);
        printContractBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        closeBtn = new JButton("Mbyll");
        closeBtn.setBackground(new Color(158, 158, 158));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        saveContractBtn.addActionListener(e -> saveContract());
        printContractBtn.addActionListener(e -> printContract());
        closeBtn.addActionListener(e -> dispose());

        panel.add(saveContractBtn);
        panel.add(printContractBtn);
        panel.add(closeBtn);

        return panel;
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, JComponent label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(field, gbc);
    }

    private void loadAdoptionData() {
        try {
            String sql = "SELECT a.*, k.emri as kafsha_emri, k.specia FROM adoptime a "
                    + "LEFT JOIN kafshet k ON a.kafsha_ID = k.kafsha_ID "
                    + "WHERE a.aplikim_ID = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, aplikimId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String fullName = rs.getString("emer") + " " + rs.getString("mbiemer");
                        applicantNameField.setText(fullName);

                        String animalInfo = rs.getString("kafsha_emri") + " (" + rs.getString("specia") + ")";
                        animalNameField.setText(animalInfo);

                        Date adoptionDate = rs.getDate("data_adoptimit");
                        if (adoptionDate != null) {
                            adoptionDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(adoptionDate));
                        }

                        java.math.BigDecimal fee = rs.getBigDecimal("tarifa");
                        if (fee != null) {
                            feeField.setText(fee.toString() + " €");
                        } else {
                            feeField.setText("Pa tarifë");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gabim gjate ngarkimit te te dhenave: " + e.getMessage());
        }
    }

    private void loadExistingContract() {
        boolean loaded = false;
        try {
            String sql = "SELECT kontrat FROM adoptime WHERE aplikim_ID = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, aplikimId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String existingContract = rs.getString("kontrat");
                        if (existingContract != null && !existingContract.trim().isEmpty()) {
                            File file = new File(existingContract);
                            if (file.exists()) {
                                String content = Files.readString(file.toPath(), StandardCharsets.UTF_8);
                                if (!content.trim().isEmpty()) {
                                    contractTextArea.setText(content);
                                    loaded = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        if (!loaded) {
            generateContractText();
        }
    }

    private void generateContractText() {
        StringBuilder contract = new StringBuilder();
        contract.append("KONTRATË E ADOPTIMIT\n");
        contract.append("==========================================\n\n");

        contract.append("Nr. Kontratës: ").append(contractNumberField.getText()).append("\n");
        contract.append("Data e Kontratës: ").append(contractDateField.getText()).append("\n\n");

        contract.append("NËNËSHKRUESIT:\n");
        contract.append("1. Qendra për Kafshe Endacake \"FurLove\"\n");
        contract.append("   Adresa: _____________________________\n");
        contract.append("   Përfaqësues: ________________________\n\n");

        contract.append("2. Aplikanti: ").append(applicantNameField.getText()).append("\n");
        contract.append("   Adresa: _____________________________\n");
        contract.append("   Telefoni: ___________________________\n");
        contract.append("   Email: ______________________________\n\n");

        contract.append("OBJEKTI I KONTRATËS:\n");
        contract.append("Kafsha: ").append(animalNameField.getText()).append("\n");
        contract.append("Data e Adoptimit: ").append(adoptionDateField.getText()).append("\n");
        contract.append("Tarifa: ").append(feeField.getText()).append("\n\n");

        contract.append("KUSHTET DHE DETYRIMET:\n");
        contract.append(termsArea.getText()).append("\n\n");

        contract.append("NËNËSHKRIMET:\n\n");
        contract.append("Përfaqësuesi i Qendrës:    _________________    Data: _________\n\n");
        contract.append("Aplikanti:                   _________________    Data: _________\n\n");

        contract.append("==========================================\n");
        contract.append("Kjo kontratë është e vlefshme nga data e nënëshkrimit.\n");

        contractTextArea.setText(contract.toString());
        contractTextArea.setEditable(true);
    }

    private String getDefaultTerms() {
        return "1. Aplikanti merr përgjegjësi për kujdesin dhe mirëqenien e kafshes.\n"
                + "2. Kafsha duhet të mbajet në kushte të përshtatshme dhe të sigurohet me ushqim të mirë.\n"
                + "3. Aplikanti duhet të marrë kafshën për kontroll mjekësor të rregullt.\n"
                + "4. Nuk lejohet dhënia e kafshes së adoptuar në duart e të tretëve.\n"
                + "5. Në rast se aplikanti nuk mund të vazhdojë kujdesin, kafsha duhet të kthehet në qendër.\n"
                + "6. Qendra mbështet aplikantin me këshilla dhe ndihmë kur është e nevojshme.\n"
                + "7. Kjo kontratë është e vlefshme për jetën e kafshes.";
    }

    private void saveContract() {

        if (contractTextArea.getText().trim().isEmpty()) {
            generateContractText();
        }

        try {
            File contractsDir = new File(contractPath);
            if (!contractsDir.exists()) {
                contractsDir.mkdirs();
            }

            String fileName = "contract_" + aplikimId + ".txt";
            File contractFile = new File(contractPath + fileName);

            try (PrintWriter writer = new PrintWriter(new FileWriter(contractFile))) {
                writer.write(contractTextArea.getText());
            }

            String sql = "UPDATE adoptime SET kontrat = ? WHERE aplikim_ID = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, contractFile.getAbsolutePath());
                ps.setInt(2, aplikimId);
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(this,
                    "Kontrata u ruajt me sukses!\n"
                    + "Vendndodhja: " + contractFile.getAbsolutePath(),
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Gabim gjatë ruajtjes së kontratës: " + e.getMessage(),
                    "Gabim", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void printContract() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Create temporary file for printing
                File tempFile = File.createTempFile("contract_" + aplikimId, ".txt");
                try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
                    writer.write(contractTextArea.getText());
                }

                // Open with default text editor for printing
                desktop.open(tempFile);

                JOptionPane.showMessageDialog(this,
                        "Kontrata u hap në editorin e tekstit.\n"
                        + "Përdorni File -> Print për ta printuar.",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this,
                        "Printimi nuk është i mbështetur në këtë sistem.",
                        "Verejtje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Gabim gjatë hapjes së kontratës: " + e.getMessage(),
                    "Gabim", JOptionPane.ERROR_MESSAGE);
        }
    }
}
