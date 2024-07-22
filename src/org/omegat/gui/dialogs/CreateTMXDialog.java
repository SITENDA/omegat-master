package org.omegat.gui.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTMXDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> targetLanguageComboBox;
    private boolean confirmed;

    public CreateTMXDialog(Frame parent) {
        super(parent, "Create TMX Project", true);
        setLayout(new BorderLayout());

        // Dropdown for target language selection
        targetLanguageComboBox = new JComboBox<>(new String[]{"UK-UA", "FR-FR", "DE-DE", "ES-ES"});
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Target Language:"));
        inputPanel.add(targetLanguageComboBox);

        // Buttons
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                setVisible(false);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getSelectedTargetLanguage() {
        return (String) targetLanguageComboBox.getSelectedItem();
    }
}
