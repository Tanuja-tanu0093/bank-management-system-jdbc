package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.dto.Transaction;
import com.bank.util.DBConnection;

public class TransactionDao {

    // Insert Transaction
    public boolean insertTransaction(Transaction transaction) {

        String sql = "INSERT INTO transactions (user_id, type, amount, date, reference_account) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, transaction.getUserId());
            ps.setString(2, transaction.getType());
            ps.setDouble(3, transaction.getAmount());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(transaction.getDate()));
            ps.setString(5, transaction.getReferenceAccount());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Get Transaction History of a User
    public List<Transaction> getTransactionsByUserId(int userId) {

        List<Transaction> list = new ArrayList<>();

        String sql = "SELECT * FROM transactions WHERE user_id=? ORDER BY date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Transaction txn = new Transaction();

                    txn.setId(rs.getInt("id"));
                    txn.setUserId(rs.getInt("user_id"));
                    txn.setType(rs.getString("type"));
                    txn.setAmount(rs.getDouble("amount"));
                    txn.setDate(rs.getTimestamp("date").toLocalDateTime());
                    txn.setReferenceAccount(rs.getString("reference_account"));

                    list.add(txn);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}