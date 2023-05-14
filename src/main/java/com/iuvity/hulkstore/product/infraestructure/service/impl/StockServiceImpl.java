package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.StockEntity;
import com.iuvity.hulkstore.product.domain.repositories.StockRepository;
import com.iuvity.hulkstore.product.infraestructure.service.StockService;
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
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    @Override
    public List<StockEntity> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<StockEntity> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public StockEntity save(StockEntity stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void remove(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public StockEntity update(StockEntity stock) {
        return stockRepository.save(stock);
    }
}
