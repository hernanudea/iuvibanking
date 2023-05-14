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
    @Transactional(readOnly = true)
    public List<PriceEntity> findAll() {
        return priceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PriceEntity> findById(Long id) {
        return Optional.ofNullable(priceRepository.findById(id).orElse(null));
    }

    @Override
    public PriceEntity save(PriceEntity price) {
        return priceRepository.save(price);
    }

    @Override
    public void remove(Long id) {
        priceRepository.deleteById(id);
    }

}
