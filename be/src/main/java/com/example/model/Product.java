package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted = false")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)", nullable = false, unique = true)
    private String code;
    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String brand;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String image;
    @Column(columnDefinition = "bit(1)")
    private boolean deleted;
    @Column(columnDefinition = "date")
    private String dateOfCreate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<CartDetail> cartDetailSet;

    public Product(Long id) {
        this.id = id;
    }

    public Product() {
    }

    public Product(Long id, String code, String name, double price, int quantity, String brand,
                   String description, String image, boolean deleted, Category category, Set<CartDetail> cartDetailSet) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.deleted = deleted;
        this.category = category;
        this.cartDetailSet = cartDetailSet;
    }

    public Product(Long id, String code, String name, double price, int quantity, String brand, String description,
                   String image, boolean deleted, String dateOfCreate, Category category, Set<CartDetail> cartDetailSet) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.deleted = deleted;
        this.dateOfCreate = dateOfCreate;
        this.category = category;
        this.cartDetailSet = cartDetailSet;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<CartDetail> getOrderDetailSet() {
        return cartDetailSet;
    }

    public void setOrderDetailSet(Set<CartDetail> cartDetailSet) {
        this.cartDetailSet = cartDetailSet;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Set<CartDetail> getCartDetailSet() {
        return cartDetailSet;
    }

    public void setCartDetailSet(Set<CartDetail> cartDetailSet) {
        this.cartDetailSet = cartDetailSet;
    }
}
