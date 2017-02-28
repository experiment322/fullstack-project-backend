package com.mad.backend.services;

import com.mad.backend.dtos.SupplierDto;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
public interface SupplierService {

    List<SupplierDto> getAllSuppliers();

    SupplierDto createSupplier(SupplierDto supplierDto);

    SupplierDto updateSupplier(SupplierDto supplierDto);

    SupplierDto deleteSupplier(Integer supplierId);
}
