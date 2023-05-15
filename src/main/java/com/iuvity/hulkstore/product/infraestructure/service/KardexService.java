package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;

import java.util.List;
import java.util.Optional;


public interface KardexService {

    List<KardexEntity> findAll();

    Optional<KardexEntity> findById(Long id);

    KardexEntity save(KardexEntity kardex);

    void remove(Long id);

}
