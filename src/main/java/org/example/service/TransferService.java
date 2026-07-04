package org.example.service;

import org.example.exception.InsufficientBalanceException;
import org.example.exception.InvalidAccountException;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.repository.BankRepository;
import org.example.util.TransactionGenerator;
import org.example.util.UTRGenerator;

import java.time.LocalDateTime;

public class TransferService {

    private BankRepository repository = new BankRepository();

    public void transferMoney(long fromAccountNumber,
                              long toAccountNumber,
                              double amount)
            throws InvalidAccountException,
            InsufficientBalanceException {

        Account sender = repository.findAccount(fromAccountNumber);
        Account receiver = repository.findAccount(toAccountNumber);

        if (sender == null) {
            throw new InvalidAccountException("Sender account not found.");
        }

        if (receiver == null) {
            throw new InvalidAccountException("Receiver account not found.");
        }

        if (sender.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance.");
        }

        // Debit sender
        sender.setBalance(sender.getBalance() - amount);

        // Credit receiver
        receiver.setBalance(receiver.getBalance() + amount);

        // Create Transaction
        Transaction transaction = new Transaction(
                TransactionGenerator.generateTransactionId(),
                fromAccountNumber,
                toAccountNumber,
                amount,
                "TRANSFER",
                UTRGenerator.generateUTR(),
                LocalDateTime.now()
        );

        // Save Transaction
        repository.addTransaction(transaction);

        System.out.println("Money Transferred Successfully.");
        System.out.println("Transaction ID : " + transaction.getTransactionId());
        System.out.println("UTR Number     : " + transaction.getUtrNumber());
    }
}