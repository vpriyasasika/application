package org.example.util;

import org.example.model.Transaction;

public class ReceiptPrinter {

    public static void printReceipt(Transaction transaction) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          BANK TRANSACTION RECEIPT      ");
        System.out.println("========================================");
        System.out.println("Transaction ID : " + transaction.getTransactionId());
        System.out.println("UTR Number     : " + transaction.getUtrNumber());
        System.out.println("From Account   : " + transaction.getFromAccountNumber());
        System.out.println("To Account     : " + transaction.getToAccountNumber());
        System.out.println("Amount         : ₹" + transaction.getAmount());
        System.out.println("Type           : " + transaction.getTransactionType());
        System.out.println("Date & Time    : " + transaction.getTransactionDate());
        System.out.println("========================================");
        System.out.println("      Transaction Successful");
        System.out.println("========================================");
    }
}