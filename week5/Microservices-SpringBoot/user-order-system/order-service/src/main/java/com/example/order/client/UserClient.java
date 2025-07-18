package com.example.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-client", url = "http://localhost:8080/users")
public interface UserClient {
    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);
}