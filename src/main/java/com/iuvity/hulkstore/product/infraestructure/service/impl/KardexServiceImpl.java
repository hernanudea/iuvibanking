package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import com.iuvity.hulkstore.product.domain.repositories.KardexRepository;
import com.iuvity.hulkstore.product.infraestructure.service.KardexService;
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
public class KardexServiceImpl implements KardexService {

    private final KardexRepository kardexRepository;

    @Override
    @Transactional(readOnly = true)
    public List<KardexEntity> findAll() {
        return kardexRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<KardexEntity> findById(Long id) {
        return Optional.ofNullable(kardexRepository.findById(id).orElse(null));
    }

    @Override
    public KardexEntity save(KardexEntity kardex) {
        return kardexRepository.save(kardex);
    }

    @Override
    public void remove(Long id) {
        kardexRepository.deleteById(id);
    }

}
