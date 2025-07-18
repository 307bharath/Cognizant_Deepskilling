package com.example.billing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    @GetMapping("/api/v1/charge")
    public String charge() {
        return "Billing charged ₹500 to Bharadwaj";
    }
}
