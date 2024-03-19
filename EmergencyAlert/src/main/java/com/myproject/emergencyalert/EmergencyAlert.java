package com.myproject.emergencyalert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmergencyAlert extends JFrame implements ActionListener {
    private JComboBox<String> emergencyTypeComboBox;
    private JTextArea logTextArea;

    public EmergencyAlert() {
        setTitle("EMERGENCY ALERT SYSTEM");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background color
        getContentPane().setBackground(Color.pink);

        // Emergency type selection
        String[] emergencyTypes = {"Fire", "Medical", "Security", "Civil Unrest", "Public Health Emergencies",
                "Technological Accidents", "Search and Rescue Operations",
                "Mass Casualty Incidents", "Environmental Emergencies",
                "Infrastructure Failures", "Transportation Accidents", "Utility Failures"};
        emergencyTypeComboBox = new JComboBox<>(emergencyTypes);
        add(emergencyTypeComboBox);

        // Trigger Button
        JButton triggerButton = new JButton("Trigger Alert");
        triggerButton.addActionListener(this);
        triggerButton.setBackground(Color.yellow);
        add(triggerButton);

        // Log text area
        logTextArea = new JTextArea(10, 30);
        logTextArea.setEditable(false);
        add(new JScrollPane(logTextArea));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedEmergency = (String) emergencyTypeComboBox.getSelectedItem();
        logTextArea.append("Alert triggered: " + selectedEmergency + "\n");

        // Display warning message based on the selected emergency type
        String warningMessage = getWarningMessage(selectedEmergency);
        JOptionPane.showMessageDialog(this, warningMessage, "Emergency Alert", JOptionPane.WARNING_MESSAGE);
    }

    // Method to get warning message based on selected emergency type
    private String getWarningMessage(String emergencyType) {
        switch (emergencyType) {
            case "Fire":
                return "Fire emergency detected! Evacuate the building immediately!";
            case "Medical":
                return "Medical emergency reported! Seek medical assistance as soon as possible!";
            case "Security":
                return "Security threat detected! Take necessary security measures!";
            case "Civil Unrest":
                return "Civil unrest reported! Stay indoors and avoid the affected areas!";
            case "Public Health Emergencies":
                return "Public health emergency detected! Follow recommended health guidelines!";
            case "Technological Accidents":
                return "Technological accident reported! Stay away from the affected area!";
            case "Search and Rescue Operations":
                return "Search and rescue operation in progress! Stay clear of the area!";
            case "Mass Casualty Incidents":
                return "Mass casualty incident reported! Emergency services are responding!";
            case "Environmental Emergencies":
                return "Environmental emergency detected! Take necessary precautions!";
            case "Infrastructure Failures":
                return "Infrastructure failure reported! Exercise caution in the affected area!";
            case "Transportation Accidents":
                return "Transportation accident reported! Expect delays and follow instructions!";
            case "Utility Failures":
                return "Utility failure reported! Report any outages and take necessary measures!";
            default:
                return "Emergency alert triggered!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmergencyAlert().setVisible(true);
        });
    }
}


