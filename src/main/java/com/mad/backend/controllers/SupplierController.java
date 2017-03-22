package com.mad.backend.controllers;

import com.mad.backend.dtos.ResponseDto;
import com.mad.backend.dtos.SupplierDto;
import com.mad.backend.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
@RestController
@RequestMapping(value = "/api/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseDto<List<SupplierDto>> retrieveSuppliers() {
        return new ResponseDto<>(supplierService.retrieveSuppliers());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseDto<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto) {
        return new ResponseDto<>(supplierService.createSupplier(supplierDto));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDto<SupplierDto> updateSupplier(@RequestBody SupplierDto supplierDto) {
        return new ResponseDto<>(supplierService.updateSupplier(supplierDto));
    }

    @RequestMapping(value = "/delete/{supplierId}", method = RequestMethod.DELETE)
    public ResponseDto<Integer> deleteSupplier(@PathVariable Integer supplierId) {
        return new ResponseDto<>(supplierService.deleteSupplier(supplierId));
    }
}
