package com.mad.backend.services.impls;

import com.mad.backend.dtos.ProductDto;
import com.mad.backend.models.Product;
import com.mad.backend.models.Supplier;
import com.mad.backend.repositories.ProductRepository;
import com.mad.backend.repositories.SupplierRepository;
import com.mad.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
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
        Supplier supplier = supplierRepository.findOne(productDto.getSupplierId());
        if (supplier != null) {
            Product product = new Product();
            product.setPrice(productDto.getPrice());
            product.setQuantity(productDto.getQuantity());
            product.setSupplier(supplier);
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            productRepository.save(product);
            return new ProductDto(product);
        }
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepository.findOne(productDto.getId());
        Supplier supplier = supplierRepository.findOne(productDto.getSupplierId());
        if (product != null && supplier != null) {
            product.setPrice(productDto.getPrice());
            product.setQuantity(productDto.getQuantity());
            product.setSupplier(supplier);
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            productRepository.save(product);
            return new ProductDto(product);
        }
        return null;
    }

    @Override
    public ProductDto deleteProduct(Integer productId) {
        Product product = productRepository.findOne(productId);
        if (product != null) {
            productRepository.delete(productId);
            return new ProductDto(product);
        }
        return null;
    }
}
