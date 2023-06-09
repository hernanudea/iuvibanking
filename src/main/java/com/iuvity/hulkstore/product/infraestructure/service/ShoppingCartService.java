package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.ShoppingCartEntity;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<ShoppingCartEntity> findAll();

    Optional<ShoppingCartEntity> findById(Long id);

    ShoppingCartEntity save(ShoppingCartEntity shoppingCart);

    void remove(Long id);
}
