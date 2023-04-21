package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "role")
    private Set<AccountRole> accountRoleSet;

    public Role() {
    }

    public Role(Long id, String name, Set<AccountRole> accountRoleSet) {
        this.id = id;
        this.name = name;
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

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }
}
