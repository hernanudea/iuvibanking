package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.StockEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StockService {
    List<StockEntity> findAll();

    Optional<StockEntity> findById(Long id);

    StockEntity save(StockEntity stock);

    void remove(Long id);
}
