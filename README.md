# 📚 Library Locker System

A Java Swing-based Smart Library Locker Management System using OOP principles and layered architecture (UI, Service, DAO).

---

## 🚀 Features

- 🎯 Issue Locker system
- 🔁 Return Locker with validation
- ⏰ Time restriction (8 AM – 8 PM)
- 👨‍💼 Admin Dashboard
- 📊 Transaction monitoring
- 🧱 Clean layered architecture

---

## 🏗️ Tech Stack

- Java (OOP)
- Java Swing (UI)
- MySQL (Database - upcoming step)
- JDBC
- IntelliJ IDEA

---

## 📂 Project Structure
---

LibraryLockerSystem/
|
├── src/
|   ├── main/
|   |   ├── java/com/locker/
|   |   |   ├── Main.java
|   |   |
|   |   |   ├── model/
|   |   |   |   ├── Student.java
|   |   |   |   ├── Locker.java
|   |   |   |   ├── Transaction.java
|   |   |
|   |   |   ├── service/
|   |   |   |   ├── LockerService.java
|   |   |   |   ├── StudentService.java
|   |   |   |   ├── TransactionService.java
|   |   |
|   |   |   ├── dao/
|   |   |   |   ├── DBConnection.java
|   |   |   |   ├── StudentDAO.java
|   |   |   |   ├── LockerDAO.java
|   |   |   |   ├── TransactionDAO.java
|   |   |
|   |   |   ├── ui/
|   |   |   |   ├── LoginUI.java
|   |   |   |   ├── DashboardUI.java
|   |   |   |   ├── IssueLockerUI.java
|   |   |   |   ├── ReturnLockerUI.java
|   |   |   |   ├── AdminPanelUI.java
|   |   |
|   |   |   ├── utils/
|   |   |       ├── TimeUtil.java
|   |   |       ├── Validator.java
|
├── resources/
|   ├── icons/
|   ├── styles/
|
├── database/
|   ├── schema.sql
|
├── .gitignore
├── README.md
└── pom.xml (optional)

---


## ▶️ How to Run

1. Clone the repository
2. Open in IntelliJ IDEA
3. Configure JDK
4. Run `Main.java`

---

## 🗄️ Database

Database integration will be added in future steps using MySQL.

---

## 👨‍💻 Author

- Shafin Ahmed
- GitHub: shafinahmedbd967-art

---

## 📌 Status

✅ Step 1–5 Completed  
⏳ Step 6 (Database Integration) In Progress

---
