package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findProducts(String name, Long categoryId, Pageable pageable);

    Page<Product> findProductByName(String name, Pageable pageable);

    Product findProductById(Long id);
}
