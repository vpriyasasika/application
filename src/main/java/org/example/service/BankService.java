package org.example.service;

import org.example.exception.DuplicateAccountException;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.InvalidAccountException;
import org.example.model.Account;
import org.example.repository.BankRepository;

import java.util.List;

public class BankService {

    private BankRepository repository = new BankRepository();

    // Create Account
    public void createAccount(Account account) throws DuplicateAccountException {

        Account existingAccount =
                repository.findAccount(account.getAccountNumber());

        if (existingAccount != null) {
            throw new DuplicateAccountException("Account already exists.");
        }

        repository.addAccount(account);
        System.out.println("Account Created Successfully.");
    }

    // Deposit
    public void deposit(long accountNumber, double amount)
            throws InvalidAccountException {

        Account account = repository.findAccount(accountNumber);

        if (account == null) {
            throw new InvalidAccountException("Invalid Account Number.");
        }

        account.setBalance(account.getBalance() + amount);

        System.out.println("Amount Deposited Successfully.");
    }

    // Withdraw
    public void withdraw(long accountNumber, double amount)
            throws InvalidAccountException,
            InsufficientBalanceException {

        Account account = repository.findAccount(accountNumber);

        if (account == null) {
            throw new InvalidAccountException("Invalid Account Number.");
        }

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance.");
        }

        account.setBalance(account.getBalance() - amount);

        System.out.println("Amount Withdrawn Successfully.");
    }

    // Check Balance
    public double checkBalance(long accountNumber)
            throws InvalidAccountException {

        Account account = repository.findAccount(accountNumber);

        if (account == null) {
            throw new InvalidAccountException("Invalid Account Number.");
        }

        return account.getBalance();
    }

    // Search Account
    public Account searchAccount(long accountNumber)
            throws InvalidAccountException {

        Account account = repository.findAccount(accountNumber);

        if (account == null) {
            throw new InvalidAccountException("Invalid Account Number.");
        }

        return account;
    }

    // Delete Account
    public void deleteAccount(long accountNumber)
            throws InvalidAccountException {

        boolean deleted = repository.deleteAccount(accountNumber);

        if (!deleted) {
            throw new InvalidAccountException("Invalid Account Number.");
        }

        System.out.println("Account Deleted Successfully.");
    }

    // View All Accounts
    public List<Account> getAllAccounts() {
        return repository.getAllAccounts();
    }
}a