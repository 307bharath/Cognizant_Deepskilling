package com.example.inventory_service.controller;

import com.example.inventory_service.client.ProductClient;
import com.example.inventory_service.dto.Product;
import com.example.inventory_service.entity.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryRepository repo;
    private final ProductClient productClient;

    public InventoryController(InventoryRepository repo, ProductClient productClient) {
        this.repo = repo;
        this.productClient = productClient;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
        Product product = productClient.getProduct(inventory.getProductId());
        if (product == null) return ResponseEntity.badRequest().body("Product not found");

        Inventory saved = repo.save(inventory);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return repo.findAll();
    }
}