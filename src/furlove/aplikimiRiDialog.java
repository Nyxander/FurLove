package furlove;

import javax.swing.*;
import java.awt.*;

public class aplikimiRiDialog extends JDialog {

    private JTextField applicantNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextArea noteArea;
    private boolean okPressed = false;

    public aplikimiRiDialog(Frame owner) {
        super(owner, "Aplikim i ri", true);
        initUI();
        GUIHelper.styleComponents(this.getContentPane());

    }

    private void initUI() {
        JPanel content = new JPanel(new BorderLayout(0, 0));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;

        JLabel nameLabel = new JLabel("Kerkuesi");
        applicantNameField = new JTextField(24);
        addRow(formPanel, gbc, 0, nameLabel, applicantNameField);

        JLabel phoneLabel = new JLabel("Telefon");
        phoneField = new JTextField(24);
        addRow(formPanel, gbc, 1, phoneLabel, phoneField);

        JLabel emailLabel = new JLabel("Email");
        emailField = new JTextField(24);
        addRow(formPanel, gbc, 2, emailLabel, emailField);

        JLabel noteLabel = new JLabel("Shenim");
        noteArea = new JTextArea(5, 24);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        JScrollPane noteScroll = new JScrollPane(noteArea);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        formPanel.add(noteLabel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(noteScroll, gbc);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancel = new JButton("Anulo");
        JButton ok = new JButton("Ruaj");
        buttons.add(cancel);
        buttons.add(ok);

        cancel.addActionListener(e -> {
            okPressed = false;
            dispose();
        });
        ok.addActionListener(e -> {
            String name = getApplicantName();
            String phone = getPhone();
            String email = getEmail();

            if (name == null || name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Shkruaj emrin e kerkuesit.", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (phone.equals("--") || !phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Numri i telefonit duhet të përmbajë saktësisht 10 shifra.", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (email.equals("--") || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(this, "Vendosni një email të vlefshëm.", "Gabim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            okPressed = true;
            dispose();
        });

        content.add(formPanel, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);
        setContentPane(content);
        pack();
        setMinimumSize(new Dimension(420, 320));
        setLocationRelativeTo(getOwner());
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

    public boolean isOkPressed() {
        return okPressed;
    }

    public String getApplicantName() {
        return applicantNameField.getText() == null ? null : applicantNameField.getText().trim();
    }

    public String getPhone() {
        String v = phoneField.getText();
        return (v == null || v.trim().isEmpty()) ? "--" : v.trim();
    }

    public String getEmail() {
        String v = emailField.getText();
        return (v == null || v.trim().isEmpty()) ? "--" : v.trim();
    }

    public String getNote() {
        String v = noteArea.getText();
        return (v == null || v.trim().isEmpty()) ? "--" : v.trim();
    }
}
