package com.retailcompany.repository;

import com.retailcompany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findByName(String name);
    
    List<Product> findByCategory(String category);
    
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
    List<Product> findByStockQuantityGreaterThan(Integer quantity);
    
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Product> searchProducts(@Param("searchTerm") String searchTerm);
    
    @Query("SELECT p FROM Product p WHERE p.stockQuantity = 0")
    List<Product> findOutOfStockProducts();
}
