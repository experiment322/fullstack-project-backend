package com.mad.backend.services;

import com.mad.backend.dtos.ProductDto;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    ProductDto deleteProduct(Integer productId);
}
