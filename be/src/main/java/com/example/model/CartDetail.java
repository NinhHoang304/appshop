package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;
    @Column(columnDefinition = "bit(1)")
    private boolean deleted;
    @Column(columnDefinition = "date")
    private String dateOfOrder;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonBackReference
    private Cart cart;

    public CartDetail() {
    }

    public CartDetail(Long id, int quantity, boolean deleted, Product product, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.deleted = deleted;
        this.product = product;
        this.cart = cart;
    }

    public CartDetail(int quantity, boolean deleted, Product product, Cart cart, String dateOfOrder) {
        this.quantity = quantity;
        this.deleted = deleted;
        this.dateOfOrder = dateOfOrder;
        this.product = product;
        this.cart = cart;
    }

    public CartDetail(int quantity, boolean deleted, Product product, Cart cart) {
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

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
