package com.iuvity.hulkstore.product.infraestructure.service;

import com.iuvity.hulkstore.product.domain.entities.OperationEntity;

import java.util.List;
import java.util.Optional;

public interface OperationService {
    List<OperationEntity> findAll();

    Optional<OperationEntity> findById(Long id);

    OperationEntity save(OperationEntity operation);

    void remove(Long id);
}
