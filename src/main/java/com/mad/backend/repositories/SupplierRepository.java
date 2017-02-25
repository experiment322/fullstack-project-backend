package com.mad.backend.repositories;

import com.mad.backend.models.Supplier;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alex on 2/25/17.
 */
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
}
