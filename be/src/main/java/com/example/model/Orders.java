package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)", nullable = false, unique = true)
    private String codeOrder;
    @Column(columnDefinition = "date", nullable = false)
    private String dateOrder;
    @Column(columnDefinition = "bit(1)")
    private boolean deleted;
    @JsonBackReference
    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> orderDetailSet;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    public Orders() {
    }

    public Orders(Long id, String codeOrder, String dateOrder, boolean deleted, Set<OrderDetail> orderDetailSet, Account account) {
        this.id = id;
        this.codeOrder = codeOrder;
        this.dateOrder = dateOrder;
        this.deleted = deleted;
        this.orderDetailSet = orderDetailSet;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
