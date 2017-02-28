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
        // initialize with non-existing ids to prevent exception throwing when used by repositories
        this.id = -1;
    }

    public SupplierDto(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.address = supplier.getAddress();
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
