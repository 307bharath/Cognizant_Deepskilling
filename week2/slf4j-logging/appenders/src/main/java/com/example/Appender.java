package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Appender {
    private static final Logger logger = LoggerFactory.getLogger(Appender.class);

    public static void main(String[] args) {
        logger.info("This is an info message - it will appear in both console and app.log file.");
        logger.warn("This is a warning message - it will appear in both console and app.log file.");
        logger.error("This is an error message - it will appear in both console and app.log file.");
    }
}