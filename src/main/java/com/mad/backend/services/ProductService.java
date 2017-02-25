package com.mad.backend.services;

import com.mad.backend.dtos.ProductDto;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
public interface ProductService {

    public List<ProductDto> getAllProducts();

    public void createProduct(ProductDto productDto);

    public void updateProduct(ProductDto productDto);

    public void deleteProduct(Integer productId);
}
