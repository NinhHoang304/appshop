package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/public")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product/list")
    public ResponseEntity<Page<Product>> getAllProduct(@RequestParam(required = false, defaultValue = "") String name,
                                                       @RequestParam(required = false, defaultValue = "0") Long categoryId,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("dateOfCreate")));
        Page<Product> productPage;

        if (categoryId == 0) {
            productPage = this.productService.findProductByName(name, pageable);
        } else {
            productPage = this.productService.findProducts(name, categoryId, pageable);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/product/detail/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = this.productService.findProductById(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
