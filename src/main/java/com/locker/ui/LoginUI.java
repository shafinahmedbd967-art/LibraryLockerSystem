package com.locker.ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    JFrame frame;

    public LoginUI() {
        frame = new JFrame("Smart Library Locker System");

        // Main Panel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Gradient Background
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(20, 30, 60),
                        0, getHeight(), new Color(60, 90, 150)
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("Library Locker System");
        title.setBounds(100, 40, 300, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        // Subtitle
        JLabel subtitle = new JLabel("Secure • Smart • Automated");
        subtitle.setBounds(120, 70, 300, 20);
        subtitle.setForeground(Color.LIGHT_GRAY);

        // Username
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(80, 130, 100, 20);
        userLabel.setForeground(Color.WHITE);

        JTextField userField = new JTextField();
        userField.setBounds(80, 150, 280, 35);
        userField.setBorder(BorderFactory.createEmptyBorder());

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(80, 200, 100, 20);
        passLabel.setForeground(Color.WHITE);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(80, 220, 280, 35);
        passField.setBorder(BorderFactory.createEmptyBorder());

        // Login Button
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(80, 280, 280, 40);
        loginBtn.setBackground(new Color(0, 153, 255));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Action
        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                frame.dispose(); // close login
                new DashboardUI(); // open dashboard
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
            }
        });

        // Add components
        panel.add(title);
        panel.add(subtitle);
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginBtn);

        frame.add(panel);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}