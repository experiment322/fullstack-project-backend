package com.mad.backend.dtos;

import com.mad.backend.models.Supplier;

/**
 * Created by alex on 2/25/17.
 */
public class SupplierDto {

    private Integer id;
    private String name;
    private String address;

    public SupplierDto() {
        // REST constructor
    }

    public SupplierDto(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.address = supplier.getAddress();
    }

    public Supplier transformBack() {
        Supplier supplier = new Supplier();
        supplier.setId(this.id);
        supplier.setName(this.name);
        supplier.setAddress(this.address);

        return supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
