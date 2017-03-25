package com.mad.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Created by alex on 2/25/17.
 */
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(nullable = false)
    private Integer id;

    @Column(nullable = false) @Min(1) @Max(999999)
    private Integer price;

    @Column(nullable = false) @Min(0) @Max(999999999)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(nullable = false) @Pattern(regexp = "^[!-~][ -~]{8,253}[!-~]$")
    private String name;

    @Column(nullable = false) @Pattern(regexp = "^[!-~][ -~]{8,253}[!-~]$")
    private String description;

    public Product() {
        // JPA constructor
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
