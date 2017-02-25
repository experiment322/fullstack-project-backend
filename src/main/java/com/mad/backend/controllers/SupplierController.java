package com.mad.backend.controllers;

import com.mad.backend.dtos.SupplierDto;
import com.mad.backend.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SupplierDto> listSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createSupplier(@RequestBody SupplierDto supplierDto) {
        supplierService.createSupplier(supplierDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateSupplier(@RequestBody SupplierDto supplierDto) {
        supplierService.updateSupplier(supplierDto);
    }

    @RequestMapping(value = "/delete/{supplierId}", method = RequestMethod.DELETE)
    public void deleteSupplier(@PathVariable Integer supplierId) {
        supplierService.deleteSupplier(supplierId);
    }
}
