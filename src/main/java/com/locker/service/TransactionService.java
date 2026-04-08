package com.locker.service;

import com.locker.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private static List<Transaction> transactions = new ArrayList<>();

    public static void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public static List<Transaction> getTransactions() {
        return transactions;
    }

    public static Transaction findActiveTransaction(String studentId, int lockerId) {
        for (Transaction t : transactions) {
            if (t.getStudentId().equals(studentId)
                    && t.getLockerId() == lockerId
                    && t.getStatus().equals("ACTIVE")) {
                return t;
            }
        }
        return null;
    }
}