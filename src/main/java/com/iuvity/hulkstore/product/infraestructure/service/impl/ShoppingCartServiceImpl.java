package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.ShoppingCartEntity;
import com.iuvity.hulkstore.product.domain.repositories.ShoppingCartRepository;
import com.iuvity.hulkstore.product.infraestructure.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ShoppingCartEntity> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ShoppingCartEntity> findById(Long id) {
        return Optional.ofNullable(shoppingCartRepository.findById(id).orElse(null));
    }

    @Override
    public ShoppingCartEntity save(ShoppingCartEntity shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void remove(Long id) {
        shoppingCartRepository.deleteById(id);
    }

}
