package com.example.tanvi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private List<String> productList = new ArrayList<>(List.of("Laptop", "Mobile", "purse"));

    @GetMapping("/hello")
    public String hello() {
        return "<h1>hi</h1>";
    }

    @GetMapping("/products")
    public List<String> getProducts() {
        return productList;
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody String product) {
        productList.add(product);
        return "Product added: " + product;
    }

    @DeleteMapping("/product/{product}")
    public List<String> deleteProduct(@PathVariable String product) {
        productList.remove(product);
        return productList;
    }
}
