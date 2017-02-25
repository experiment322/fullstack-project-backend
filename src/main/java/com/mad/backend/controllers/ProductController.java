package com.mad.backend.controllers;

import com.mad.backend.dtos.ProductDto;
import com.mad.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 2/25/17.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ProductDto> listProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
    }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
}
