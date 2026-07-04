package org.example.util;

import java.time.Year;

public class UTRGenerator {

    private static long counter = 100000;

    private UTRGenerator() {
        // Prevent object creation
    }

    public static String generateUTR() {

        counter++;

        return "UTR" + Year.now().getValue() + counter;
    }
}