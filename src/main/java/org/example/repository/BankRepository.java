package org.example.repository;

import org.example.model.Account;
import org.example.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {

    private List<Account> accounts;
    private List<Transaction> transactions;

    public BankRepository() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add Account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Get All Accounts
    public List<Account> getAllAccounts() {
        return accounts;
    }

    // Find Account by Account Number
    public Account findAccount(long accountNumber) {

        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    // Delete Account
    public boolean deleteAccount(long accountNumber) {

        Account account = findAccount(accountNumber);

        if (account != null) {
            accounts.remove(account);
            return true;
        }

        return false;
    }

    // Save Transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Get All Transactions
    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}