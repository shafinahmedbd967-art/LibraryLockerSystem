package com.locker.model;

import java.time.LocalDateTime;

public class Transaction {
    private String studentId;
    private int lockerId;
    private LocalDateTime issueTime;
    private LocalDateTime returnTime;
    private String status;

    public Transaction(String studentId, int lockerId, LocalDateTime issueTime) {
        this.studentId = studentId;
        this.lockerId = lockerId;
        this.issueTime = issueTime;
        this.status = "ACTIVE";
    }

    public String getStudentId() { return studentId; }
    public int getLockerId() { return lockerId; }
    public LocalDateTime getIssueTime() { return issueTime; }

    public LocalDateTime getReturnTime() { return returnTime; }
    public void setReturnTime(LocalDateTime returnTime) { this.returnTime = returnTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}