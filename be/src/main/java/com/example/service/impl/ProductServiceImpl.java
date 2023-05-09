package com.example.service.impl;

import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.ICategoryRepository;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Product> findProducts(String name, Long categoryId, Pageable pageable) {
        return this.productRepository.findProductByNameContainingIgnoreCaseAndCategory_Id(name, categoryId, pageable);
    }

    @Override
    public Page<Product> findProductByName(String name, Pageable pageable) {
        return this.productRepository.findProductByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Product findProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {

    }
}
