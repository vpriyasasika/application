package org.example.util;

public class Validation {

    // Validate Account Number
    public static boolean isValidAccountNumber(long accountNumber) {
        return String.valueOf(accountNumber).length() == 10;
    }

    // Validate Customer Name
    public static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z ]{3,30}");
    }

    // Validate Mobile Number
    public static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("[6-9][0-9]{9}");
    }

    // Validate Email
    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Validate Amount
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}