package com.locker.ui;

import com.locker.model.Transaction;
import com.locker.service.TransactionService;
import com.locker.utils.TimeUtil;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class ReturnLockerUI {

    JFrame frame;

    public ReturnLockerUI() {
        frame = new JFrame("Return Locker");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(40, 50, 90));

        // Title
        JLabel title = new JLabel("Return Locker");
        title.setBounds(140, 20, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // Student ID
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50, 80, 100, 25);
        idLabel.setForeground(Color.WHITE);

        JTextField idField = new JTextField();
        idField.setBounds(180, 80, 180, 30);

        // Locker ID
        JLabel lockerLabel = new JLabel("Locker No:");
        lockerLabel.setBounds(50, 130, 100, 25);
        lockerLabel.setForeground(Color.WHITE);

        JTextField lockerField = new JTextField();
        lockerField.setBounds(180, 130, 180, 30);

        // Return Button
        JButton returnBtn = new JButton("Return Locker");
        returnBtn.setBounds(120, 200, 180, 40);
        returnBtn.setBackground(new Color(0, 153, 255));
        returnBtn.setForeground(Color.WHITE);

        // Action
        returnBtn.addActionListener(e -> {

            if (!TimeUtil.isWithinAllowedTime()) {
                JOptionPane.showMessageDialog(frame,
                        "Return allowed only between 8 AM to 8 PM!");
                return;
            }

            String id = idField.getText();
            String lockerText = lockerField.getText();

            if (id.isEmpty() || lockerText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fill all fields!");
                return;
            }

            int lockerId;

            try {
                lockerId = Integer.parseInt(lockerText);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid locker number!");
                return;
            }

            Transaction t = TransactionService.findActiveTransaction(id, lockerId);

            if (t == null) {
                JOptionPane.showMessageDialog(frame, "No active record found!");
                return;
            }

            // Update return
            t.setReturnTime(LocalDateTime.now());
            t.setStatus("RETURNED");

            JOptionPane.showMessageDialog(frame, "Locker Returned Successfully!");

            idField.setText("");
            lockerField.setText("");
        });

        // Add components
        panel.add(title);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(lockerLabel);
        panel.add(lockerField);
        panel.add(returnBtn);

        frame.add(panel);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}