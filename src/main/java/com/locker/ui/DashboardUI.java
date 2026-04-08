package com.locker.ui;

import javax.swing.*;
import java.awt.*;

public class DashboardUI {

    JFrame frame;

    public DashboardUI() {
        frame = new JFrame("Dashboard - Smart Locker System");

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(15, 32, 64),
                        0, getHeight(), new Color(32, 58, 95)
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("DASHBOARD");
        title.setBounds(40, 20, 300, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        // Buttons (Cards style)
        JButton issueBtn = createButton("Issue Locker", 50, 100);
        JButton returnBtn = createButton("Return Locker", 50, 180);
        JButton adminBtn = createButton("Admin Panel", 50, 260); // ✅ Added

        // Actions
        issueBtn.addActionListener(e -> new IssueLockerUI());
        returnBtn.addActionListener(e -> new ReturnLockerUI());
        adminBtn.addActionListener(e -> new AdminPanelUI()); // ✅ Added action

        // Add components
        panel.add(title);
        panel.add(issueBtn);
        panel.add(returnBtn);
        panel.add(adminBtn);

        frame.add(panel);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Reusable button design
    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 280, 50);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(0, 153, 255));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return btn;
    }
}