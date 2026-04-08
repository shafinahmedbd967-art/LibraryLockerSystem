package com.locker.ui;

import com.locker.model.Transaction;
import com.locker.service.TransactionService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class IssueLockerUI {

    JFrame frame;

    public IssueLockerUI() {
        frame = new JFrame("Issue Locker");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 40, 70));

        // Title
        JLabel title = new JLabel("Issue Locker");
        title.setBounds(150, 20, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // Student ID
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50, 80, 100, 25);
        idLabel.setForeground(Color.WHITE);

        JTextField idField = new JTextField();
        idField.setBounds(180, 80, 180, 30);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 130, 100, 25);
        nameLabel.setForeground(Color.WHITE);

        JTextField nameField = new JTextField();
        nameField.setBounds(180, 130, 180, 30);

        // Department
        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 180, 100, 25);
        deptLabel.setForeground(Color.WHITE);

        JTextField deptField = new JTextField();
        deptField.setBounds(180, 180, 180, 30);

        // Locker ID
        JLabel lockerLabel = new JLabel("Locker No:");
        lockerLabel.setBounds(50, 230, 100, 25);
        lockerLabel.setForeground(Color.WHITE);

        JTextField lockerField = new JTextField();
        lockerField.setBounds(180, 230, 180, 30);

        // Issue Button
        JButton issueBtn = new JButton("Issue Locker");
        issueBtn.setBounds(120, 300, 180, 40);
        issueBtn.setBackground(new Color(0, 153, 255));
        issueBtn.setForeground(Color.WHITE);

        // Action
        issueBtn.addActionListener(e -> {

            String id = idField.getText();
            String name = nameField.getText();
            String dept = deptField.getText();
            String lockerText = lockerField.getText();

            if (id.isEmpty() || name.isEmpty() || dept.isEmpty() || lockerText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                return;
            }

            int lockerId;

            try {
                lockerId = Integer.parseInt(lockerText);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Locker Number!");
                return;
            }

            // Create transaction
            Transaction t = new Transaction(id, lockerId, LocalDateTime.now());
            TransactionService.addTransaction(t);

            JOptionPane.showMessageDialog(frame, "Locker Issued Successfully!");

            // Clear fields
            idField.setText("");
            nameField.setText("");
            deptField.setText("");
            lockerField.setText("");
        });

        // Add components
        panel.add(title);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(deptLabel);
        panel.add(deptField);
        panel.add(lockerLabel);
        panel.add(lockerField);
        panel.add(issueBtn);

        frame.add(panel);
        frame.setSize(450, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}