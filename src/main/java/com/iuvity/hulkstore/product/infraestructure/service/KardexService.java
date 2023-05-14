package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KardexService {

    List<KardexEntity> findAll();

    Optional<KardexEntity> findById(Long id);

    KardexEntity save(KardexEntity kardex);

    void remove(Long id);

}
