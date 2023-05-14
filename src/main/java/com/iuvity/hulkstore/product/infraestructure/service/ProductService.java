package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    ProductEntity save(ProductEntity product);

    void remove(Long id);

    ProductEntity update(ProductEntity product);
}
