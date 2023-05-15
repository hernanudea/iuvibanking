package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.PriceEntity;

import java.util.List;
import java.util.Optional;

public interface PriceService {
    List<PriceEntity> findAll();

    Optional<PriceEntity> findById(Long id);

    PriceEntity save(PriceEntity price);

    void remove(Long id);
}
