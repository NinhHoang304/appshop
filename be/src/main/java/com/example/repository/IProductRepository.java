package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findProductByNameContainingIgnoreCaseAndCategory_Id(String name, Long categoryId, Pageable pageable);
    Page<Product> findProductByNameContainingIgnoreCase(String name, Pageable pageable);
}
