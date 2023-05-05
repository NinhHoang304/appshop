package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonBackReference
    private Role role;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @JsonBackReference
    private Account account;

    public AccountRole() {
    }

    public AccountRole(Long id, Role role, Account account) {
        this.id = id;
        this.role = role;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
