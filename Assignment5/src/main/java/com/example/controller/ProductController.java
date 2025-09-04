package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return Arrays.asList(
            new Product(1, "Laptop", 999.99),
            new Product(2, "Mouse", 19.99),
            new Product(3, "Keyboard", 49.99)
        );
    }

    static class Product {
        private int id;
        private String name;
        private double price;

        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }
}
