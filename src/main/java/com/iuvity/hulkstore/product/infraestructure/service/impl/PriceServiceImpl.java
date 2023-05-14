package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.PriceEntity;
import com.iuvity.hulkstore.product.domain.repositories.PriceRepository;
import com.iuvity.hulkstore.product.infraestructure.service.PriceService;
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
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;
    @Override
    public List<PriceEntity> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<PriceEntity> findById(Long id) {
        // ToDo retornar bien el Optional en todos
        return priceRepository.findById(id);
    }

    @Override
    public PriceEntity save(PriceEntity price) {
        return priceRepository.save(price);
    }

    @Override
    public void remove(Long id) {
        priceRepository.deleteById(id);
    }

    @Override
    public PriceEntity update(PriceEntity price) {
        return priceRepository.save(price);
    }
}
