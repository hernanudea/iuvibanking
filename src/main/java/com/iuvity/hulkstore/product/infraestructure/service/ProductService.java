package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    ProductEntity save(ProductEntity product);

    void remove(Long id);

}
