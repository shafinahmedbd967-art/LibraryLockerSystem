package com.locker.ui;

import com.locker.model.Transaction;
import com.locker.service.TransactionService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminPanelUI {

    JFrame frame;
    JTable table;
    DefaultTableModel model;

    public AdminPanelUI() {

        frame = new JFrame("Admin Panel - Locker System");

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(30, 30, 60));

        // Title
        JLabel title = new JLabel("Admin Dashboard", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        // Table Columns
        String[] columns = {"Student ID", "Locker ID", "Issue Time", "Return Time", "Status"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Buttons Panel
        JPanel btnPanel = new JPanel();

        JButton refreshBtn = new JButton("Refresh Data");
        JButton activeBtn = new JButton("Show Active Only");
        JButton allBtn = new JButton("Show All");

        btnPanel.add(refreshBtn);
        btnPanel.add(activeBtn);
        btnPanel.add(allBtn);

        panel.add(btnPanel, BorderLayout.SOUTH);

        // Button Actions

        refreshBtn.addActionListener(e -> loadAllData());

        activeBtn.addActionListener(e -> loadFilteredData("ACTIVE"));

        allBtn.addActionListener(e -> loadAllData());

        // Frame settings
        frame.add(panel);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Initial load
        loadAllData();
    }

    // Load all transactions
    private void loadAllData() {
        model.setRowCount(0);

        List<Transaction> list = TransactionService.getTransactions();

        for (Transaction t : list) {
            model.addRow(new Object[]{
                    t.getStudentId(),
                    t.getLockerId(),
                    t.getIssueTime(),
                    t.getReturnTime(),
                    t.getStatus()
            });
        }
    }

    // Filter by status
    private void loadFilteredData(String status) {
        model.setRowCount(0);

        List<Transaction> list = TransactionService.getTransactions();

        for (Transaction t : list) {
            if (t.getStatus().equals(status)) {
                model.addRow(new Object[]{
                        t.getStudentId(),
                        t.getLockerId(),
                        t.getIssueTime(),
                        t.getReturnTime(),
                        t.getStatus()
                });
            }
        }
    }
}