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
    public List<ShoppingCartEntity> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public Optional<ShoppingCartEntity> findById(Long id) {
//        return Optional.empty().orElse();
        // ToDo corregir
        return shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCartEntity save(ShoppingCartEntity shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void remove(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public ShoppingCartEntity update(ShoppingCartEntity price) {
        return shoppingCartRepository.save(price);
    }
}
