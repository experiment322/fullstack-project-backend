package com.mad.backend.repositories;

import com.mad.backend.models.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alex on 2/25/17.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
