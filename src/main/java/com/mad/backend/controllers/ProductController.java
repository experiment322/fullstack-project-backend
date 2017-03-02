package com.mad.backend.controllers;

import com.mad.backend.dtos.ProductDto;
import com.mad.backend.dtos.ResponseDto;
import com.mad.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseDto<List<ProductDto>> listProducts() {
        return new ResponseDto<>(productService.getAllProducts());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseDto<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseDto<>(productService.createProduct(productDto));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDto<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return new ResponseDto<>(productService.updateProduct(productDto));
    }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    public ResponseDto<ProductDto> deleteProduct(@PathVariable Integer productId) {
        return new ResponseDto<>(productService.deleteProduct(productId));
    }
}
