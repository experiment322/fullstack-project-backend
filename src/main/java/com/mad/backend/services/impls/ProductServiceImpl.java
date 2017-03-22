package com.mad.backend.services.impls;

import com.mad.backend.dtos.ProductDto;
import com.mad.backend.models.Product;
import com.mad.backend.repositories.ProductRepository;
import com.mad.backend.repositories.SupplierRepository;
import com.mad.backend.services.ProductService;
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
public class ProductServiceImpl implements ProductService {

    private final Logger logger;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<ProductDto> retrieveProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);

        List<ProductDto> result = new ArrayList<>();
        for (Product product : products) {
            result.add(new ProductDto(product));
        }

        return result;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        try {
            if (productDto.getId() == null && supplierRepository.exists(productDto.getSupplierId())) {
                Product product = productRepository.save(productDto.transformBack());
                return new ProductDto(product);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error creating product", e);
            return null;
        }
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        try {
            if (productRepository.exists(productDto.getId()) && supplierRepository.exists(productDto.getSupplierId())) {
                Product product = productRepository.save(productDto.transformBack());
                return new ProductDto(product);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error updating product", e);
            return null;
        }
    }

    @Override
    public Integer deleteProduct(Integer productId) {
        try {
            if (productRepository.exists(productId)) {
                productRepository.delete(productId);
                return productId;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error deleting product", e);
            return null;
        }
    }
}
