package com.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bank.dao.TransactionDao;
import com.bank.dto.Transaction;

public class TransactionService {

	private TransactionDao transactionDao = new TransactionDao();

	// 1️⃣ Create and Save Transaction (Generic Method)
	public boolean createTransaction(int userId, String type, double amount, String referenceAccount) {

		// Basic validations
		if (userId <= 0 || amount <= 0 || type == null || type.isEmpty()) {
			return false;
		}

		// Create transaction object
		Transaction transaction = new Transaction();
		transaction.setUserId(userId);
		transaction.setType(type.toLowerCase());
		transaction.setAmount(amount);
		transaction.setDate(LocalDateTime.now());
		transaction.setReferenceAccount(referenceAccount);

		return transactionDao.insertTransaction(transaction);
	}

	// 2️⃣ Deposit Transaction
	public boolean addDeposit(int userId, double amount) {
		return createTransaction(userId, "deposit", amount, null);
	}

	// 3️⃣ Withdraw Transaction
	public boolean addWithdraw(int userId, double amount) {
		return createTransaction(userId, "withdraw", amount, null);
	}

	// 4️⃣ Transfer Out Transaction
	public boolean addTransferOut(int userId, double amount, String receiverAccount) {
		return createTransaction(userId, "transfer_out", amount, receiverAccount);
	}

	// 5️⃣ Transfer In Transaction
	public boolean addTransferIn(int userId, double amount, String senderAccount) {
		return createTransaction(userId, "transfer_in", amount, senderAccount);
	}

	// 6️⃣ Get Transactions By User ID
	public List<Transaction> getTransactionsByUserId(int userId) {

		if (userId <= 0) {
			return null;
		}

		return transactionDao.getTransactionsByUserId(userId);
	}
}