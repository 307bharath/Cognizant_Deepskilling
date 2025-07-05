package com.example.productfilter.controller;

import com.example.productfilter.model.Product;
import com.example.productfilter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/filter")
    public List<Product> filterProducts(
        @RequestParam(required = false) String keyword,
        @RequestParam(required = false) Integer minReview,
        @RequestParam(required = false) List<Integer> hddSizes,
        @RequestParam(required = false) List<Integer> ramSizes,
        @RequestParam(required = false) Double minCpuSpeed,
        @RequestParam(required = false) List<String> osList,
        @RequestParam(required = false) Double maxWeight,
        @RequestParam(required = false) List<String> cpuList
    ) {
        return productService.filterProducts(keyword, minReview, hddSizes, ramSizes,
                                             minCpuSpeed, osList, maxWeight, cpuList);
    }
}
