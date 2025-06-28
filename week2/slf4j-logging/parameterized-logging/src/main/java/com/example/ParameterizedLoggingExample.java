package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Bharadwaj";
        int age = 25;
        double balance = 98765.34;

        logger.info("User {} has logged in.", user);
        logger.warn("User {} is {} years old.", user, age);
        logger.error("User {} has insufficient balance: {}", user, balance);
    }
}