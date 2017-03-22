package com.mad.backend.dtos;

import com.mad.backend.models.Product;
import com.mad.backend.models.Supplier;

/**
 * Created by alex on 2/25/17.
 */
public class ProductDto {

    private Integer id;
    private Integer price;
    private Integer quantity;
    private Integer supplierId;
    private String name;
    private String description;

    public ProductDto() {
        // REST constructor
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.supplierId = product.getSupplier().getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }

    public Product transformBack() {
        Supplier supplier = new Supplier();
        supplier.setId(this.supplierId);

        Product product = new Product();
        product.setId(this.id);
        product.setPrice(this.price);
        product.setQuantity(this.quantity);
        product.setSupplier(supplier);
        product.setName(this.name);
        product.setDescription(this.description);

        return product;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
