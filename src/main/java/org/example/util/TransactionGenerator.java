package org.example.util;

public class TransactionGenerator {

    private static int transactionCounter = 1000;

    private TransactionGenerator() {
        // Prevent object creation
    }

    public static String generateTransactionId() {

        transactionCounter++;

        return "TXN" + transactionCounter;
    }
}