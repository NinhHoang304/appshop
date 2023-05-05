package com.example.dto;

import com.example.model.Cart;
import com.example.model.Product;

public class CartDetailDTO {
    private Long id;
    private int quantity;
    private boolean deleted;
    private Product product;
    private Cart cart;

    public CartDetailDTO() {
    }

    public CartDetailDTO(Long id, int quantity, boolean deleted, Product product, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.deleted = deleted;
        this.product = product;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
