package com.mad.backend.services.impls;

import com.mad.backend.dtos.SupplierDto;
import com.mad.backend.models.Supplier;
import com.mad.backend.repositories.ProductRepository;
import com.mad.backend.repositories.SupplierRepository;
import com.mad.backend.services.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    private final Logger logger;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SupplierDto> retrieveSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        supplierRepository.findAll().forEach(suppliers::add);

        List<SupplierDto> result = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            result.add(new SupplierDto(supplier));
        }

        return result;
    }

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        try {
            if (supplierDto.getId() == null) {
                Supplier supplier = supplierRepository.save(supplierDto.transformBack());
                return new SupplierDto(supplier);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error creating supplier", e);
            return null;
        }
    }

    @Override
    public SupplierDto updateSupplier(SupplierDto supplierDto) {
        try {
            if (supplierRepository.exists(supplierDto.getId())) {
                Supplier supplier = supplierRepository.save(supplierDto.transformBack());
                return new SupplierDto(supplier);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error updating supplier", e);
            return null;
        }
    }

    @Override
    public Integer deleteSupplier(Integer supplierId) {
        try {
            if (supplierRepository.exists(supplierId)) {
                productRepository.delete(supplierRepository.findOne(supplierId).getProducts());
                supplierRepository.delete(supplierId);
                return supplierId;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error deleting supplier", e);
            return null;
        }
    }
}
