package com.example.payment;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentClient {

    private final Logger logger = LoggerFactory.getLogger(PaymentClient.class);
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String EXTERNAL_URL = "https://deelay.me/5000/https://jsonplaceholder.typicode.com/todos/1";

    @CircuitBreaker(name = "paymentCB", fallbackMethod = "fallbackPayment")
   public String makePayment() {
    logger.info("Simulating delay...");
    try {
        Thread.sleep(5000); // 5-second delay to trigger timeout
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class);
    logger.info("Received response: {}", response);
    return response;
}

    public String fallbackPayment(Throwable t) {
        logger.warn("Fallback triggered due to: {}", t.getMessage());
        return "Fallback response: Payment system is temporarily unavailable.";
    }
}
