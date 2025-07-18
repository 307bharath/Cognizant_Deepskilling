package com.example.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/api/v1/getUser")
    public String getUser() {
        return "Customer: Bharadwaj";
    }
}
 
