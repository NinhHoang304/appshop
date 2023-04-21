package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String name;
    @Column(columnDefinition = "bit(1)")
    private boolean gender;
    @Column(columnDefinition = "date", nullable = false)
    private String dateOfBirth;
    @Column(columnDefinition = "varchar(45)", nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "varchar(45)", nullable = false, unique = true)
    private String phone;
    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String address;
    @JsonIgnore
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;
    @Column(columnDefinition = "bit(1)")
    private boolean deleted;
    @JsonBackReference
    @OneToMany(mappedBy = "account")
    private Set<Orders> ordersSet;
    @JsonBackReference
    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoleSet;

    public Account() {
    }

    public Account(Long id, String name, boolean gender, String dateOfBirth, String email, String phone,
                   String address, String password, boolean deleted, Set<Orders> ordersSet, Set<AccountRole> accountRoleSet) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.deleted = deleted;
        this.ordersSet = ordersSet;
        this.accountRoleSet = accountRoleSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }
}
