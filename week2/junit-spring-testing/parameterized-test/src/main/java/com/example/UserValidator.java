package com.example;

public class UserValidator {

    // ✅ Business logic to test: names must not be null or blank and should be at least 3 characters
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 3;
    }
}
