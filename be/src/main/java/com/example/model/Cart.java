package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "date", nullable = false)
    private String dateOrder;

    @OneToMany(mappedBy = "cart")
    @JsonBackReference
    private Set<CartDetail> cartDetailSet;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @JsonBackReference
    private Account account;

    public Cart(Long id) {
        this.id = id;
    }

    public Cart() {

    }

    public Cart(Long id, String dateOrder, Set<CartDetail> cartDetailSet, Account account) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.cartDetailSet = cartDetailSet;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }


    public Set<CartDetail> getCartDetailSet() {
        return cartDetailSet;
    }

    public void setCartDetailSet(Set<CartDetail> cartDetailSet) {
        this.cartDetailSet = cartDetailSet;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
