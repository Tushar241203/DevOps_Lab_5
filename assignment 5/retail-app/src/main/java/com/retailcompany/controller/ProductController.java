package com.retailcompany.controller;

import com.retailcompany.entity.Product;
import com.retailcompany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }
    
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String q) {
        return productService.searchProducts(q);
    }
    
    @GetMapping("/out-of-stock")
    public List<Product> getOutOfStockProducts() {
        return productService.getOutOfStockProducts();
    }
    
    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return productService.getProductsByPriceRange(min, max);
    }
    
    @GetMapping("/health")
    public String healthCheck() {
        return "Retail Application is running!";
    }
}
