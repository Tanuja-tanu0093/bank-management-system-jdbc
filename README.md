# Bank Management System (JDBC + Servlet + JSP)

## 📌 Project Overview

The **Bank Management System** is a web-based application developed using **Java, JDBC, Servlets, JSP, and MySQL**.
This system allows users to perform basic banking operations such as account creation, login, deposit, withdrawal, fund transfer, and transaction history management.

The project follows the **MVC architecture (Model–View–Controller)** to maintain proper separation of concerns and improve code maintainability.

---

## 🚀 Features

* Customer Registration
* Secure Login using Email and PIN
* Deposit Money
* Withdraw Money
* Transfer Funds between Accounts
* View Account Balance
* View Transaction History
* Update Customer Profile
* Update PIN
* Logout functionality

---

## 🏗️ Project Architecture

The project is built using the **MVC architecture pattern**.

**Model Layer**

* DTO Classes (Customer, Transaction)

**DAO Layer**

* CustomerDao
* TransactionDao

**Service Layer**

* CustomerService

**Controller Layer**

* Servlets (LoginServlet, RegisterServlet, DepositServlet, WithdrawServlet, TransferServlet, LogoutServlet)

**View Layer**

* JSP Pages (login.jsp, register.jsp, dashboard.jsp, deposit.jsp, withdraw.jsp, transfer.jsp)

---

## 🛠️ Technologies Used

* Java
* JDBC
* Servlets
* JSP
* MySQL
* Apache Tomcat
* Maven
* HTML / CSS

---

## 📂 Project Structure

```
Bank-Management-System-Jdbc
│
├── src/main/java
│   ├── controller
│   │   ├── LoginServlet.java
│   │   ├── RegisterServlet.java
│   │   ├── DepositServlet.java
│   │   ├── WithdrawServlet.java
│   │   ├── TransferServlet.java
│   │   └── LogoutServlet.java
│   │
│   ├── dao
│   │   ├── CustomerDao.java
│   │   └── TransactionDao.java
│   │
│   ├── service
│   │   └── CustomerService.java
│   │
│   ├── dto
│   │   ├── Customer.java
│   │   └── Transaction.java
│   │
│   └── util
│       └── DBConnection.java
│
├── src/main/webapp
│   ├── index.jsp
│   ├── jsp
│   │   ├── login.jsp
│   │   ├── register.jsp
│   │   ├── dashboard.jsp
│   │   ├── deposit.jsp
│   │   ├── withdraw.jsp
│   │   └── transfer.jsp
│   │
│   └── WEB-INF
│       └── web.xml
│
└── pom.xml
```

---

## 🗄️ Database Design

### Customer Table

```
customer
---------------------------
id (PK)
account_number
name
email
pin
balance
```

### Transactions Table

```
transactions
---------------------------
id (PK)
user_id
type
amount
date
reference_account
```

---

## ▶️ How to Run the Project

1. Install **Java (JDK 17 or higher)**
2. Install **MySQL Server**
3. Install **Apache Tomcat 9**
4. Import project into **Eclipse IDE**
5. Create database in MySQL
6. Configure database connection in `DBConnection.java`
7. Run project on Tomcat Server
8. Open in browser:

```
http://localhost:8080/bank-management-system-jdbc/
```

---

## 🔐 Future Enhancements

* Password encryption
* Admin dashboard
* Account number auto-generation
* Improved UI using Bootstrap
* Transaction rollback safety
* REST API integration

---

## 👩‍💻 Author

**Miss Tanuja**
MCA Student | Java Full Stack Enthusiast

---

## ⭐ Acknowledgement

This project was developed as part of learning **Java Web Development and JDBC-based applications**.
