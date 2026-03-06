package com.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bank.dao.CustomerDao;
import com.bank.dao.TransactionDao;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class CustomerService {

    private CustomerDao customerDao = new CustomerDao();
    private TransactionDao transactionDao = new TransactionDao();

    // Register
    public boolean register(Customer customer) {

        if (customerDao.isEmailExists(customer.getEmail())) {
            return false;
        }

        return customerDao.saveCustomer(customer);
    }

    // Login
    public Customer login(String email, String pin) {
        return customerDao.findByEmailAndPin(email, pin);
    }

    // Deposit
    public boolean deposit(int userId, double amount) {

        if (amount <= 0) {
            return false;
        }

        Customer customer = customerDao.findById(userId);

        if (customer == null) {
            return false;
        }

        double newBalance = customer.getBalance() + amount;

        boolean updated = customerDao.updateBalance(userId, newBalance);

        if (updated) {

            Transaction txn = new Transaction();
            txn.setUserId(userId);
            txn.setType("deposit");
            txn.setAmount(amount);
            txn.setDate(LocalDateTime.now());
            txn.setReferenceAccount(null);

            transactionDao.insertTransaction(txn);
        }

        return updated;
    }

    // Withdraw
    public boolean withdraw(int userId, double amount) {

        if (amount <= 0) {
            return false;
        }

        Customer customer = customerDao.findById(userId);

        if (customer == null) {
            return false;
        }

        if (customer.getBalance() < amount) {
            return false;
        }

        double newBalance = customer.getBalance() - amount;

        boolean updated = customerDao.updateBalance(userId, newBalance);

        if (updated) {

            Transaction txn = new Transaction();
            txn.setUserId(userId);
            txn.setType("withdraw");
            txn.setAmount(amount);
            txn.setDate(LocalDateTime.now());
            txn.setReferenceAccount(null);

            transactionDao.insertTransaction(txn);
        }

        return updated;
    }

    // Transfer
    public boolean transfer(int senderId, String receiverAccount, double amount) {

        if (amount <= 0) {
            return false;
        }

        Customer sender = customerDao.findById(senderId);
        Customer receiver = customerDao.findByAccountNumber(receiverAccount);

        if (sender == null || receiver == null) {
            return false;
        }

        if (sender.getAccountNumber().equals(receiverAccount)) {
            return false;
        }

        if (sender.getBalance() < amount) {
            return false;
        }

        double senderNewBalance = sender.getBalance() - amount;
        double receiverNewBalance = receiver.getBalance() + amount;

        boolean senderUpdated = customerDao.updateBalance(senderId, senderNewBalance);
        boolean receiverUpdated = customerDao.updateBalance(receiver.getId(), receiverNewBalance);

        if (senderUpdated && receiverUpdated) {

            Transaction senderTxn = new Transaction();
            senderTxn.setUserId(senderId);
            senderTxn.setType("transfer_out");
            senderTxn.setAmount(amount);
            senderTxn.setDate(LocalDateTime.now());
            senderTxn.setReferenceAccount(receiverAccount);

            transactionDao.insertTransaction(senderTxn);

            Transaction receiverTxn = new Transaction();
            receiverTxn.setUserId(receiver.getId());
            receiverTxn.setType("transfer_in");
            receiverTxn.setAmount(amount);
            receiverTxn.setDate(LocalDateTime.now());
            receiverTxn.setReferenceAccount(sender.getAccountNumber());

            transactionDao.insertTransaction(receiverTxn);

            return true;
        }

        return false;
    }

    // Check Balance
    public double checkBalance(int userId) {

        Customer customer = customerDao.findById(userId);

        if (customer != null) {
            return customer.getBalance();
        }

        return 0;
    }

    // Update Profile
    public boolean updateProfile(int userId, String name, String email) {
        return customerDao.updateProfile(userId, name, email);
    }

    // Update PIN
    public boolean updatePin(int userId, String newPin) {
        return customerDao.updatePin(userId, newPin);
    }

    // Transaction History
    public List<Transaction> getTransactions(int userId) {
        return transactionDao.getTransactionsByUserId(userId);
    }
}