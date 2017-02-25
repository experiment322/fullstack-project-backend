package com.mad.backend.services;

import com.mad.backend.dtos.SupplierDto;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
public interface SupplierService {

    public List<SupplierDto> getAllSuppliers();

    public void createSupplier(SupplierDto supplierDto);

    public void updateSupplier(SupplierDto supplierDto);

    public void deleteSupplier(Integer supplierId);
}
